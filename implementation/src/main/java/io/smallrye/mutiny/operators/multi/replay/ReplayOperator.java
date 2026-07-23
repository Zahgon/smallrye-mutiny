package io.smallrye.mutiny.operators.multi.replay;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.Subscriptions;
import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class ReplayOperator<T> extends AbstractMulti<T> {

    private final Multi<T> upstream;

    private final AppendOnlyReplayList replayList;

    private final AtomicBoolean upstreamSubscriptionRequested = new AtomicBoolean();

    private volatile Subscription upstreamSubscription = null;

    protected final CopyOnWriteArrayList<ReplaySubscription> subscriptions = new CopyOnWriteArrayList<>();

    public ReplayOperator(Multi<T> upstream, long numberOfItemsToReplay) {
        this.upstream = upstream;
        this.replayList = new AppendOnlyReplayList(numberOfItemsToReplay);
    }

    public ReplayOperator(Multi<T> upstream, long numberOfItemsToReplay, Iterable<T> seed) {
        this.upstream = upstream;
        this.replayList = new AppendOnlyReplayList(numberOfItemsToReplay, seed);
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected class ReplaySubscription implements Subscription {

        private final MultiSubscriber<? super T> downstream;

        private final AtomicLong demand = new AtomicLong();

        private volatile boolean done = false;

        private final AppendOnlyReplayList.Cursor cursor;

        private ReplaySubscription(MultiSubscriber<? super T> downstream) {
            this.downstream = downstream;
            this.cursor = replayList.newCursor();
            // Try to catch the replay stream at subscription time if ready
            this.cursor.hasNext();
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private final AtomicInteger wip = new AtomicInteger();

        @SuppressWarnings("unchecked")
        private void drain() {
            if (done) {
                return;
            }
            if (wip.getAndIncrement() > 0) {
                return;
            }
            while (true) {
                if (done) {
                    return;
                }
                long max = demand.get();
                long emitted = 0;
                while (emitted < max && cursor.hasNext()) {
                    if (done) {
                        return;
                    }
                    cursor.moveToNext();
                    if (cursor.hasReachedCompletion()) {
                        cancel();
                        cursor.readCompletion();
                        downstream.onComplete();
                        return;
                    }
                    if (cursor.hasReachedFailure()) {
                        cancel();
                        downstream.onFailure(cursor.readFailure());
                        return;
                    }
                    T item = (T) cursor.read();
                    // Invariant enforced by AppendOnlyReplayList
                    assert item != null;
                    downstream.onItem(item);
                    emitted++;
                }
                if (!done && cursor.willReachCompletion()) {
                    cancel();
                    cursor.moveToNext();
                    cursor.readCompletion();
                    downstream.onComplete();
                    return;
                }
                if (!done && cursor.willReachFailure()) {
                    cancel();
                    cursor.moveToNext();
                    downstream.onFailure(cursor.readFailure());
                    return;
                }
                Subscriptions.produced(demand, emitted);
                if (wip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }

    protected class UpstreamSubscriber implements MultiSubscriber<T>, ContextSupport {

        private final MultiSubscriber<? super T> initialSubscriber;

        public UpstreamSubscriber(MultiSubscriber<? super T> initialSubscriber) {
            this.initialSubscriber = initialSubscriber;
        }

        @Override
        public void onItem(T item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onSubscribe(Subscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Context context() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void triggerDrainLoops() {
            subscriptions.forEach(ReplaySubscription::drain);
        }

        private void markAsDone() {
            upstreamSubscription = Subscriptions.CANCELLED;
        }
    }
}

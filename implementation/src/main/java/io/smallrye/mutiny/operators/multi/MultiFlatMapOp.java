package io.smallrye.mutiny.operators.multi;

import java.util.Queue;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.*;
import java.util.function.Function;
import java.util.function.Supplier;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.helpers.Subscriptions;
import io.smallrye.mutiny.helpers.queues.Queues;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public final class MultiFlatMapOp<I, O> extends AbstractMultiOperator<I, O> {

    private final Function<? super I, ? extends Flow.Publisher<? extends O>> mapper;

    private final boolean postponeFailurePropagation;

    private final int maxConcurrency;

    private final int requests;

    public MultiFlatMapOp(Multi<? extends I> upstream, Function<? super I, ? extends Flow.Publisher<? extends O>> mapper,
            boolean postponeFailurePropagation, int maxConcurrency, int requests) {
        super(upstream);
        this.mapper = ParameterValidation.nonNull(mapper, "mapper");
        this.postponeFailurePropagation = postponeFailurePropagation;
        this.maxConcurrency = ParameterValidation.positive(maxConcurrency, "maxConcurrency");
        this.requests = ParameterValidation.positive(requests, "requests");
    }

    @Override
    public void subscribe(MultiSubscriber<? super O> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static final class FlatMapMainSubscriber<I, O> extends FlatMapManager<FlatMapInner<O>>
            implements MultiSubscriber<I>, Subscription, ContextSupport {

        final boolean delayError;

        final int maxConcurrency;

        final int requests;

        final int limit;

        final Function<? super I, ? extends Flow.Publisher<? extends O>> mapper;

        final Supplier<? extends Queue<O>> innerQueueSupplier;

        final MultiSubscriber<? super O> downstream;

        final AtomicReference<Throwable> failures = new AtomicReference<>();

        volatile boolean done;

        volatile boolean cancelled;

        volatile Subscription upstream = null;

        private static final AtomicReferenceFieldUpdater<FlatMapMainSubscriber, Subscription> UPSTREAM_UPDATER = AtomicReferenceFieldUpdater
                .newUpdater(FlatMapMainSubscriber.class, Subscription.class, "upstream");

        AtomicLong requested = new AtomicLong();

        AtomicInteger wip = new AtomicInteger();

        @SuppressWarnings("rawtypes")
        static final FlatMapInner[] EMPTY_INNER_ARRAY = new FlatMapInner[0];

        @SuppressWarnings("rawtypes")
        static final FlatMapInner[] TERMINATED_INNER_ARRAY = new FlatMapInner[0];

        int lastIndex;

        public FlatMapMainSubscriber(MultiSubscriber<? super O> downstream,
                Function<? super I, ? extends Flow.Publisher<? extends O>> mapper, boolean delayError, int concurrency,
                int requests) {
            this.downstream = downstream;
            this.mapper = mapper;
            this.delayError = delayError;
            this.maxConcurrency = concurrency;
            this.requests = requests;
            this.innerQueueSupplier = requests == 0 ? Queues.getXsQueueSupplier() : Queues.get(requests);
            this.limit = Subscriptions.unboundedOrLimit(concurrency);
        }

        @SuppressWarnings("unchecked")
        @Override
        FlatMapInner<O>[] empty() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings("unchecked")
        @Override
        FlatMapInner<O>[] terminated() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings("unchecked")
        @Override
        FlatMapInner<O>[] newArray(int size) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        void setIndex(FlatMapInner<O> entry, int index) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        void unsubscribeEntry(FlatMapInner<O> entry, boolean fromOnError) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onSubscribe(Subscription s) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(I item) {
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

        void tryEmit(FlatMapInner<O> inner, O item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void drain() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void drainLoop() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void cancelUpstream(boolean fromOnError) {
            Subscription subscription = UPSTREAM_UPDATER.getAndSet(this, Subscriptions.CANCELLED);
            if (subscription != null) {
                subscription.cancel();
                FlatMapInner<O>[] currentInners = inners.get();
                for (FlatMapInner<O> inner : currentInners) {
                    if (inner != null) {
                        inner.cancel(false);
                    }
                }
            }
            unsubscribe(fromOnError);
        }

        boolean ifDoneOrCancelled() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private boolean handleTerminationIfDone() {
            boolean wasDone = done;
            boolean isEmpty = isEmpty();
            if (delayError) {
                if (wasDone && isEmpty) {
                    Throwable e = failures.get();
                    if (e != null && e != Subscriptions.TERMINATED) {
                        Throwable throwable = failures.getAndSet(Subscriptions.TERMINATED);
                        downstream.onFailure(throwable);
                    } else {
                        downstream.onCompletion();
                    }
                    return true;
                }
            } else {
                if (wasDone) {
                    Throwable e = failures.get();
                    if (e != null && e != Subscriptions.TERMINATED) {
                        Throwable throwable = failures.getAndSet(Subscriptions.TERMINATED);
                        unsubscribe(true);
                        downstream.onFailure(throwable);
                        return true;
                    } else if (isEmpty) {
                        downstream.onCompletion();
                        return true;
                    }
                }
            }
            return false;
        }

        void innerError(FlatMapInner<O> inner, Throwable fail) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void failOverflow() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void innerComplete() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        Queue<O> getOrCreateInnerQueue(FlatMapInner<O> inner) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Context context() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static final class FlatMapInner<O> implements Subscription, MultiSubscriber<O>, ContextSupport {

        final FlatMapMainSubscriber<?, O> parent;

        final int requests;

        final int limit;

        volatile Subscription subscription = null;

        private static final AtomicReferenceFieldUpdater<FlatMapInner, Subscription> SUBSCRIPTION_UPDATER = AtomicReferenceFieldUpdater
                .newUpdater(FlatMapInner.class, Subscription.class, "subscription");

        long produced;

        volatile Queue<O> queue;

        volatile boolean done;

        int index;

        FlatMapInner(FlatMapMainSubscriber<?, O> parent, int requests) {
            this.parent = parent;
            this.requests = requests;
            this.limit = Subscriptions.unboundedOrLimit(requests);
        }

        @Override
        public void onSubscribe(Subscription s) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(O item) {
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
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void cancel(boolean doNotCancel) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Context context() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

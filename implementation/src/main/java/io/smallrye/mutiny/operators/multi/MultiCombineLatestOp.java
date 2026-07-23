package io.smallrye.mutiny.operators.multi;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.helpers.queues.Queues;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import io.smallrye.mutiny.operators.MultiOperator;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * Combines the latest values from multiple sources through a function.
 *
 * @param <I> the type of item coming from upstreams
 * @param <O> the result type
 */
public class MultiCombineLatestOp<I, O> extends MultiOperator<I, O> {

    private final Iterable<? extends Publisher<? extends I>> upstreams;

    private final Function<List<?>, ? extends O> combinator;

    private final int bufferSize;

    private final boolean delayErrors;

    public MultiCombineLatestOp(Iterable<? extends Publisher<? extends I>> upstreams, Function<List<?>, ? extends O> combinator,
            int bufferSize, boolean delayErrors) {
        super(null);
        this.upstreams = ParameterValidation.doesNotContainNull(upstreams, "upstreams");
        this.combinator = ParameterValidation.nonNull(combinator, "combinator");
        this.bufferSize = bufferSize;
        this.delayErrors = delayErrors;
    }

    @Override
    public void subscribe(MultiSubscriber<? super O> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final class CombineLatestCoordinator<I, O> implements Subscription {

        private final MultiSubscriber<? super O> downstream;

        private final Function<List<?>, ? extends O> combinator;

        private final List<CombineLatestInnerSubscriber<I>> subscribers = new ArrayList<>();

        private final Queue<Object> queue;

        private final Object[] latest;

        private final boolean delayErrors;

        private int nonEmptySources;

        private int completedSources;

        private volatile boolean cancelled;

        private volatile boolean done;

        private final AtomicLong requested = new AtomicLong();

        private final AtomicReference<Throwable> failure = new AtomicReference<>();

        private final AtomicInteger wip = new AtomicInteger();

        CombineLatestCoordinator(MultiSubscriber<? super O> downstream, Function<List<?>, ? extends O> combinator, int size,
                int bufferSize, boolean delayErrors) {
            this.downstream = downstream;
            this.combinator = combinator;
            Context context;
            if (downstream instanceof ContextSupport) {
                context = ((ContextSupport) downstream).context();
            } else {
                context = Context.empty();
            }
            for (int i = 0; i < size; i++) {
                subscribers.add(new CombineLatestInnerSubscriber<>(context, this, i, bufferSize));
            }
            this.latest = new Object[size];
            this.queue = Queues.createSpscUnboundedQueue(bufferSize);
            this.delayErrors = delayErrors;
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void subscribe(List<Publisher<? extends I>> sources) {
            int i = 0;
            for (CombineLatestInnerSubscriber<I> subscriber : subscribers) {
                if (done || cancelled) {
                    return;
                }
                sources.get(i).subscribe(Infrastructure.onMultiSubscription(sources.get(i), subscriber));
                i++;
            }
        }

        void innerValue(int index, I value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void innerComplete(int index) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void innerError(int index, Throwable e) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings("unchecked")
        void drainAsync() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void drain() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        boolean isEmptyOrDone(boolean d, boolean empty) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void cancelAll() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class CombineLatestInnerSubscriber<T> implements MultiSubscriber<T>, ContextSupport {

        private final AtomicReference<Subscription> upstream = new AtomicReference<>();

        private final Context context;

        private final CombineLatestCoordinator<T, ?> parent;

        private final int index;

        private final int prefetch;

        private final int limit;

        int produced;

        CombineLatestInnerSubscriber(Context context, CombineLatestCoordinator<T, ?> parent, int index, int prefetch) {
            this.context = context;
            this.parent = parent;
            this.index = index;
            this.prefetch = prefetch;
            this.limit = prefetch - (prefetch >> 2);
        }

        @Override
        public void onSubscribe(Subscription s) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void requestOneItem() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Context context() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

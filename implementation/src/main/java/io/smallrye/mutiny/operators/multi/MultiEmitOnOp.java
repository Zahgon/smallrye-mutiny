package io.smallrye.mutiny.operators.multi;

import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.queues.Queues;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * Emits events from upstream on a thread managed by the given scheduler.
 *
 * @param <T> the type of item
 */
public class MultiEmitOnOp<T> extends AbstractMultiOperator<T, T> {

    private final Executor executor;

    private final int bufferSize;

    public MultiEmitOnOp(Multi<? extends T> upstream, Executor executor, int bufferSize) {
        super(upstream);
        this.executor = executor;
        this.bufferSize = bufferSize;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class MultiEmitOnProcessor<T> extends MultiOperatorProcessor<T, T> implements Runnable {

        private final Executor executor;

        private final int bufferSize;

        // State variables
        /**
         * Store the items
         */
        private final Queue<T> queue;

        /**
         * {@code true} if the subscription has been cancelled.
         */
        private volatile boolean cancelled;

        /**
         * {@code true} if no more items should be received (failure or completion received)
         */
        private volatile boolean done;

        /**
         * Stores the failure
         */
        private final AtomicReference<Throwable> failure = new AtomicReference<>();

        private final AtomicInteger wip = new AtomicInteger();

        private final AtomicLong requested = new AtomicLong();

        private long produced;

        MultiEmitOnProcessor(MultiSubscriber<? super T> downstream, Executor executor, int bufferSize) {
            super(downstream);
            this.executor = executor;
            this.bufferSize = bufferSize;
            this.queue = Queues.createMpscArrayQueue(bufferSize);
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable throwable) {
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

        void schedule() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        boolean isDoneOrCancelled(boolean upstreamDone, boolean queueEmpty) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

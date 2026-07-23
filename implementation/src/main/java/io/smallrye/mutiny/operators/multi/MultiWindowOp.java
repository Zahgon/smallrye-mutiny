package io.smallrye.mutiny.operators.multi;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.helpers.queues.Queues;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import io.smallrye.mutiny.operators.multi.processors.UnicastProcessor;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * Splits the source sequence by time of reception into potentially overlapping {@code Multi}.
 *
 * @param <T> the type of item from upstream
 */
public class MultiWindowOp<T> extends AbstractMultiOperator<T, Multi<T>> {

    /**
     * Number of items in the window
     */
    private final int size;

    /**
     * Number of items to skip before starting a new window.
     */
    private final int skip;

    /**
     * Queue supplier
     */
    private final Supplier<? extends Queue<T>> processorQueueSupplier;

    /**
     * Overflow queue supplier.
     */
    private final Supplier<? extends Queue<UnicastProcessor<T>>> overflowQueueSupplier;

    public MultiWindowOp(Multi<? extends T> upstream, int size, int skip) {
        super(upstream);
        this.size = ParameterValidation.positive(size, "size");
        this.skip = ParameterValidation.positive(skip, "skip");
        this.processorQueueSupplier = Queues.unbounded(Infrastructure.getBufferSizeXs());
        this.overflowQueueSupplier = Queues.unbounded(Infrastructure.getBufferSizeXs());
    }

    @Override
    public void subscribe(MultiSubscriber<? super Multi<T>> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class MultiWindowExactProcessor<T> extends MultiOperatorProcessor<T, Multi<T>> {

        private final Supplier<? extends Queue<T>> supplier;

        private final int size;

        private final AtomicInteger count = new AtomicInteger();

        int index;

        private UnicastProcessor<T> processor;

        MultiWindowExactProcessor(MultiSubscriber<? super Multi<T>> downstream, int size,
                Supplier<? extends Queue<T>> supplier) {
            super(downstream);
            this.size = size;
            this.supplier = supplier;
            count.lazySet(1);
        }

        @Override
        public void onItem(T t) {
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
    }

    static final class MultiWindowWithSkipProcessor<T> extends MultiOperatorProcessor<T, Multi<T>> {

        private final Supplier<? extends Queue<T>> supplier;

        private final int size;

        private final int skip;

        private final AtomicInteger count = new AtomicInteger();

        private final AtomicBoolean firstRequest = new AtomicBoolean();

        int index;

        UnicastProcessor<T> processor;

        MultiWindowWithSkipProcessor(MultiSubscriber<? super Multi<T>> downstream, int size, int skip,
                Supplier<? extends Queue<T>> supplier) {
            super(downstream);
            this.size = size;
            this.skip = skip;
            this.supplier = supplier;
            count.lazySet(1);
        }

        @Override
        public void onItem(T t) {
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
    }

    static final class MultiWindowWithOverlapProcessor<T> extends MultiOperatorProcessor<T, Multi<T>> implements Runnable {

        private final ArrayDeque<UnicastProcessor<T>> processors = new ArrayDeque<>();

        private final Supplier<? extends Queue<T>> supplier;

        private final Queue<UnicastProcessor<T>> overflow;

        private final int size;

        private final int skip;

        private final AtomicReference<Throwable> failure = new AtomicReference<>();

        private final AtomicInteger count = new AtomicInteger();

        private final AtomicBoolean firstRequest = new AtomicBoolean();

        private final AtomicLong requested = new AtomicLong();

        private final AtomicInteger wip = new AtomicInteger();

        private int index;

        private int produced;

        MultiWindowWithOverlapProcessor(MultiSubscriber<? super Multi<T>> downstream, int size, int skip,
                Supplier<? extends Queue<T>> supplier, Queue<UnicastProcessor<T>> overflowQueue) {
            super(downstream);
            this.size = size;
            this.skip = skip;
            this.supplier = supplier;
            count.lazySet(1);
            this.overflow = overflowQueue;
        }

        @Override
        public void onItem(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable f) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void drain() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        boolean isCancelledOrDone(boolean isDone, boolean isEmpty, Subscriber<?> subscriber, Queue<?> q) {
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
        public void run() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

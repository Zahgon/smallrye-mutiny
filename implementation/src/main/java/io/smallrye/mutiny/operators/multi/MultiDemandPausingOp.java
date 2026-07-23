package io.smallrye.mutiny.operators.multi;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.queues.Queues;
import io.smallrye.mutiny.operators.MultiOperator;
import io.smallrye.mutiny.subscription.BackPressureStrategy;
import io.smallrye.mutiny.subscription.MultiSubscriber;
import io.smallrye.mutiny.subscription.PausableMulti;

/**
 * Operator that allows pausing and resuming demand propagation to upstream.
 * <p>
 * When paused, this operator stops requesting new items from upstream.
 * Already-requested items are handled according to the configured {@link BackPressureStrategy}:
 * <ul>
 * <li>{@link BackPressureStrategy#BUFFER}: Items are buffered and delivered when resumed</li>
 * <li>{@link BackPressureStrategy#DROP}: Items are dropped</li>
 * <li>{@link BackPressureStrategy#IGNORE}: Items continue to flow downstream</li>
 * </ul>
 *
 * @param <T> the type of items
 */
public class MultiDemandPausingOp<T> extends MultiOperator<T, T> implements PausableMulti {

    private volatile PausableProcessor processor;

    private final AtomicBoolean paused;

    private final AtomicBoolean subscribed = new AtomicBoolean();

    private final boolean lateSubscription;

    private final int bufferSize;

    private final boolean unbounded;

    private final BackPressureStrategy backPressureStrategy;

    public MultiDemandPausingOp(Multi<T> upstream, boolean initiallyPaused, boolean lateSubscription, int bufferSize,
            boolean unbounded, BackPressureStrategy backPressureStrategy) {
        super(upstream);
        this.paused = new AtomicBoolean(initiallyPaused);
        this.lateSubscription = lateSubscription;
        this.bufferSize = bufferSize;
        this.unbounded = unbounded;
        this.backPressureStrategy = backPressureStrategy;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isPaused() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void pause() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void resume() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int bufferSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean clearBuffer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class PausableProcessor extends MultiOperatorProcessor<T, T> {

        private final AtomicLong demand = new AtomicLong();

        private final Queue<T> queue;

        private final AtomicInteger wip = new AtomicInteger();

        private final AtomicInteger strictBoundCounter = new AtomicInteger(0);

        private volatile boolean upstreamCompleted;

        private final AtomicBoolean clearQueue = new AtomicBoolean();

        PausableProcessor(MultiSubscriber<? super T> downstream) {
            super(downstream);
            // Determine if we need a queue based on strategy and buffer size
            if (backPressureStrategy == BackPressureStrategy.BUFFER) {
                this.queue = unbounded ? Queues.<T> unbounded(bufferSize).get() : Queues.<T> get(bufferSize).get();
            } else {
                this.queue = null;
            }
        }

        void resume() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void drain() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void clearQueue() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        int queueSize() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void request(long numberOfItems) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
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
    }
}

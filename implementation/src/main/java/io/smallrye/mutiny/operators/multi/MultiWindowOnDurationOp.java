package io.smallrye.mutiny.operators.multi;

import java.time.Duration;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.helpers.queues.Queues;
import io.smallrye.mutiny.operators.multi.processors.UnicastProcessor;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiWindowOnDurationOp<T> extends AbstractMultiOperator<T, Multi<T>> {

    private final Duration duration;

    private final ScheduledExecutorService executor;

    public MultiWindowOnDurationOp(Multi<T> upstream, Duration duration, ScheduledExecutorService executor) {
        super(upstream);
        this.duration = ParameterValidation.validate(duration, "duration");
        this.executor = ParameterValidation.nonNull(executor, "executor");
    }

    @Override
    public void subscribe(MultiSubscriber<? super Multi<T>> actual) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class WindowTimeoutSubscriber<T> extends MultiOperatorProcessor<T, Multi<T>> {

        private final Duration duration;

        private final ScheduledExecutorService scheduler;

        private final Queue<Object> queue;

        private Throwable failure;

        private UnicastProcessor<T> current;

        private final AtomicLong requested = new AtomicLong();

        private final AtomicInteger wip = new AtomicInteger();

        private final TaskHolder timer = new TaskHolder();

        volatile boolean done;

        volatile boolean terminated;

        WindowTimeoutSubscriber(MultiSubscriber<? super Multi<T>> downstream, Duration duration,
                ScheduledExecutorService scheduler) {
            super(downstream);
            this.queue = Queues.createMpscQueue();
            this.duration = duration;
            this.scheduler = scheduler;
        }

        @Override
        public void onSubscribe(Subscription s) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        Future<?> newPeriod() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T item) {
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

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings("unchecked")
        void drainLoop() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        boolean canStartWork() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        static final class Tick implements Runnable {

            private final WindowTimeoutSubscriber<?> parent;

            Tick(WindowTimeoutSubscriber<?> parent) {
                this.parent = parent;
            }

            @Override
            public void run() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }

    private static class TaskHolder {

        private final AtomicReference<Future<?>> container = new AtomicReference<>();

        static final Future<?> NONE = new CompletableFuture<>();

        boolean replace(Future<?> task) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

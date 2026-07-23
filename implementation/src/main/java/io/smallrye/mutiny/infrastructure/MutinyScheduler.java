package io.smallrye.mutiny.infrastructure;

import java.util.concurrent.*;

/**
 * Implementation of {@link ScheduledThreadPoolExecutor} delegating the execution of the task to a configured
 * {@link Executor}.
 * <p>
 * Important: {@link RunnableScheduledFuture#get()} and {@link RunnableScheduledFuture#get(long, TimeUnit)} are not
 * supported.
 */
public class MutinyScheduler extends ScheduledThreadPoolExecutor {

    private final Executor executor;

    public MutinyScheduler(Executor executor) {
        super(1);
        this.executor = executor;
    }

    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Runnable runnable, RunnableScheduledFuture<V> task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected <V> RunnableScheduledFuture<V> decorateTask(Callable<V> callable, RunnableScheduledFuture<V> task) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class DecoratedRunnableTask<V> implements RunnableScheduledFuture<V> {

        private final Executor executor;

        private final RunnableScheduledFuture<V> origin;

        public DecoratedRunnableTask(RunnableScheduledFuture<V> origin, Executor executor) {
            this.origin = origin;
            this.executor = executor;
        }

        @Override
        public boolean isPeriodic() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public long getDelay(TimeUnit unit) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int compareTo(Delayed o) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean cancel(boolean mayInterruptIfRunning) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean isCancelled() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean isDone() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public V get() throws ExecutionException, InterruptedException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

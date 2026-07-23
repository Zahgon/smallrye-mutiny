package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.MultiSubscriber;
import io.smallrye.mutiny.subscription.SwitchableSubscriptionSubscriber;

public class MultiRepeatUntilOp<T> extends AbstractMultiOperator<T, T> implements Multi<T> {

    private final Predicate<T> predicate;

    private final long times;

    private final Uni<?> delay;

    public MultiRepeatUntilOp(Multi<T> upstream, long times, Uni<?> delay) {
        super(upstream);
        this.times = times;
        this.predicate = x -> false;
        this.delay = delay;
    }

    public MultiRepeatUntilOp(Multi<T> upstream, Predicate<T> predicate, Uni<?> delay) {
        super(upstream);
        this.predicate = predicate;
        this.times = Long.MAX_VALUE;
        this.delay = delay;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static abstract class RepeatProcessor<T> extends SwitchableSubscriptionSubscriber<T> {

        protected final Multi<? extends T> upstream;

        protected final Predicate<T> predicate;

        protected final AtomicInteger wip = new AtomicInteger();

        private final Uni<?> delay;

        protected long remaining;

        protected long emitted;

        public RepeatProcessor(Multi<? extends T> upstream, MultiSubscriber<? super T> downstream, long times,
                Predicate<T> predicate, Uni<?> delay) {
            super(downstream);
            this.upstream = upstream;
            this.predicate = predicate;
            this.remaining = times;
            this.delay = delay;
        }

        protected void subscribeNext() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void drainLoop() {
            if (wip.getAndIncrement() == 0) {
                int missed = 1;
                while (!isCancelled()) {
                    long p = emitted;
                    if (p != 0L) {
                        emitted = 0L;
                        emitted(p);
                    }
                    upstream.subscribe(this);
                    missed = wip.addAndGet(-missed);
                    if (missed == 0) {
                        break;
                    }
                }
            }
        }
    }

    static final class RepeatUntilProcessor<T> extends RepeatProcessor<T> {

        /**
         * Stores the result of the last test of the predicate, i.e. the test with the last emitted item.
         * It indicates if the repetition must be stopped (the predicate would have returned {@code false}).
         * <p>
         * Access does not need to be synchronized as it is only accessed in onItem and onCompletion which cannot be
         * called concurrently.
         */
        private boolean passed = true;

        public RepeatUntilProcessor(Multi<? extends T> upstream, MultiSubscriber<? super T> downstream, long times,
                Predicate<T> predicate, Uni<?> delay) {
            super(upstream, downstream, times, predicate, delay);
        }

        @Override
        public void onItem(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

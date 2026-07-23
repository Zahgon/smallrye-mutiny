package io.smallrye.mutiny.operators.multi;

import java.util.function.Predicate;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiRepeatWhilstOp<T> extends AbstractMultiOperator<T, T> implements Multi<T> {

    private final Predicate<T> predicate;

    private final long times;

    private final Uni<?> delay;

    public MultiRepeatWhilstOp(Multi<T> upstream, Predicate<T> predicate, Uni<?> delay) {
        super(upstream);
        this.predicate = predicate;
        this.times = Long.MAX_VALUE;
        this.delay = delay;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class RepeatWhilstProcessor<T> extends MultiRepeatUntilOp.RepeatProcessor<T> {

        private boolean stop = false;

        public RepeatWhilstProcessor(Multi<? extends T> upstream, MultiSubscriber<? super T> downstream, long times,
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

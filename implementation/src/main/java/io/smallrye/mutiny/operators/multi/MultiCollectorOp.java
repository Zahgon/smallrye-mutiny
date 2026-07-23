package io.smallrye.mutiny.operators.multi;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public final class MultiCollectorOp<T, A, R> extends AbstractMultiOperator<T, R> {

    private final Collector<? super T, A, ? extends R> collector;

    private final boolean acceptNullAsInitialValue;

    public MultiCollectorOp(Multi<T> upstream, Collector<? super T, A, ? extends R> collector,
            boolean acceptNullAsInitialValue) {
        super(upstream);
        this.collector = collector;
        this.acceptNullAsInitialValue = acceptNullAsInitialValue;
    }

    @Override
    public void subscribe(MultiSubscriber<? super R> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class CollectorProcessor<T, A, R> extends MultiOperatorProcessor<T, R> {

        private final BiConsumer<A, T> accumulator;

        private final Function<A, R> finisher;

        // Only accessed in the serialized callbacks
        private A intermediate;

        CollectorProcessor(MultiSubscriber<? super R> downstream, A initialValue, BiConsumer<A, T> accumulator,
                Function<A, R> finisher) {
            super(downstream);
            this.intermediate = initialValue;
            this.accumulator = accumulator;
            this.finisher = finisher;
        }

        @Override
        public void onItem(T item) {
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
    }
}

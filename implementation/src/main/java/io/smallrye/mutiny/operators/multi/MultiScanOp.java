package io.smallrye.mutiny.operators.multi;

import java.util.function.BiFunction;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * Scan operator accumulating items of the same type as the upstream.
 *
 * @param <T> the type of item
 */
public final class MultiScanOp<T> extends AbstractMultiOperator<T, T> {

    private final BiFunction<T, ? super T, T> accumulator;

    public MultiScanOp(Multi<? extends T> upstream, BiFunction<T, ? super T, T> accumulator) {
        super(upstream);
        this.accumulator = ParameterValidation.nonNull(accumulator, "accumulator");
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class ScanProcessor<T> extends MultiOperatorProcessor<T, T> {

        private final BiFunction<T, ? super T, T> accumulator;

        private T current;

        ScanProcessor(MultiSubscriber<? super T> downstream, BiFunction<T, ? super T, T> accumulator) {
            super(downstream);
            this.accumulator = accumulator;
        }

        @Override
        public void onItem(T item) {
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

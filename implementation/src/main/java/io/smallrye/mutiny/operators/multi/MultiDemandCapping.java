package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.LongFunction;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.MultiOperator;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiDemandCapping<T> extends MultiOperator<T, T> {

    private final LongFunction<Long> function;

    public MultiDemandCapping(Multi<T> upstream, LongFunction<Long> function) {
        super(upstream);
        this.function = function;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class MultiDemandCappingProcessor extends MultiOperatorProcessor<T, T> {

        private final AtomicLong demand = new AtomicLong();

        MultiDemandCappingProcessor(MultiSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        public void request(long numberOfItems) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

package io.smallrye.mutiny.operators.multi;

import java.util.function.LongConsumer;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiOnRequestInvoke<T> extends AbstractMultiOperator<T, T> {

    private final LongConsumer consumer;

    public MultiOnRequestInvoke(Multi<? extends T> upstream, LongConsumer consumer) {
        super(upstream);
        this.consumer = consumer;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class MultiOnRequestInvokeOperator extends MultiOperatorProcessor<T, T> {

        public MultiOnRequestInvokeOperator(MultiSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        public void request(long numberOfItems) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.Flow;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiIgnoreOp<T> extends AbstractMultiOperator<T, Void> {

    public MultiIgnoreOp(Multi<T> upstream) {
        super(upstream);
    }

    @Override
    public void subscribe(MultiSubscriber<? super Void> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class MultiIgnoreProcessor<T> extends MultiOperatorProcessor<T, Void> {

        public MultiIgnoreProcessor(MultiSubscriber<? super Void> downstream) {
            super(downstream);
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void request(long numberOfItems) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T ignored) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

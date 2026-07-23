package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.Flow.Subscription;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public final class MultiLastItemOp<T> extends AbstractMultiOperator<T, T> {

    public MultiLastItemOp(Multi<T> upstream) {
        super(upstream);
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class MultiLastItemProcessor<T> extends MultiOperatorProcessor<T, T> {

        T last;

        MultiLastItemProcessor(MultiSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        public void onSubscribe(Subscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void request(long numberOfItems) {
            throw new UnsupportedOperationException("STUB: not implemented");
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

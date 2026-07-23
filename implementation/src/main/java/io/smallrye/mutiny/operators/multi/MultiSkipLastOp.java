package io.smallrye.mutiny.operators.multi;

import java.util.ArrayDeque;
import java.util.concurrent.Flow.Subscription;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * Skips the numberOfItems last items from upstream.
 *
 * @param <T> the type of item
 */
public final class MultiSkipLastOp<T> extends AbstractMultiOperator<T, T> {

    private final int numberOfItems;

    public MultiSkipLastOp(Multi<? extends T> upstream, int numberOfItems) {
        super(upstream);
        this.numberOfItems = ParameterValidation.positiveOrZero(numberOfItems, "numberOfItems");
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> actual) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class SkipLastProcessor<T> extends MultiOperatorProcessor<T, T> {

        private final int numberOfItems;

        private final ArrayDeque<T> queue = new ArrayDeque<>();

        SkipLastProcessor(MultiSubscriber<? super T> actual, int numberOfItems) {
            super(actual);
            this.numberOfItems = numberOfItems;
        }

        @Override
        public void onSubscribe(Subscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T t) {
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
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

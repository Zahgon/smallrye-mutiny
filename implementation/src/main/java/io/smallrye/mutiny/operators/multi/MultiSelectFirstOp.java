package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.Flow.Subscription;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * Takes the n first items emitted by the upstream, cancelling the subscription after that.
 * <p>
 * If n == 0, the subscriber gets completed if the upstream emits the completion, a failure signal, or a first (dropped)
 * item.
 *
 * @param <T> the type of item
 */
public final class MultiSelectFirstOp<T> extends AbstractMultiOperator<T, T> {

    private final long numberOfItems;

    public MultiSelectFirstOp(Multi<? extends T> upstream, long numberOfItems) {
        super(upstream);
        this.numberOfItems = ParameterValidation.positiveOrZero(numberOfItems, "numberOfItems");
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class MultiSelectFirstProcessor<T> extends MultiOperatorProcessor<T, T> {

        private final long numberOfItems;

        private long remaining;

        MultiSelectFirstProcessor(MultiSubscriber<? super T> downstream, long numberOfItems) {
            super(downstream);
            this.numberOfItems = numberOfItems;
            this.remaining = numberOfItems;
        }

        @Override
        public void onSubscribe(Subscription s) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

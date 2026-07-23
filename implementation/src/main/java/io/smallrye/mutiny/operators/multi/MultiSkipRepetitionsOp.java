package io.smallrye.mutiny.operators.multi;

import java.util.Comparator;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * Eliminates the duplicated items from the upstream.
 *
 * @param <T> the type of items
 */
public final class MultiSkipRepetitionsOp<T> extends AbstractMultiOperator<T, T> {

    private final Comparator<? super T> comparator;

    public MultiSkipRepetitionsOp(Multi<T> upstream) {
        this(upstream, null);
    }

    public MultiSkipRepetitionsOp(Multi<T> upstream, Comparator<? super T> comparator) {
        super(upstream);
        this.comparator = comparator;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class MultiSkipRepetitionsProcessor<T> extends MultiOperatorProcessor<T, T> {

        private final Comparator<? super T> comparator;

        private T last;

        public MultiSkipRepetitionsProcessor(MultiSubscriber<? super T> subscriber, Comparator<? super T> comparator) {
            super(subscriber);
            if (comparator == null) {
                this.comparator = (a, b) -> a.equals(b) ? 0 : 1;
            } else {
                this.comparator = comparator;
            }
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

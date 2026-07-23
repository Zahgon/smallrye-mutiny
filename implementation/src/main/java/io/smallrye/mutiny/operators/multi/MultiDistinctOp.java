package io.smallrye.mutiny.operators.multi;

import java.util.*;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * Eliminates the duplicated items from the upstream.
 *
 * @param <T> the type of items
 */
public final class MultiDistinctOp<T> extends AbstractMultiOperator<T, T> {

    private final Comparator<? super T> comparator;

    public MultiDistinctOp(Multi<? extends T> upstream) {
        this(upstream, null);
    }

    public MultiDistinctOp(Multi<? extends T> upstream, Comparator<? super T> comparator) {
        super(upstream);
        this.comparator = comparator;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class DistinctProcessor<T> extends MultiOperatorProcessor<T, T> {

        final Collection<T> collection;

        DistinctProcessor(MultiSubscriber<? super T> downstream, Comparator<? super T> comparator) {
            super(downstream);
            if (comparator == null) {
                this.collection = new HashSet<>();
            } else {
                this.collection = new TreeSet<>(comparator);
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

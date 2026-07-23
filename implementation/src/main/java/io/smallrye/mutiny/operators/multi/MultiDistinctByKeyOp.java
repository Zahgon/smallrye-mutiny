package io.smallrye.mutiny.operators.multi;

import java.util.*;
import java.util.function.Function;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * Eliminates the duplicated items from the upstream.
 *
 * @param <T> the type of items
 * @param <K> the type of key, used to identify duplicates
 */
public final class MultiDistinctByKeyOp<T, K> extends AbstractMultiOperator<T, T> {

    private final Function<T, K> keyExtractor;

    public MultiDistinctByKeyOp(Multi<? extends T> upstream, Function<T, K> keyExtractor) {
        super(upstream);
        this.keyExtractor = keyExtractor;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class DistinctByKeyProcessor<T, K> extends MultiOperatorProcessor<T, T> {

        private final Collection<K> foundKeys = new HashSet<>();

        private final Function<T, K> keyExtractor;

        DistinctByKeyProcessor(MultiSubscriber<? super T> downstream, Function<T, K> keyExtractor) {
            super(downstream);
            this.keyExtractor = keyExtractor;
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

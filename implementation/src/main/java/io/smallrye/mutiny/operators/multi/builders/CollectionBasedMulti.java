package io.smallrye.mutiny.operators.multi.builders;

import java.util.*;
import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicLong;

import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class CollectionBasedMulti<T> extends AbstractMulti<T> {

    /**
     * The collection, immutable once set.
     */
    private final Collection<T> collection;

    @SafeVarargs
    public CollectionBasedMulti(T... array) {
        this.collection = Arrays.asList(ParameterValidation.doesNotContainNull(array, "array"));
    }

    public CollectionBasedMulti(Collection<T> collection) {
        this.collection = Collections.unmodifiableCollection(ParameterValidation.doesNotContainNull(collection, "collection"));
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> actual) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final class CollectionSubscription<T> implements Flow.Subscription {

        private final MultiSubscriber<? super T> downstream;

        // Immutable
        private final List<T> collection;

        private int index;

        private volatile boolean cancelled;

        AtomicLong requested = new AtomicLong();

        public CollectionSubscription(MultiSubscriber<? super T> downstream, Collection<T> collection) {
            this.downstream = downstream;
            this.collection = wrapIfNotList(collection);
        }

        private List<T> wrapIfNotList(Collection<T> collection) {
            if (collection instanceof List) {
                return (List<T>) collection;
            } else {
                return new ArrayList<>(collection);
            }
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void followRequests(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void produceWithoutBackPressure() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

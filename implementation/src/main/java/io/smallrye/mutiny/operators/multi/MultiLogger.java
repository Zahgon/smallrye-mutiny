package io.smallrye.mutiny.operators.multi;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicLong;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiLogger<T> extends AbstractMultiOperator<T, T> {

    private final String identifier;

    private final AtomicLong increment = new AtomicLong(0L);

    public MultiLogger(Multi<? extends T> upstream, String identifier) {
        super(nonNull(upstream, "upstream"));
        String id = nonNull(identifier, "identifier");
        if (id.isEmpty()) {
            throw new IllegalArgumentException("The identifier cannot be an empty string");
        }
        this.identifier = id;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class MultiLoggerProcessor extends MultiOperatorProcessor<T, T> {

        private final String processorIdentifier;

        public MultiLoggerProcessor(MultiSubscriber<? super T> downstream, long increment) {
            super(downstream);
            this.processorIdentifier = identifier + "." + increment;
        }

        @Override
        public void onSubscribe(Subscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void request(long numberOfItems) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

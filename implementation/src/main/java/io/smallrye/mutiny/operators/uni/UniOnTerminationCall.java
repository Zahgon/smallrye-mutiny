package io.smallrye.mutiny.operators.uni;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.UniOperator;
import io.smallrye.mutiny.subscription.Cancellable;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.tuples.Functions;

public class UniOnTerminationCall<I> extends UniOperator<I, I> {

    private final Functions.Function3<? super I, Throwable, Boolean, Uni<?>> mapper;

    public UniOnTerminationCall(Uni<I> upstream, Functions.Function3<? super I, Throwable, Boolean, Uni<?>> mapper) {
        super(nonNull(upstream, "upstream"));
        this.mapper = nonNull(mapper, "mapper");
    }

    @Override
    public void subscribe(UniSubscriber<? super I> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class UniOnTerminationCallProcessor extends UniOperatorProcessor<I, I> {

        public UniOnTerminationCallProcessor(UniSubscriber<? super I> downstream) {
            super(downstream);
        }

        private volatile Cancellable cancellable;

        /**
         * Guard that we call the mapper only once.
         */
        private final AtomicBoolean invoked = new AtomicBoolean();

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(I item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private Uni<?> execute(I item, Throwable failure, Boolean cancelled) {
            // Be sure the mapper is called only once.
            if (invoked.compareAndSet(false, true)) {
                try {
                    return Objects.requireNonNull(mapper.apply(item, failure, cancelled), "Uni should not be null");
                } catch (Throwable err) {
                    return Uni.createFrom().failure(err);
                }
            } else {
                return Uni.createFrom().nullItem();
            }
        }
    }
}

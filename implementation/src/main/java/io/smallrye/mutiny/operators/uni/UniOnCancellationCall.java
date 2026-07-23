package io.smallrye.mutiny.operators.uni;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Supplier;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.UniOperator;
import io.smallrye.mutiny.subscription.UniSubscriber;

public class UniOnCancellationCall<I> extends UniOperator<I, I> {

    private final Supplier<Uni<?>> supplier;

    public UniOnCancellationCall(Uni<? extends I> upstream, Supplier<Uni<?>> supplier) {
        super(upstream);
        this.supplier = supplier;
    }

    @Override
    public void subscribe(UniSubscriber<? super I> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private enum State {

        INIT,
        DONE,
        CANCELLED
    }

    private static class UniOnCancellationCallProcessor<I> extends UniOperatorProcessor<I, I> {

        private final Supplier<Uni<?>> supplier;

        private volatile State state = State.INIT;

        private static final AtomicReferenceFieldUpdater<UniOnCancellationCallProcessor, State> stateUpdater = AtomicReferenceFieldUpdater
                .newUpdater(UniOnCancellationCallProcessor.class, State.class, "state");

        public UniOnCancellationCallProcessor(Supplier<Uni<?>> supplier, UniSubscriber<? super I> downstream) {
            super(downstream);
            this.supplier = supplier;
        }

        @Override
        public void onItem(I item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private Uni<?> execute() {
            try {
                return nonNull(supplier.get(), "uni");
            } catch (Throwable err) {
                return Uni.createFrom().failure(err);
            }
        }
    }
}

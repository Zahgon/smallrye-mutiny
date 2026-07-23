package io.smallrye.mutiny.operators.uni;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.UniOperator;
import io.smallrye.mutiny.subscription.UniSubscriber;

public class UniOnCancellation<T> extends UniOperator<T, T> {

    private final Runnable callback;

    public UniOnCancellation(Uni<T> upstream, Runnable callback) {
        super(upstream);
        this.callback = callback;
    }

    @Override
    public void subscribe(UniSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private enum State {

        INIT,
        DONE,
        CANCELLED
    }

    private static class UniOnCancellationProcessor<T> extends UniOperatorProcessor<T, T> {

        private final Runnable callback;

        private volatile State state = State.INIT;

        private static final AtomicReferenceFieldUpdater<UniOnCancellationProcessor, State> stateUpdater = AtomicReferenceFieldUpdater
                .newUpdater(UniOnCancellationProcessor.class, State.class, "state");

        public UniOnCancellationProcessor(Runnable callback, UniSubscriber<? super T> downstream) {
            super(downstream);
            this.callback = callback;
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
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

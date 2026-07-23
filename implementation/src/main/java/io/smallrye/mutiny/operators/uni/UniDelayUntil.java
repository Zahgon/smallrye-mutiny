package io.smallrye.mutiny.operators.uni;

import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.UniOperator;
import io.smallrye.mutiny.subscription.Cancellable;
import io.smallrye.mutiny.subscription.UniSubscriber;

public class UniDelayUntil<T> extends UniOperator<T, T> {

    private final Function<? super T, Uni<?>> function;

    private final ScheduledExecutorService executor;

    public UniDelayUntil(Uni<T> upstream, Function<? super T, Uni<?>> function, ScheduledExecutorService executor) {
        super(upstream);
        this.function = function;
        this.executor = executor;
    }

    @Override
    public void subscribe(UniSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class UniDelayUntilProcessor extends UniOperatorProcessor<T, T> {

        private volatile Cancellable delayCancellable;

        public UniDelayUntilProcessor(UniSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        public void onItem(T item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

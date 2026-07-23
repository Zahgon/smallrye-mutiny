package io.smallrye.mutiny.operators.uni;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.concurrent.Executor;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.UniOperator;
import io.smallrye.mutiny.subscription.UniSubscriber;

public class UniEmitOn<I> extends UniOperator<I, I> {

    private final Executor executor;

    public UniEmitOn(Uni<I> upstream, Executor executor) {
        super(upstream);
        this.executor = nonNull(executor, "executor");
    }

    @Override
    public void subscribe(UniSubscriber<? super I> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class UniEmitOnProcessor extends UniOperatorProcessor<I, I> {

        public UniEmitOnProcessor(UniSubscriber<? super I> downstream) {
            super(downstream);
        }

        @Override
        public void onItem(I item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

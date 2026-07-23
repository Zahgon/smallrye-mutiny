package io.smallrye.mutiny.operators.uni;

import java.util.function.BiFunction;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.UniOperator;
import io.smallrye.mutiny.subscription.UniSubscriber;

public class UniOnItemOrFailureMap<I, O> extends UniOperator<I, O> {

    private final BiFunction<? super I, Throwable, ? extends O> mapper;

    public UniOnItemOrFailureMap(Uni<I> upstream, BiFunction<? super I, Throwable, ? extends O> mapper) {
        super(upstream);
        this.mapper = mapper;
    }

    @Override
    public void subscribe(UniSubscriber<? super O> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class UniOnItemOrFailureMapProcessor extends UniOperatorProcessor<I, O> {

        public UniOnItemOrFailureMapProcessor(UniSubscriber<? super O> downstream) {
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

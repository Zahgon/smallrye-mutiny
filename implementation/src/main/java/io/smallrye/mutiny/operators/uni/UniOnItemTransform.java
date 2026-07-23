package io.smallrye.mutiny.operators.uni;

import java.util.function.Function;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.operators.UniOperator;
import io.smallrye.mutiny.subscription.UniSubscriber;

public class UniOnItemTransform<I, O> extends UniOperator<I, O> {

    private final Function<? super I, ? extends O> mapper;

    public UniOnItemTransform(Uni<I> source, Function<? super I, ? extends O> mapper) {
        super(ParameterValidation.nonNull(source, "source"));
        this.mapper = mapper;
    }

    @Override
    public void subscribe(UniSubscriber<? super O> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class UniOnItemTransformProcessor extends UniOperatorProcessor<I, O> {

        public UniOnItemTransformProcessor(UniSubscriber<? super O> downstream) {
            super(downstream);
        }

        @Override
        public void onItem(I item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

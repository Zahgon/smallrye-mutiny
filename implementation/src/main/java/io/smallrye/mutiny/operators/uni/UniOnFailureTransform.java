package io.smallrye.mutiny.operators.uni;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.function.Function;
import java.util.function.Predicate;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.UniOperator;
import io.smallrye.mutiny.subscription.UniSubscriber;

public class UniOnFailureTransform<I, O, E extends Throwable> extends UniOperator<I, O> {

    private final Function<E, ? extends Throwable> mapper;

    private final Predicate<? super Throwable> predicate;

    private final Class<E> typeOfFailure;

    public UniOnFailureTransform(Uni<I> upstream, Predicate<? super Throwable> predicate,
            Function<E, ? extends Throwable> mapper, Class<E> typeOfFailure) {
        super(nonNull(upstream, "upstream"));
        this.mapper = nonNull(mapper, "mapper");
        this.predicate = nonNull(predicate, "predicate");
        this.typeOfFailure = nonNull(typeOfFailure, "typeOfFailure");
    }

    @Override
    public void subscribe(UniSubscriber<? super O> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class UniOnFailureTransformProcessor extends UniOperatorProcessor<I, O> {

        public UniOnFailureTransformProcessor(UniSubscriber<? super O> downstream) {
            super(downstream);
        }

        @Override
        public void onFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

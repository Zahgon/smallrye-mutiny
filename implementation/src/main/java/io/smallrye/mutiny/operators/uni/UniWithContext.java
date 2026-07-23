package io.smallrye.mutiny.operators.uni;

import java.util.function.BiFunction;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.UniOperator;
import io.smallrye.mutiny.subscription.UniSubscriber;

public class UniWithContext<I, O> extends UniOperator<I, O> {

    private final Uni<I> upstream;

    private final BiFunction<Uni<I>, Context, Uni<O>> builder;

    public UniWithContext(Uni<I> upstream, BiFunction<Uni<I>, Context, Uni<O>> builder) {
        super(upstream);
        this.upstream = upstream;
        this.builder = builder;
    }

    @Override
    public void subscribe(UniSubscriber<? super O> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package io.smallrye.mutiny.operators.uni.builders;

import java.util.function.Function;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.AbstractUni;
import io.smallrye.mutiny.subscription.UniSubscriber;

public class DeferredUniWithContext<T> extends AbstractUni<T> {

    private final Function<Context, Uni<? extends T>> mapper;

    public DeferredUniWithContext(Function<Context, Uni<? extends T>> mapper) {
        this.mapper = mapper;
    }

    @Override
    public void subscribe(UniSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

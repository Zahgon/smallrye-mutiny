package io.smallrye.mutiny.operators.uni.builders;

import java.util.function.Function;
import java.util.function.Supplier;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.AbstractUni;
import io.smallrye.mutiny.subscription.UniSubscriber;

public class UniCreateFromDeferredSupplierWithState<S, T> extends AbstractUni<T> {

    private final Function<S, Uni<? extends T>> mapper;

    private final StateHolder<S> holder;

    public UniCreateFromDeferredSupplierWithState(Supplier<S> stateSupplier, Function<S, Uni<? extends T>> mapper) {
        this.holder = new StateHolder<>(stateSupplier);
        this.mapper = mapper;
    }

    @Override
    public void subscribe(UniSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

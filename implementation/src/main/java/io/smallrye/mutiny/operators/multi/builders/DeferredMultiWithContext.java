package io.smallrye.mutiny.operators.multi.builders;

import java.util.function.Function;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class DeferredMultiWithContext<T> extends AbstractMulti<T> {

    private final Function<Context, Multi<? extends T>> mapper;

    public DeferredMultiWithContext(Function<Context, Multi<? extends T>> mapper) {
        this.mapper = mapper;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

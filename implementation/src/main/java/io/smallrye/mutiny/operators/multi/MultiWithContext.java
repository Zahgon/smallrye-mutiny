package io.smallrye.mutiny.operators.multi;

import java.util.function.BiFunction;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiWithContext<I, O> extends AbstractMultiOperator<I, O> {

    private final BiFunction<Multi<I>, Context, Multi<O>> builder;

    public MultiWithContext(Multi<? extends I> upstream, BiFunction<Multi<I>, Context, Multi<O>> builder) {
        super(upstream);
        this.builder = builder;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void subscribe(MultiSubscriber<? super O> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

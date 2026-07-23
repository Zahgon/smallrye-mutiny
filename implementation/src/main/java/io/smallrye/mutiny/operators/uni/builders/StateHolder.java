package io.smallrye.mutiny.operators.uni.builders;

import java.util.function.Supplier;

public class StateHolder<S> {

    private final Supplier<S> supplier;

    private boolean once = false;

    private volatile S state;

    public StateHolder(Supplier<S> supplier) {
        this.supplier = supplier;
    }

    public S get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package io.smallrye.mutiny.helpers.spies;

import java.util.concurrent.atomic.AtomicLong;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.UniOperator;

abstract class UniSpyBase<T> extends UniOperator<T, T> {

    private final AtomicLong invocationCount = new AtomicLong();

    protected void incrementInvocationCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long invocationCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean invoked() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    UniSpyBase(Uni<T> upstream) {
        super(upstream);
    }

    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

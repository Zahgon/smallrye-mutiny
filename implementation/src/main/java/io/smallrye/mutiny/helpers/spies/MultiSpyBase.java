package io.smallrye.mutiny.helpers.spies;

import java.util.concurrent.atomic.AtomicLong;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.multi.AbstractMultiOperator;

abstract class MultiSpyBase<T> extends AbstractMultiOperator<T, T> {

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

    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    MultiSpyBase(Multi<? extends T> upstream) {
        super(upstream);
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

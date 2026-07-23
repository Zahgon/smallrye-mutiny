package io.smallrye.mutiny.helpers.spies;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.UniSubscriber;

public class UniOnItemOrFailureSpy<T> extends UniSpyBase<T> {

    private volatile T lastItem;

    private volatile Throwable lastFailure;

    UniOnItemOrFailureSpy(Uni<T> upstream) {
        super(upstream);
    }

    public boolean hasFailed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T lastItem() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Throwable lastFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void subscribe(UniSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

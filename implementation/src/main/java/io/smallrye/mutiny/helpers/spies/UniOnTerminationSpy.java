package io.smallrye.mutiny.helpers.spies;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.tuples.Tuple3;

public class UniOnTerminationSpy<T> extends UniSpyBase<T> {

    private volatile Tuple3<T, Throwable, Boolean> lastTermination;

    UniOnTerminationSpy(Uni<T> upstream) {
        super(upstream);
    }

    public T lastTerminationItem() throws IllegalStateException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Throwable lastTerminationFailure() throws IllegalStateException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean lastTerminationWasCancelled() throws IllegalStateException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void reset() {
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

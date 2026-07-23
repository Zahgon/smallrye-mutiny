package io.smallrye.mutiny.helpers.spies;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;
import io.smallrye.mutiny.tuples.Tuple2;

public class MultiOnTerminationSpy<T> extends MultiSpyBase<T> {

    private volatile Tuple2<Throwable, Boolean> lastTermination;

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

    MultiOnTerminationSpy(Multi<? extends T> upstream) {
        super(upstream);
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

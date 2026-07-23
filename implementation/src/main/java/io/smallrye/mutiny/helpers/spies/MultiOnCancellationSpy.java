package io.smallrye.mutiny.helpers.spies;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiOnCancellationSpy<T> extends MultiSpyBase<T> {

    MultiOnCancellationSpy(Multi<? extends T> upstream) {
        super(upstream);
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isCancelled() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void assertCancelled() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void assertNotCancelled() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

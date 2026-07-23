package io.smallrye.mutiny.helpers.spies;

import java.util.concurrent.atomic.AtomicLong;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiOnRequestSpy<T> extends MultiSpyBase<T> {

    private final AtomicLong requestedCount = new AtomicLong();

    public long requestedCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MultiOnRequestSpy(Multi<? extends T> upstream) {
        super(upstream);
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
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

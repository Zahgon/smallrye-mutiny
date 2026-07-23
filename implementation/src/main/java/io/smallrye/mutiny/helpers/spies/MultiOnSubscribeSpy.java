package io.smallrye.mutiny.helpers.spies;

import java.util.concurrent.Flow.Subscription;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiOnSubscribeSpy<T> extends MultiSpyBase<T> {

    private volatile Subscription lastSubscription;

    public Subscription lastSubscription() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    MultiOnSubscribeSpy(Multi<? extends T> upstream) {
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

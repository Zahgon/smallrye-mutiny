package io.smallrye.mutiny.helpers.test;

import io.smallrye.mutiny.subscription.UniSubscription;

/**
 * A onSubscribe signal.
 */
public final class OnSubscribeUniSignal implements UniSignal {

    private final UniSubscription subscription;

    public OnSubscribeUniSignal(UniSubscription subscription) {
        this.subscription = subscription;
    }

    @Override
    public UniSubscription value() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

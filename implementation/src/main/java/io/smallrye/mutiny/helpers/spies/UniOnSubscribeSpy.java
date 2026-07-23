package io.smallrye.mutiny.helpers.spies;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

public class UniOnSubscribeSpy<T> extends UniSpyBase<T> {

    private volatile UniSubscription lastSubscription;

    public UniSubscription lastSubscription() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    UniOnSubscribeSpy(Uni<T> upstream) {
        super(upstream);
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

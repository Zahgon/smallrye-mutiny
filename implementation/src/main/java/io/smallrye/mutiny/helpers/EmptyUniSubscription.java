package io.smallrye.mutiny.helpers;

import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

/**
 * An implementation of {@link UniSubscription} ignoring all call to {@link #cancel()}.
 * This implementation should be accessed using the {@link #CANCELLED} instance.
 */
public class EmptyUniSubscription implements UniSubscription {

    /**
     * A subscription that has been cancelled.
     * The instance that can be shared.
     * Calling {@link #cancel()} is a no-op.
     */
    public static final UniSubscription CANCELLED = new EmptyUniSubscription();

    /**
     * A subscription that has been done.
     * The instance that can be shared.
     * Calling {@link #cancel()} is a no-op.
     */
    public static final UniSubscription DONE = new EmptyUniSubscription();

    private EmptyUniSubscription() {
        // Avoid direct instantiation.
    }

    public static <T> void propagateFailureEvent(UniSubscriber<T> subscriber, Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void cancel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

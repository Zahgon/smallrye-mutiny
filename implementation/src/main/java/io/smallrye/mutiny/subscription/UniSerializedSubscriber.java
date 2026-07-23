package io.smallrye.mutiny.subscription;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.operators.AbstractUni;

/**
 * An implementation of {@link UniSubscriber} and {@link UniSubscription} making sure event handlers are only called once.
 */
public class UniSerializedSubscriber<T> implements UniSubscriber<T>, UniSubscription {

    private static final int INIT = 0;

    /**
     * Got a downstream subscriber.
     */
    private static final int SUBSCRIBED = 1;

    /**
     * Got a subscription from upstream.
     */
    private static final int HAS_SUBSCRIPTION = 2;

    /**
     * Got a failure or item from upstream
     */
    private static final int DONE = 3;

    private final AtomicInteger state = new AtomicInteger(INIT);

    private final AbstractUni<T> upstream;

    private final UniSubscriber<? super T> downstream;

    private volatile UniSubscription subscription;

    private final AtomicReference<Throwable> failure = new AtomicReference<>();

    public UniSerializedSubscriber(AbstractUni<T> upstream, UniSubscriber<? super T> subscriber) {
        this.upstream = ParameterValidation.nonNull(upstream, "source");
        this.downstream = ParameterValidation.nonNull(subscriber, "subscriber` must not be `null`");
    }

    public static <T> void subscribe(AbstractUni<T> source, UniSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void subscribe() {
        if (state.compareAndSet(INIT, SUBSCRIBED)) {
            upstream.subscribe(this);
        }
    }

    @Override
    public Context context() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onSubscribe(UniSubscription subscription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onItem(T item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onFailure(Throwable throwable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void cancel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

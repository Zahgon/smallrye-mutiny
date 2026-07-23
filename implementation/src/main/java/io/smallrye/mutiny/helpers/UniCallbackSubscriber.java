package io.smallrye.mutiny.helpers;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Consumer;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

/**
 * Implementation of a {@link UniSubscriber} based on callbacks.
 * This implementation also implement {@link UniSubscription} to expose the {@link #cancel()} method.
 *
 * @param <T> the type of item received by this subscriber
 */
public class UniCallbackSubscriber<T> implements UniSubscriber<T>, UniSubscription {

    private volatile UniSubscription subscription;

    private static final AtomicReferenceFieldUpdater<UniCallbackSubscriber, UniSubscription> SUBSCRIPTION_UPDATER = AtomicReferenceFieldUpdater
            .newUpdater(UniCallbackSubscriber.class, UniSubscription.class, "subscription");

    private final Consumer<? super T> onResultCallback;

    private final Consumer<? super Throwable> onFailureCallback;

    private final Context context;

    /**
     * Creates a {@link UniSubscriber} consuming the item and failure of a
     * {@link Uni}.
     *
     * @param onResultCallback callback invoked on item event, must not be {@code null}
     * @param onFailureCallback callback invoked on failure event, must not be {@code null}
     * @param context the subscriber context, must not be {@code null}
     */
    public UniCallbackSubscriber(Consumer<? super T> onResultCallback, Consumer<? super Throwable> onFailureCallback,
            Context context) {
        this.onResultCallback = nonNull(onResultCallback, "onResultCallback");
        this.onFailureCallback = nonNull(onFailureCallback, "onFailureCallback");
        this.context = nonNull(context, "context");
    }

    @Override
    public final void onSubscribe(UniSubscription sub) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final void onFailure(Throwable t) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final void onItem(T x) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void cancel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Context context() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

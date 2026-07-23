package io.smallrye.mutiny.groups;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.operators.AbstractUni;
import io.smallrye.mutiny.subscription.Cancellable;
import io.smallrye.mutiny.subscription.UniSubscriber;

/**
 * Allow subscribing to a {@link Uni} to be notified of the different events coming from {@code upstream}.
 * Two kind of events can be received:
 * <ul>
 * <li>{@code item} - the item of the {@link Uni}, can be {@code null}</li>
 * <li>{@code failure} - the failure propagated by the {@link Uni}</li>
 * </ul>
 *
 * @param <T> the type of item
 */
public class UniSubscribe<T> {

    private final AbstractUni<T> upstream;

    public UniSubscribe(AbstractUni<T> upstream) {
        this.upstream = ParameterValidation.nonNull(upstream, "upstream");
    }

    public <S extends UniSubscriber<? super T>> S withSubscriber(S subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <S extends UniSubscriber<? super T>> S withSerializedSubscriber(S subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Cancellable with(Consumer<? super T> onItemCallback, Consumer<? super Throwable> onFailureCallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Cancellable with(Context context, Consumer<? super T> onItemCallback,
            Consumer<? super Throwable> onFailureCallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Cancellable with(Context context, Consumer<? super T> onItemCallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Cancellable with(Consumer<? super T> onItemCallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CompletableFuture<T> asCompletionStage() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public CompletableFuture<T> asCompletionStage(Context context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

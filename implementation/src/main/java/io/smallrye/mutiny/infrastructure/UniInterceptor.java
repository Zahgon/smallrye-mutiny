package io.smallrye.mutiny.infrastructure;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.UniSubscriber;

/**
 * Allow being notified when a new {@link Uni} instance is created and when this {@link Uni} receives events.
 * <p>
 * Implementations are expected to be exposed as SPI, and so the implementation class must be declared in the
 * {@code META-INF/services/io.smallrye.mutiny.infrastructure.UniInterceptor} file.
 */
public interface UniInterceptor extends MutinyInterceptor {

    default <T> Uni<T> onUniCreation(Uni<T> uni) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <T> UniSubscriber<? super T> onSubscription(Uni<T> instance, UniSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

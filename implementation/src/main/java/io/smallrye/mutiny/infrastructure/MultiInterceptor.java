package io.smallrye.mutiny.infrastructure;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;

import io.smallrye.mutiny.Multi;

/**
 * Allow being notified when a new {@link Multi} instance is created and when this {@link Multi} receives events.
 * <p>
 * Implementations are expected to be exposed as SPI, and so the implementation class must be declared in the
 * {@code META-INF/services/io.smallrye.mutiny.infrastructure.MultiInterceptor} file.
 */
public interface MultiInterceptor extends MutinyInterceptor {

    default <T> Multi<T> onMultiCreation(Multi<T> multi) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <T> Subscriber<? super T> onSubscription(Flow.Publisher<? extends T> instance, Subscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

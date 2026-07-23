package io.smallrye.mutiny.helpers;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Methods to implement <em>half-serialization</em>: a form of serialization where {@code onNext} is guaranteed to be
 * called from a single thread but {@code onError} or {@code onComplete} may be called from any threads.
 */
public final class HalfSerializer {

    private HalfSerializer() {
        // avoid direct instantiation.
    }

    private static final Exception COMPLETION_PLACEHOLDER = new Exception("This is a completion placeholder");

    public static <T> void onNext(Subscriber<? super T> subscriber, T item, AtomicInteger wip,
            AtomicReference<Throwable> container) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void onError(Subscriber<?> subscriber, Throwable failure, AtomicInteger wip,
            AtomicReference<Throwable> container) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void onComplete(Subscriber<?> subscriber, AtomicInteger wip, AtomicReference<Throwable> container) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

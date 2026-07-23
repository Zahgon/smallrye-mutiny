package io.smallrye.mutiny.operators.uni;

import java.time.Duration;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;

public class UniBlockingAwait {

    private UniBlockingAwait() {
        // Avoid direct instantiation.
    }

    public static <T> T await(Uni<T> upstream, Duration duration, Context context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static IllegalStateException currentThreadCannotBeBlocked() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void validate(Duration duration) {
        if (duration == null) {
            return;
        }
        if (duration.isZero() || duration.isNegative()) {
            throw new IllegalArgumentException("`duration` must be greater than zero");
        }
    }
}

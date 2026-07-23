package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.time.Duration;
import java.util.concurrent.CompletionException;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import io.smallrye.mutiny.operators.uni.UniBlockingAwait;
import io.smallrye.mutiny.operators.uni.builders.UniCreateFromKnownFailure;
import io.smallrye.mutiny.operators.uni.builders.UniCreateFromKnownItem;

/**
 * Waits and returns the item emitted by the {@link Uni}. If the {@link Uni} receives a failure, the failure is thrown.
 * <p>
 * This class lets you configure how to retrieves the item of a {@link Uni} by blocking the caller thread.
 *
 * @param <T> the type of item
 * @see Uni#await()
 */
public class UniAwait<T> {

    private final Uni<T> upstream;

    private final Context context;

    public UniAwait(Uni<T> upstream, Context context) {
        this.upstream = nonNull(upstream, "upstream");
        this.context = context;
    }

    public T indefinitely() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T atMost(Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public UniAwaitOptional<T> asOptional() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private T awaitKnownItem(UniCreateFromKnownItem<T> known, Duration duration) {
        validateDuration(duration);
        // Blocking should not matter in this case but we retain the check for backward compatibility
        if (!Infrastructure.canCallerThreadBeBlocked()) {
            throw UniBlockingAwait.currentThreadCannotBeBlocked();
        }
        return known.getItem();
    }

    private void awaitKnownFailure(UniCreateFromKnownFailure<T> known, Duration duration) {
        validateDuration(duration);
        // Blocking should not matter in this case but we retain the check for backward compatibility
        if (!Infrastructure.canCallerThreadBeBlocked()) {
            throw UniBlockingAwait.currentThreadCannotBeBlocked();
        }
        Throwable throwable = known.getFailure();
        if (throwable instanceof RuntimeException) {
            throw (RuntimeException) throwable;
        }
        throw new CompletionException(throwable);
    }

    private void validateDuration(Duration duration) {
        if (duration != null && (duration.isZero() || duration.isNegative())) {
            throw new IllegalArgumentException("`duration` must be greater than zero");
        }
    }
}

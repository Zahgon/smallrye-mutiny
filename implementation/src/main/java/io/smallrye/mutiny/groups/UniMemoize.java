package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.time.Duration;
import java.util.function.BooleanSupplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.AbstractUni;

public class UniMemoize<T> {

    private final Uni<T> upstream;

    public UniMemoize(AbstractUni<T> upstream) {
        this.upstream = nonNull(upstream, "upstream");
    }

    @CheckReturnValue
    public Uni<T> until(BooleanSupplier invalidationGuard) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Memoize the received item or failure for a duration after the upstream subscription has been received.
     * <p>
     * New subscribers will receive the memoized item or failure.
     * When duration has elapsed then the first subscription causes a new upstream subscription, and the next
     * subscribers get a chance to observe new values.
     *
     * @param duration the memoization duration after having received the subscription from upstream, must not be
     *        {@code null}, must be strictly positive
     * @return a new {@link Uni}
     * @deprecated use {@link #forFixedDuration(Duration)} instead.
     */
    @Deprecated(forRemoval = true)
    @CheckReturnValue
    public Uni<T> atLeast(Duration duration) {
        return forFixedDuration(duration);
    }

    @CheckReturnValue
    public Uni<T> forFixedDuration(Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> indefinitely() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

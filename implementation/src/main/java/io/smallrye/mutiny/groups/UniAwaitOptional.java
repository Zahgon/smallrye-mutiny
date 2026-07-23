package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.time.Duration;
import java.util.Optional;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;

/**
 * Likes {@link UniAwait} but wrapping the item event into an {@link Optional}. This optional is empty if the
 * {@link Uni} fires {@code null}.
 *
 * @param <T> the type of the item
 * @see Uni#await()
 */
public class UniAwaitOptional<T> {

    private final Uni<T> upstream;

    private final Context context;

    public UniAwaitOptional(Uni<T> upstream, Context context) {
        this.upstream = nonNull(upstream, "upstream");
        this.context = context;
    }

    public Optional<T> indefinitely() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Optional<T> atMost(Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

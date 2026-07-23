package io.smallrye.mutiny.groups;

import java.time.Duration;
import java.util.function.Predicate;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

/**
 * Repeatedly subscribes to a given {@link Uni} to generate a {@link Multi}.
 *
 * @param <T> the type of item
 */
public class UniRepeat<T> {

    private final Uni<T> upstream;

    private final Uni<?> delay;

    public UniRepeat(Uni<T> upstream) {
        this(upstream, null);
    }

    public UniRepeat(Uni<T> upstream, Uni<?> delay) {
        this.upstream = upstream;
        this.delay = delay;
    }

    @CheckReturnValue
    public UniRepeat<T> withDelay(Duration delay) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> indefinitely() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> atMost(long times) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> until(Predicate<T> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> whilst(Predicate<T> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

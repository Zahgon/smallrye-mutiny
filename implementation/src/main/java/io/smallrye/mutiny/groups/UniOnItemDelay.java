package io.smallrye.mutiny.groups;

import java.time.Duration;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;

/**
 * Configures the delay applied to the item emission.
 * It allows delaying the item emitted by the previous {@code Uni} to its downstream.
 *
 * @param <T> the type of item
 */
public class UniOnItemDelay<T> {

    private final Uni<T> upstream;

    private ScheduledExecutorService executor;

    /**
     * Creates a new {@code UniOnItemDelay} instance.
     *
     * @param upstream the upstream uni
     * @param executor the executor, can be {@code null}, if {@code null} used the default worker executor.
     */
    public UniOnItemDelay(Uni<T> upstream, ScheduledExecutorService executor) {
        this.upstream = upstream;
        this.executor = executor == null ? Infrastructure.getDefaultWorkerPool() : executor;
    }

    @CheckReturnValue
    public UniOnItemDelay<T> onExecutor(ScheduledExecutorService executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> by(Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> until(Function<? super T, Uni<?>> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

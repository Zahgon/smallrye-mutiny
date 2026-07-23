package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.time.Duration;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Supplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Uni;

public class UniOnTimeout<T> {

    private final Uni<T> failure;

    private final Duration timeout;

    private final ScheduledExecutorService executor;

    public UniOnTimeout(Uni<T> upstream, Duration timeout, ScheduledExecutorService executor) {
        this.failure = nonNull(upstream, "upstream");
        this.timeout = timeout;
        this.executor = executor;
    }

    @CheckReturnValue
    public UniOnTimeout<T> after(Duration timeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public UniOnTimeout<T> on(ScheduledExecutorService executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> fail() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> failWith(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> failWith(Supplier<? extends Throwable> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> recoverWithItem(T fallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> recoverWithItem(Supplier<T> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> recoverWithUni(Supplier<Uni<? extends T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> recoverWithUni(Uni<? extends T> fallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;
import static io.smallrye.mutiny.helpers.ParameterValidation.validate;

import java.time.Duration;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Supplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;

public class MultiOnItemTimeout<T> {

    private final Multi<T> failure;

    private final Duration timeout;

    private final ScheduledExecutorService executor;

    public MultiOnItemTimeout(Multi<T> upstream, Duration timeout, ScheduledExecutorService executor) {
        this.failure = nonNull(upstream, "upstream");
        this.timeout = validate(timeout, "timeout");
        this.executor = executor;
    }

    public MultiOnItemTimeout<T> on(ScheduledExecutorService executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> fail() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> failWith(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> failWith(Supplier<? extends Throwable> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> recoverWithCompletion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> recoverWithMulti(Supplier<Multi<? extends T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> recoverWithMulti(Multi<? extends T> fallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

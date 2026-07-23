package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.time.Duration;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;
import java.util.function.Predicate;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.ExponentialBackoff;

public class MultiRetry<T> {

    private final Multi<T> upstream;

    private final Predicate<? super Throwable> onFailurePredicate;

    private Duration initialBackOff = Duration.ofSeconds(1);

    private Duration maxBackoff = ExponentialBackoff.MAX_BACKOFF;

    private double jitter = ExponentialBackoff.DEFAULT_JITTER;

    private boolean backOffConfigured = false;

    private ScheduledExecutorService executor = null;

    public MultiRetry(Multi<T> upstream, Predicate<? super Throwable> onFailurePredicate) {
        this.upstream = nonNull(upstream, "upstream");
        this.onFailurePredicate = nonNull(onFailurePredicate, "onFailurePredicate");
    }

    @CheckReturnValue
    public MultiRetry<T> withExecutor(ScheduledExecutorService executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> indefinitely() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> atMost(long numberOfAttempts) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> expireAt(long expireAt) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> expireIn(long expireIn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> until(Predicate<? super Throwable> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> when(Function<Multi<Throwable>, ? extends Publisher<?>> whenStreamFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiRetry<T> withBackOff(Duration initialBackOff) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiRetry<T> withBackOff(Duration initialBackOff, Duration maxBackOff) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiRetry<T> withJitter(double jitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package io.smallrye.mutiny.groups;

import java.time.Duration;
import java.util.concurrent.Flow;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.Function;
import java.util.function.Predicate;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.ExponentialBackoff;

// TODO This method should be renamed to UniOnFailureRetry, however it's a breaking change.
public class UniRetry<T> {

    private final Uni<T> upstream;

    private final Predicate<? super Throwable> onFailurePredicate;

    private Duration initialBackOffDuration = Duration.ofSeconds(1);

    private Duration maxBackoffDuration = ExponentialBackoff.MAX_BACKOFF;

    private double jitter = ExponentialBackoff.DEFAULT_JITTER;

    private boolean backOffConfigured = false;

    private ScheduledExecutorService executor = null;

    public UniRetry(Uni<T> upstream, Predicate<? super Throwable> onFailurePredicate) {
        this.upstream = upstream;
        this.onFailurePredicate = onFailurePredicate;
    }

    @CheckReturnValue
    public UniRetry<T> withExecutor(ScheduledExecutorService executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> indefinitely() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> atMost(long numberOfAttempts) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> expireAt(long expireAt) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> expireIn(long expireIn) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> until(Predicate<? super Throwable> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> when(Function<Multi<Throwable>, ? extends Flow.Publisher<?>> whenStreamFactory) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public UniRetry<T> withBackOff(Duration initialBackOff) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public UniRetry<T> withBackOff(Duration initialBackOff, Duration maxBackOff) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public UniRetry<T> withJitter(double jitter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

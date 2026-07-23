package io.smallrye.mutiny.helpers;

import java.time.Duration;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.function.Predicate;

import io.smallrye.mutiny.Multi;

public class ExponentialBackoff {

    public static final Duration MAX_BACKOFF = Duration.ofMillis(Long.MAX_VALUE);

    public static final double DEFAULT_JITTER = 0.5;

    private ExponentialBackoff() {
        // avoid direct instantiation
    }

    public static Function<Multi<Throwable>, Publisher<Long>> randomExponentialBackoffFunction(long numRetries,
            Duration firstBackoff, Duration maxBackoff, double jitterFactor, ScheduledExecutorService executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static Duration getNextDelay(Duration firstBackoff, Duration maxBackoff, double jitterFactor, int iteration) {
        Duration nextBackoff = getNextAttemptDelay(firstBackoff, maxBackoff, iteration);
        // Compute the jitter
        long jitterOffset = getJitter(jitterFactor, nextBackoff);
        long lowBound = Math.max(firstBackoff.minus(nextBackoff).toMillis(), -jitterOffset);
        long highBound = Math.min(maxBackoff.minus(nextBackoff).toMillis(), jitterOffset);
        long jitter;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        if (highBound == lowBound) {
            if (highBound == 0) {
                jitter = 0;
            } else {
                jitter = random.nextLong(highBound);
            }
        } else {
            jitter = random.nextLong(lowBound, highBound);
        }
        return nextBackoff.plusMillis(jitter);
    }

    private static void validate(Duration firstBackoff, Duration maxBackoff, double jitterFactor,
            ScheduledExecutorService executor) {
        if (jitterFactor < 0 || jitterFactor > 1) {
            throw new IllegalArgumentException("jitterFactor must be between 0 and 1 (default 0.5)");
        }
        ParameterValidation.nonNull(firstBackoff, "firstBackoff");
        ParameterValidation.nonNull(maxBackoff, "maxBackoff");
        ParameterValidation.nonNull(executor, "executor");
    }

    public static Function<Multi<Throwable>, Publisher<Long>> randomExponentialBackoffFunctionExpireAt(long expireAt,
            Duration firstBackoff, Duration maxBackoff, double jitterFactor, ScheduledExecutorService executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static long getJitter(double jitterFactor, Duration nextBackoff) {
        long jitterOffset;
        try {
            jitterOffset = nextBackoff.multipliedBy((long) (100 * jitterFactor)).dividedBy(100).toMillis();
        } catch (ArithmeticException ae) {
            jitterOffset = Math.round(Long.MAX_VALUE * jitterFactor);
        }
        return jitterOffset;
    }

    private static Duration getNextAttemptDelay(Duration firstBackoff, Duration maxBackoff, int iteration) {
        Duration nextBackoff;
        try {
            nextBackoff = firstBackoff.multipliedBy((long) Math.pow(2, iteration));
            if (nextBackoff.compareTo(maxBackoff) > 0) {
                nextBackoff = maxBackoff;
            }
        } catch (ArithmeticException overflow) {
            nextBackoff = maxBackoff;
        }
        return nextBackoff;
    }

    public static Function<Multi<Throwable>, Publisher<Long>> backoffWithPredicateFactory(final Duration initialBackOff,
            final double jitter, final Duration maxBackoff, Predicate<? super Throwable> predicate,
            ScheduledExecutorService pool) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Function<Multi<Throwable>, Publisher<Long>> noBackoffPredicateFactory(
            Predicate<? super Throwable> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

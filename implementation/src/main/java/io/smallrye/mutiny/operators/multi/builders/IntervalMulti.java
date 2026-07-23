package io.smallrye.mutiny.operators.multi.builders;

import java.time.Duration;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class IntervalMulti extends AbstractMulti<Long> {

    private final ScheduledExecutorService executor;

    private final Duration initialDelay;

    private final Duration period;

    public IntervalMulti(Duration initialDelay, Duration period, ScheduledExecutorService executor) {
        this.initialDelay = ParameterValidation.validate(initialDelay, "initialDelay");
        this.period = ParameterValidation.validate(period, "period");
        this.executor = ParameterValidation.nonNull(executor, "executor");
    }

    public IntervalMulti(Duration period, ScheduledExecutorService executor) {
        this.initialDelay = null;
        this.period = ParameterValidation.validate(period, "period");
        this.executor = ParameterValidation.nonNull(executor, "executor");
    }

    @Override
    public void subscribe(MultiSubscriber<? super Long> actual) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class IntervalRunnable implements Runnable, Flow.Subscription {

        private final MultiSubscriber<? super Long> actual;

        private final AtomicLong requested = new AtomicLong();

        private final Duration period;

        private final Duration initialDelay;

        private final ScheduledExecutorService executor;

        private volatile boolean cancelled;

        private final AtomicBoolean once = new AtomicBoolean(true);

        private final AtomicLong count = new AtomicLong();

        private ScheduledFuture<?> future;

        IntervalRunnable(MultiSubscriber<? super Long> actual, Duration period, Duration initial,
                ScheduledExecutorService executor) {
            this.actual = actual;
            this.period = period;
            this.initialDelay = initial;
            this.executor = executor;
        }

        public void start() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void run() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public synchronized void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

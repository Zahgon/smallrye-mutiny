package io.smallrye.mutiny.operators.uni;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;
import static io.smallrye.mutiny.helpers.ParameterValidation.positive;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.function.Predicate;

import io.smallrye.mutiny.CompositeException;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.UniOperator;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

public class UniRetryAtMost<T> extends UniOperator<T, T> {

    private final Predicate<? super Throwable> predicate;

    private final long maxAttempts;

    public UniRetryAtMost(Uni<T> upstream, Predicate<? super Throwable> predicate, long maxAttempts) {
        super(nonNull(upstream, "upstream"));
        this.predicate = nonNull(predicate, "predicate");
        this.maxAttempts = positive(maxAttempts, "maxAttempts");
    }

    @Override
    public void subscribe(UniSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class UniRetryAtMostProcessor<T> extends UniOperatorProcessor<T, T> {

        private final UniRetryAtMost<T> uniRetryAtMost;

        private volatile int counter = 0;

        private static final AtomicIntegerFieldUpdater<UniRetryAtMostProcessor> counterUpdater = AtomicIntegerFieldUpdater
                .newUpdater(UniRetryAtMostProcessor.class, "counter");

        public UniRetryAtMostProcessor(UniRetryAtMost<T> uniRetryAtMost, UniSubscriber<? super T> downstream) {
            super(downstream);
            this.uniRetryAtMost = uniRetryAtMost;
        }

        @Override
        public void onSubscribe(UniSubscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private boolean testPredicate(Throwable failure) {
            boolean passes;
            try {
                passes = uniRetryAtMost.predicate.test(failure);
            } catch (Throwable e) {
                downstream.onFailure(new CompositeException(e, failure));
                return false;
            }
            if (!passes) {
                downstream.onFailure(failure);
                return false;
            } else {
                return true;
            }
        }
    }
}

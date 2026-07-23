package io.smallrye.mutiny.helpers;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

import io.smallrye.mutiny.subscription.UniSubscription;

public class Subscriptions {

    public static final Throwable TERMINATED = new Exception("Terminated");

    private Subscriptions() {
        // avoid direct instantiation
    }

    public static IllegalArgumentException getInvalidRequestException() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Subscription empty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * This instance must not be shared.
     * Calling {@link Subscription#cancel()} is a no-op.
     */
    public static final EmptySubscription CANCELLED = new EmptySubscription();

    public static void complete(Subscriber<?> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void fail(Subscriber<?> subscriber, Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void fail(Subscriber<?> subscriber, Throwable failure, Publisher<?> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static long add(long a, long b) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static long add(AtomicLong requested, long requests) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> long add(AtomicLongFieldUpdater<T> updater, T receiver, long requests) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static long subtract(AtomicLong requested, long emitted) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static int unboundedOrLimit(int prefetch) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static long unboundedOrRequests(int concurrency) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static boolean addFailure(AtomicReference<Throwable> failures, Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void cancel(AtomicReference<Subscription> reference) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Throwable markFailureAsTerminated(AtomicReference<Throwable> failures) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void terminateAndPropagate(AtomicReference<Throwable> failures, Subscriber<?> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static long multiply(long n, long times) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void requestIfNotNullOrAccumulate(AtomicReference<Subscription> field, AtomicLong requested, long requests) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static boolean setIfEmptyAndRequest(AtomicReference<Subscription> container, AtomicLong requested,
            Subscription subscription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static boolean setIfEmpty(AtomicReference<Subscription> container, Subscription subscription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Throwable terminate(AtomicReference<Throwable> failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class EmptySubscription implements Subscription, UniSubscription {

        @Override
        public void request(long requests) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static long produced(AtomicLong requested, long amount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static long subOrZero(long a, long b) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Subscription single(Subscriber<T> downstream, T item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static final class SingleItemSubscription<T> implements Subscription {

        private final Subscriber<? super T> downstream;

        private final T item;

        private final AtomicBoolean requested = new AtomicBoolean();

        public SingleItemSubscription(Subscriber<? super T> actual, T item) {
            this.downstream = ParameterValidation.nonNull(actual, "actual");
            this.item = ParameterValidation.nonNull(item, "item");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void request(long requests) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class CancelledSubscriber<X> implements Subscriber<X> {

        @Override
        public void onSubscribe(Subscription s) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onNext(X o) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onError(Throwable t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onComplete() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static class DeferredSubscription implements Subscription {

        private final AtomicReference<Subscription> subscription = new AtomicReference<>();

        private final AtomicLong pendingRequests = new AtomicLong();

        protected boolean isCancelled() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public boolean set(Subscription newSubscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static long producedAndHandleAlreadyCancelled(AtomicLong requested, long n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static long addAndHandledAlreadyCancelled(AtomicLong requested, long n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

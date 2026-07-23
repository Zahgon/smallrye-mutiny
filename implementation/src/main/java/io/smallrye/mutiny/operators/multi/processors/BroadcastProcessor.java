package io.smallrye.mutiny.operators.multi.processors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * Implementation of {@link Processor} that broadcast all subsequently observed items to its current
 * {@link Subscriber}s.
 * <p>
 * This processor does not coordinate back-pressure between different subscribers and between the upstream source and a
 * subscriber. If an upstream item is received via {@link #onNext(Object)}, if a subscriber is not ready to receive that
 * item, that subscriber is terminated via a {@link io.smallrye.mutiny.subscription.BackPressureFailure}.
 * <p>
 * The {@code BroadcastProcessor}'s {@link Subscriber}-side consumes items in an unbounded manner.
 * <p>
 * When this {@code BroadcastProcessor} is terminated via {@link #onError(Throwable)} or {@link #onComplete()}, late
 * {@link Subscriber}s only receive the respective terminal event.
 * <p>
 * Unlike the {@link UnicastProcessor}, a {@code BroadcastProcessor} doesn't retain/cache items, therefore, a new
 * {@code Subscriber} won't receive any past items.
 * <p>
 * Even though {@code BroadcastProcessor} implements the {@link Subscriber} interface, calling {@code onSubscribe} is
 * not required if the processor is used as a <em>standalone</em> source. However, calling {@code onSubscribe} after
 * the {@code BroadcastProcessor} has failed or reached completion results in the given {@link Subscription} being
 * canceled immediately.
 */
public class BroadcastProcessor<T> extends AbstractMulti<T> implements Processor<T, T> {

    /**
     * Value indicating that the upstream has been cancelled.
     */
    static final List<?> TERMINATED = new ArrayList<>(0);

    /**
     * The array of currently subscribed subscribers.
     */
    final AtomicReference<List<BroadcastSubscription<T>>> subscribers;

    /**
     * The failure, write before terminating and read after checking subscribers.
     */
    Throwable failure;

    public static <T> BroadcastProcessor<T> create() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Constructs a BroadcastProcessor.
     */
    private BroadcastProcessor() {
        subscribers = new AtomicReference<>(new CopyOnWriteArrayList<>());
    }

    public SerializedProcessor<T, T> serialized() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Tries to add the given subscriber to the subscribers array atomically
     * or returns {@code false} if this processor has terminated.
     *
     * @param sub the subscriber to add
     * @return {@code true} if successful, {@code false} if this processor has terminated
     */
    private boolean addSubscription(BroadcastSubscription<T> sub) {
        List<BroadcastSubscription<T>> current = subscribers.get();
        if (current == TERMINATED) {
            return false;
        }
        return current.add(sub);
    }

    void remove(BroadcastSubscription<T> sub) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onNext(T item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void onError(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void onComplete() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Wraps the actual subscriber, tracks its requests and makes cancellation
     * to remove itself from the current subscribers array.
     *
     * @param <T> the type of item
     */
    static final class BroadcastSubscription<T> implements Subscription {

        /**
         * The actual subscriber.
         */
        private final Subscriber<? super T> downstream;

        /**
         * The parent processor using this subscriber.
         */
        private final BroadcastProcessor<T> parent;

        /**
         * Pending requests.
         * {@code Long.MIN_VALUE} indicates cancellation.
         */
        private final AtomicLong requests = new AtomicLong();

        /**
         * Constructs a BroadcastSubscription, wraps the actual subscriber and the state.
         *
         * @param actual the actual subscriber
         * @param parent the parent PublishProcessor
         */
        BroadcastSubscription(Subscriber<? super T> actual, BroadcastProcessor<T> parent) {
            this.downstream = actual;
            this.parent = parent;
        }

        public void onNext(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void onError(Throwable t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void onComplete() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public boolean isCancelled() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

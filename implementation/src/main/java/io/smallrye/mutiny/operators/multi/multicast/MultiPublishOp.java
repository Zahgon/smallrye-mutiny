package io.smallrye.mutiny.operators.multi.multicast;

import java.util.Queue;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.queues.Queues;
import io.smallrye.mutiny.subscription.Cancellable;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * A connectable observable which shares an underlying source and dispatches source values to subscribers in a
 * back-pressure-aware manner.
 *
 * @param <T> the value type
 */
public final class MultiPublishOp<T> extends ConnectableMulti<T> {

    /**
     * Indicates this child has been cancelled: the state is swapped in atomically and
     * will prevent the dispatch() to emit (too many) values to a terminated child subscriber.
     */
    private static final long CANCELLED = Long.MIN_VALUE;

    /**
     * Holds the current subscriber that is, will be or just was subscribed to the source observable.
     */
    private final AtomicReference<PublishSubscriber<T>> current;

    /**
     * The size of the prefetch buffer.
     */
    private final int bufferSize;

    private final Publisher<T> onSubscribe;

    public static <T> ConnectableMulti<T> create(Multi<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private MultiPublishOp(Publisher<T> onSubscribe, Multi<T> upstream, final AtomicReference<PublishSubscriber<T>> current,
            int bufferSize) {
        super(upstream);
        this.onSubscribe = onSubscribe;
        this.current = current;
        this.bufferSize = bufferSize;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> s) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void connect(ConnectableMultiConnection connection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings({ "rawtypes", "SubscriberImplementation" })
    static final class PublishSubscriber<T> implements Cancellable, MultiSubscriber<T>, ContextSupport {

        /**
         * Indicates an empty array of inner subscribers.
         */
        static final InnerSubscriber[] EMPTY = new InnerSubscriber[0];

        /**
         * Indicates a terminated PublishSubscriber.
         */
        static final InnerSubscriber[] TERMINATED = new InnerSubscriber[0];

        /**
         * Holds onto the current connected PublishSubscriber.
         */
        final AtomicReference<PublishSubscriber<T>> current;

        /**
         * The prefetch buffer size.
         */
        final int bufferSize;

        /**
         * Tracks the subscribed InnerSubscribers.
         */
        final AtomicReference<InnerSubscriber<T>[]> subscribers;

        /**
         * Atomically changed from false to true by connect to make sure the
         * connection is only performed by one thread.
         */
        final AtomicBoolean shouldConnect;

        final AtomicReference<Subscription> upstream = new AtomicReference<>();

        /**
         * Contains either the failure or the `COMPLETED` object.
         */
        private final AtomicReference<Throwable> failureOrCompletion = new AtomicReference<>();

        private static final Throwable COMPLETED = new Exception();

        private final Queue<T> queue;

        private final AtomicBoolean cancelled = new AtomicBoolean();

        private final AtomicInteger wip = new AtomicInteger();

        private final Context context;

        @SuppressWarnings("unchecked")
        PublishSubscriber(AtomicReference<PublishSubscriber<T>> current, int bufferSize, Context context) {
            this.context = context;
            this.subscribers = new AtomicReference<>(EMPTY);
            this.current = current;
            this.shouldConnect = new AtomicBoolean();
            this.bufferSize = bufferSize;
            this.queue = (Queue<T>) Queues.get(bufferSize).get();
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onSubscribe(Subscription s) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable e) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        boolean add(InnerSubscriber<T> producer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings("unchecked")
        void remove(InnerSubscriber<T> producer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings("unchecked")
        boolean isEmptyOrCompleted(Throwable term, boolean empty) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void drain() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Context context() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * A Subscription that manages the request and cancellation state of a
     * child subscriber in thread-safe manner.
     *
     * @param <T> the value type
     */
    static final class InnerSubscriber<T> implements Subscription {

        /**
         * Requested number of items.
         */
        private final AtomicLong requested = new AtomicLong();

        /**
         * The actual child subscriber.
         */
        private final Subscriber<? super T> downstream;

        /**
         * The parent subscriber-to-source used to allow removing the child in case of
         * child cancellation.
         */
        private final AtomicReference<PublishSubscriber<T>> parent = new AtomicReference<>();

        /**
         * Track the number of emitted items (avoids decrementing the request counter).
         */
        long emitted;

        InnerSubscriber(Subscriber<? super T> child) {
            this.downstream = child;
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @SuppressWarnings("PublisherImplementation")
    static final class InnerPublisher<T> implements Publisher<T> {

        private final AtomicReference<PublishSubscriber<T>> curr;

        private final int bufferSize;

        InnerPublisher(AtomicReference<PublishSubscriber<T>> curr, int bufferSize) {
            this.curr = curr;
            this.bufferSize = bufferSize;
        }

        @Override
        public void subscribe(Subscriber<? super T> child) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

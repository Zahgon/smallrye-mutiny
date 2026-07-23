package io.smallrye.mutiny.operators.multi;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * A {@code multi} caching the events emitted from upstreams and replaying it to subscribers.
 * This multi can have several subscribers.
 *
 * @param <T> the type of item
 */
@SuppressWarnings("SubscriberImplementation")
public class MultiCacheOp<T> extends AbstractMultiOperator<T, T> implements Subscriber<T>, ContextSupport {

    /**
     * Stores whether we already subscribed to the upstream.
     */
    private final AtomicBoolean hasSubscribedToUpstream = new AtomicBoolean();

    /**
     * The current set of downstream subscribers.
     */
    private final List<CacheSubscription<T>> subscribers = new CopyOnWriteArrayList<>();

    private volatile boolean terminated;

    private final CopyOnWriteArrayList<Node<T>> history = new CopyOnWriteArrayList<>();

    private volatile Context context;

    /**
     * If the upstream has terminated with a failure, this stores the failure.
     */
    private Throwable failure;

    /**
     * {@code true} if the source has terminated.
     */
    private volatile boolean done;

    public MultiCacheOp(Multi<T> upstream) {
        super(upstream);
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private synchronized void addDownstreamSubscription(CacheSubscription<T> consumer) {
        if (terminated) {
            return;
        }
        subscribers.add(consumer);
    }

    private synchronized void remove(CacheSubscription<T> consumer) {
        subscribers.remove(consumer);
    }

    @Override
    public void onSubscribe(Subscription s) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public synchronized void onNext(T item) {
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

    @Override
    public Context context() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Hosts the downstream consumer and its current requested and replay states.
     * {@code this} holds the work-in-progress counter for the serialized replay.
     *
     * @param <T> the value type
     */
    static final class CacheSubscription<T> implements Subscription {

        private final MultiSubscriber<? super T> downstream;

        private final MultiCacheOp<T> cache;

        private final AtomicLong requested = new AtomicLong();

        private final AtomicInteger wip = new AtomicInteger();

        private int lastIndex;

        CacheSubscription(MultiSubscriber<? super T> downstream, MultiCacheOp<T> cache) {
            this.downstream = downstream;
            this.cache = cache;
            this.lastIndex = -1;
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void replay() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        boolean hasNext() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Node stored in the list.
     *
     * @param <T> the type of item.
     */
    static final class Node<T> {

        private final T item;

        Node(T item) {
            this.item = item;
        }
    }
}

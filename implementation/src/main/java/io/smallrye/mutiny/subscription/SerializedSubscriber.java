package io.smallrye.mutiny.subscription;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicReference;

import io.smallrye.mutiny.Context;

/**
 * Subscriber that makes sure signals are delivered sequentially in case the onNext, onError or onComplete methods are
 * called concurrently.
 * <p>
 * Class copied from Project Reactor.
 *
 * @param <T> the type of items
 */
public final class SerializedSubscriber<T> implements Subscription, MultiSubscriber<T>, ContextSupport {

    private final Flow.Subscriber<? super T> downstream;

    private boolean emitting;

    private boolean missed;

    private volatile boolean done;

    private volatile boolean cancelled;

    private LinkedArrayNode<T> head;

    private LinkedArrayNode<T> tail;

    private Throwable failure;

    private final AtomicReference<Subscription> upstream = new AtomicReference<>();

    public SerializedSubscriber(Flow.Subscriber<? super T> downstream) {
        this.downstream = downstream;
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
    public void onFailure(Throwable t) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onCompletion() {
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

    void serAdd(T value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void serializedDrainLoop(Flow.Subscriber<? super T> actual) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Context context() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Node in a linked array list that is only appended.
     *
     * @param <T> the value type
     */
    static final class LinkedArrayNode<T> {

        static final int DEFAULT_CAPACITY = 16;

        final T[] array;

        int count;

        LinkedArrayNode<T> next;

        @SuppressWarnings("unchecked")
        LinkedArrayNode(T value) {
            array = (T[]) new Object[DEFAULT_CAPACITY];
            array[0] = value;
            count = 1;
        }
    }
}

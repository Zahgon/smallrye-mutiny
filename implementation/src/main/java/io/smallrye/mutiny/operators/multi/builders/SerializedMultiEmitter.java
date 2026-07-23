package io.smallrye.mutiny.operators.multi.builders;

import java.util.Queue;
import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.LongConsumer;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.helpers.queues.Queues;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.MultiEmitter;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * Serializes calls to onItem, onFailure and onCompletion and their Reactive Streams equivalent.
 *
 * @param <T> the type of item
 */
public class SerializedMultiEmitter<T> implements MultiEmitter<T>, MultiSubscriber<T>, ContextSupport {

    private final AtomicInteger wip = new AtomicInteger();

    private final BaseMultiEmitter<T> downstream;

    private final AtomicReference<Throwable> failure = new AtomicReference<>();

    private final Queue<T> queue = Queues.createMpscQueue();

    private volatile boolean done;

    SerializedMultiEmitter(BaseMultiEmitter<T> downstream) {
        this.downstream = downstream;
    }

    @Override
    public void onSubscribe(Flow.Subscription s) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onItem(T item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onFailure(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onCompletion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void drain() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void drainLoop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiEmitter<T> emit(T item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void fail(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void complete() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiEmitter<T> onTermination(Runnable onTermination) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCancelled() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long requested() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiEmitter<T> onRequest(LongConsumer consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiEmitter<T> onCancellation(Runnable onCancellation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Context context() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

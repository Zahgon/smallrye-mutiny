package io.smallrye.mutiny.operators.multi.builders;

import java.nio.BufferOverflowException;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

import io.smallrye.mutiny.subscription.MultiEmitter;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class BufferItemMultiEmitter<T> extends BaseMultiEmitter<T> {

    private final Queue<T> queue;

    private final int overflowBufferSize;

    private Throwable failure;

    private volatile boolean done;

    private final AtomicInteger wip = new AtomicInteger();

    private final AtomicInteger strictBoundCounter = new AtomicInteger();

    BufferItemMultiEmitter(MultiSubscriber<? super T> actual, Queue<T> queue, int overflowBufferSize) {
        super(actual);
        this.queue = queue;
        this.overflowBufferSize = overflowBufferSize;
    }

    @Override
    public MultiEmitter<T> emit(T t) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    protected void cleanup() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void failed(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void completion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void onRequested() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    void onUnsubscribed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void drain() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class EmitterBufferOverflowException extends BufferOverflowException {

        @Override
        public String getMessage() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

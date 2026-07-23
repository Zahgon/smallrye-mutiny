package io.smallrye.mutiny.operators.multi.processors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

/**
 * Wraps a processor into a serialized version of this processor.
 *
 * @param <I> the type of item from upstream
 * @param <O> the type of item propagated to the downstream
 */
public class SerializedProcessor<I, O> implements Processor<I, O> {

    /**
     * The actual subscriber to serialize Subscriber calls to.
     */
    private final Processor<I, O> actual;

    /**
     * Indicates an emission is going on.
     * Access by be guarded by the monitor lock.
     */
    boolean emitting;

    /**
     * If not null, it holds the missed notifications events.
     */
    private List<Object> queue;

    /**
     * Indicates a terminal event has been received and all further events will be dropped.
     */
    volatile boolean done;

    /**
     * Constructor that wraps an actual processor.
     *
     * @param actual the subject wrapped
     */
    public SerializedProcessor(final Processor<I, O> actual) {
        this.actual = actual;
    }

    @Override
    public void subscribe(Subscriber<? super O> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onSubscribe(Subscription s) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private List<Object> getOrCreateQueue() {
        List<Object> q = queue;
        if (q == null) {
            q = new ArrayList<>(4);
            queue = q;
        }
        return q;
    }

    @Override
    public void onNext(I item) {
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

    void emitLoop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public void dispatch(List<Object> queue, Subscriber<I> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private record SubscriptionEvent(Subscription subscription) {
    }

    private record ItemEvent<T>(T item) {
    }

    private record FailureEvent(Throwable failure) {
    }

    private static class CompletionEvent {

        private CompletionEvent() {
            // do nothing.
        }
    }
}

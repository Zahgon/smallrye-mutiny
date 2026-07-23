package io.smallrye.mutiny.helpers;

import java.util.concurrent.Flow.Processor;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.LongConsumer;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.multi.processors.UnicastProcessor;
import io.smallrye.mutiny.subscription.MultiEmitter;

public class MultiEmitterProcessor<T> implements Processor<T, T>, MultiEmitter<T> {

    private final UnicastProcessor<T> processor;

    private final AtomicBoolean terminated = new AtomicBoolean();

    private final AtomicLong requested = new AtomicLong();

    private volatile Runnable onTermination;

    private volatile Runnable onCancellation;

    private volatile LongConsumer onRequest;

    private static final AtomicReferenceFieldUpdater<MultiEmitterProcessor, Runnable> ON_TERMINATION_UPDATER = AtomicReferenceFieldUpdater
            .newUpdater(MultiEmitterProcessor.class, Runnable.class, "onTermination");

    private static final AtomicReferenceFieldUpdater<MultiEmitterProcessor, Runnable> ON_CANCELLATION_UPDATER = AtomicReferenceFieldUpdater
            .newUpdater(MultiEmitterProcessor.class, Runnable.class, "onCancellation");

    private MultiEmitterProcessor() {
        this.processor = UnicastProcessor.create();
    }

    public static <T> MultiEmitterProcessor<T> create() {
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

    @SuppressWarnings("SubscriberImplementation")
    @Override
    public void subscribe(Subscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void fireTermination() {
        if (terminated.compareAndSet(false, true)) {
            Runnable runnable = ON_TERMINATION_UPDATER.getAndSet(this, null);
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onNext(T item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onError(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onComplete() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Multi<T> toMulti() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Context context() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

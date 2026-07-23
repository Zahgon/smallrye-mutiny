package io.smallrye.mutiny.streams.utils;

import java.util.concurrent.atomic.AtomicBoolean;

import org.reactivestreams.Processor;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Processor wrapping a publisher and subscriber, and connect them
 */
public class WrappedProcessor<T> implements Processor<T, T> {

    private final Subscriber<T> subscriber;

    private final Publisher<T> publisher;

    private final AtomicBoolean subscribed = new AtomicBoolean(false);

    public WrappedProcessor(Subscriber<T> subscriber, Publisher<T> publisher) {
        this.subscriber = subscriber;
        this.publisher = publisher;
    }

    @Override
    public void subscribe(Subscriber<? super T> subscriber) {
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

    @Override
    public void onError(Throwable throwable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onComplete() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

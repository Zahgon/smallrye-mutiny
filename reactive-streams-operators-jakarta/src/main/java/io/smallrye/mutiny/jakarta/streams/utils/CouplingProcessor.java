package io.smallrye.mutiny.jakarta.streams.utils;

import java.util.Objects;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

@SuppressWarnings({ "PublisherImplementation", "ReactiveStreamsPublisherImplementation" })
public class CouplingProcessor<I, O> implements Publisher<O> {

    private final SubscriptionObserver<I> controller;

    private final Publisher<O> publisher;

    public CouplingProcessor(Publisher<I> source, Subscriber<I> subscriber, Publisher<O> publisher) {
        Objects.requireNonNull(subscriber);
        controller = new SubscriptionObserver<>(source, subscriber);
        this.publisher = publisher;
        controller.run();
    }

    @Override
    public synchronized void subscribe(Subscriber<? super O> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

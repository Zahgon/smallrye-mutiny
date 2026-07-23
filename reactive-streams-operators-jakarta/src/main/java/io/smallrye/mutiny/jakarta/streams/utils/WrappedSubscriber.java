package io.smallrye.mutiny.jakarta.streams.utils;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicBoolean;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.smallrye.mutiny.helpers.StrictMultiSubscriber;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import mutiny.zero.flow.adapters.AdaptersToFlow;
import mutiny.zero.flow.adapters.AdaptersToReactiveStreams;

/**
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
@SuppressWarnings("SubscriberImplementation")
public class WrappedSubscriber<T> implements Subscriber<T> {

    private final CompletableFuture<Void> future = Infrastructure.wrapCompletableFuture(new CompletableFuture<>());

    private final Subscriber<T> source;

    private final AtomicBoolean subscribed = new AtomicBoolean(false);

    public WrappedSubscriber(Subscriber<T> delegate) {
        this.source = AdaptersToReactiveStreams.subscriber(new StrictMultiSubscriber<>(AdaptersToFlow.subscriber(delegate)));
    }

    public CompletionStage<Void> future() {
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

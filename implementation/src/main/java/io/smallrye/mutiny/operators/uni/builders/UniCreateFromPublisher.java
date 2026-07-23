package io.smallrye.mutiny.operators.uni.builders;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import io.smallrye.mutiny.operators.AbstractUni;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

public class UniCreateFromPublisher<T> extends AbstractUni<T> {

    private final Flow.Publisher<? extends T> publisher;

    public UniCreateFromPublisher(Flow.Publisher<? extends T> publisher) {
        this.publisher = nonNull(publisher, "publisher");
    }

    @Override
    @SuppressWarnings("unchecked")
    public void subscribe(UniSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class PublisherSubscriber<T> implements UniSubscription, Flow.Subscriber<T>, ContextSupport {

        private final UniSubscriber<? super T> subscriber;

        private final Flow.Publisher<? extends T> publisher;

        private volatile Subscription subscription;

        private static final AtomicReferenceFieldUpdater<PublisherSubscriber, Subscription> SUBSCRIPTION_UPDATER = AtomicReferenceFieldUpdater
                .newUpdater(PublisherSubscriber.class, Subscription.class, "subscription");

        private PublisherSubscriber(Flow.Publisher<? extends T> publisher, UniSubscriber<? super T> subscriber) {
            this.subscriber = subscriber;
            this.publisher = publisher;
        }

        private void forward() {
            subscriber.onSubscribe(this);
            Flow.Subscriber<? super T> sub = Infrastructure.onMultiSubscription(publisher, this);
            publisher.subscribe(sub);
        }

        // ---- UniSubscription
        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        // ---- Subscriber
        @Override
        public void onSubscribe(Subscription sub) {
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

        @Override
        public Context context() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

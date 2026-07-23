package io.smallrye.mutiny.operators.uni;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.MultiSubscriber;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

public class UniOnItemTransformToMulti<I, O> extends AbstractMulti<O> {

    private final Function<? super I, ? extends Flow.Publisher<? extends O>> mapper;

    private final Uni<I> upstream;

    public UniOnItemTransformToMulti(Uni<I> upstream, Function<? super I, ? extends Flow.Publisher<? extends O>> mapper) {
        this.upstream = upstream;
        this.mapper = mapper;
    }

    @Override
    public void subscribe(MultiSubscriber<? super O> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("SubscriberImplementation")
    static final class FlatMapPublisherSubscriber<I, O>
            implements Subscriber<O>, UniSubscriber<I>, Flow.Subscription, ContextSupport {

        private final AtomicReference<Flow.Subscription> secondUpstream;

        private final AtomicReference<UniSubscription> firstUpstream;

        private final Subscriber<? super O> downstream;

        private final Function<? super I, ? extends Flow.Publisher<? extends O>> mapper;

        private final AtomicLong requested = new AtomicLong();

        FlatMapPublisherSubscriber(Subscriber<? super O> downstream,
                Function<? super I, ? extends Flow.Publisher<? extends O>> mapper) {
            this.downstream = downstream;
            this.mapper = mapper;
            this.firstUpstream = new AtomicReference<>();
            this.secondUpstream = new AtomicReference<>();
        }

        @Override
        public void onNext(O item) {
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
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Context context() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onSubscribe(UniSubscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(I item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

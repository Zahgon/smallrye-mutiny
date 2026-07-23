package io.smallrye.mutiny.streams.utils;

import java.util.concurrent.atomic.AtomicReference;

import org.reactivestreams.Processor;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.smallrye.mutiny.helpers.Subscriptions;
import mutiny.zero.flow.adapters.AdaptersToFlow;
import mutiny.zero.flow.adapters.AdaptersToReactiveStreams;

/**
 * A processor forwarding to a subscriber. This is used to connect a "next to be" producer.
 */
public class ConnectableProcessor<T> implements Processor<T, T> {

    /**
     * Reference of the subscriber if any.
     * If set the state is HAS_SUBSCRIBER+
     */
    private final AtomicReference<Subscriber<? super T>> subscriber = new AtomicReference<>();

    /**
     * Reference on the subscription if any.
     * If set the state is HAS_SUBSCRIPTION+
     */
    private final AtomicReference<Subscription> subscription = new AtomicReference<>();

    /**
     * Reported failure if any.
     * If set the state if FAILED
     */
    private final AtomicReference<Throwable> failure = new AtomicReference<>();

    /**
     * Current state.
     */
    private final AtomicReference<State> state = new AtomicReference<>(State.IDLE);

    @Override
    public void subscribe(Subscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void manageSubscribeInTheHasSubscriptionState(Subscriber<? super T> subscriber) {
        // We already have a subscription, use it.
        // However, we could complete of failed in the meantime.
        subscriber.onSubscribe(new WrappedSubscription(subscription.get(),
                () -> this.subscriber.set(AdaptersToReactiveStreams.subscriber(new Subscriptions.CancelledSubscriber<>()))));
        if (!state.compareAndSet(State.HAS_SUBSCRIPTION, State.PROCESSING)) {
            if (state.get() == State.FAILED) {
                subscriber.onError(failure.get());
            } else if (state.get() == State.COMPLETE) {
                subscriber.onComplete();
            } else {
                throw new IllegalStateException(
                        "Illegal transition - subscribe called in the " + state.get().name() + " state");
            }
        }
    }

    private void manageSubscribeInCompleteState(Subscriber<? super T> subscriber) {
        Subscriptions.complete(AdaptersToFlow.subscriber(subscriber));
    }

    private void manageSubscribeInFailedState(Subscriber<? super T> subscriber) {
        Subscriptions.fail(AdaptersToFlow.subscriber(subscriber), failure.get());
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
    public synchronized void onComplete() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public synchronized void onError(Throwable throwable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private enum State {

        // Start state
        IDLE,
        // When we get a subscriber
        HAS_SUBSCRIBER,
        // When we get a subscription
        HAS_SUBSCRIPTION,
        // Processing started
        PROCESSING,
        // Caught an error, final state
        FAILED,
        // Completed, final state
        COMPLETE
    }
}

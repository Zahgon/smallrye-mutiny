package io.smallrye.mutiny.subscription;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicBoolean;

import io.smallrye.mutiny.CompositeException;
import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.helpers.Subscriptions;
import io.smallrye.mutiny.infrastructure.Infrastructure;

/**
 * Wraps another Subscriber and ensures all onXXX methods conform the protocol
 * (except the requirement for serialized access).
 *
 * @param <T> the value type
 */
public final class SafeSubscriber<T> implements Subscriber<T>, Subscription, ContextSupport {

    /**
     * The actual Subscriber.
     */
    private final Subscriber<? super T> downstream;

    /**
     * The subscription.
     */
    private Subscription upstream;

    /**
     * Flag to check if we have already subscribed.
     */
    private final AtomicBoolean subscribed = new AtomicBoolean(false);

    /**
     * Indicates a terminal state.
     */
    private boolean done;

    /**
     * Constructs a SafeSubscriber by wrapping the given actual Subscriber.
     *
     * @param downstream the actual Subscriber to wrap, not null (not validated)
     */
    public SafeSubscriber(Subscriber<? super T> downstream) {
        this.downstream = downstream;
    }

    boolean isDone() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onNext(T t) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void cancelAndDispatch(Throwable ex) {
        try {
            upstream.cancel();
        } catch (Throwable e1) {
            onError(new CompositeException(ex, e1));
            return;
        }
        onError(ex);
    }

    private void onNextNoSubscription() {
        done = true;
        manageViolationProtocol();
    }

    @Override
    public void onError(Throwable t) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onComplete() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void onCompleteNoSubscription() {
        manageViolationProtocol();
    }

    private void manageViolationProtocol() {
        Throwable ex = new NullPointerException("Subscription not set!");
        try {
            downstream.onSubscribe(Subscriptions.empty());
        } catch (Throwable e) {
            // can't call onError because the actual's state may be corrupt at this point
            Infrastructure.handleDroppedException(new CompositeException(ex, e));
            return;
        }
        try {
            downstream.onError(ex);
        } catch (Throwable e) {
            // nothing we can do.
            Infrastructure.handleDroppedException(new CompositeException(ex, e));
        }
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
}

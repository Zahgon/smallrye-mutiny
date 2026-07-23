package io.smallrye.mutiny.helpers;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * Ensures that the events between the upstream and downstream follow
 * the Reactive Streams specification. Typically:
 * <ul>
 * <li>1.3: onNext should not be called concurrently until onSubscribe returns</li>
 * <li>2.3: onError or onComplete must not call cancel</li>
 * <li>3.9: negative requests should emit an onError(IllegalArgumentException)</li>
 * <li>2.12: onSubscribe must be called at most once (subscription cancelled and onError called)</li>
 * </ul>
 *
 * @param <T> the type of item
 */
public class StrictMultiSubscriber<T> implements MultiSubscriber<T>, Subscription, ContextSupport {

    private final AtomicInteger wip = new AtomicInteger();

    private final Subscriber<? super T> downstream;

    private final AtomicReference<Throwable> failure;

    private final AtomicLong requested;

    private final AtomicReference<Subscription> upstream;

    private final AtomicBoolean once;

    volatile boolean done;

    public StrictMultiSubscriber(Subscriber<? super T> downstream) {
        this.downstream = downstream;
        this.failure = new AtomicReference<>();
        this.requested = new AtomicLong();
        this.upstream = new AtomicReference<>();
        this.once = new AtomicBoolean();
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
    public void onSubscribe(Subscription s) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onItem(T t) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onFailure(Throwable t) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onCompletion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Context context() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

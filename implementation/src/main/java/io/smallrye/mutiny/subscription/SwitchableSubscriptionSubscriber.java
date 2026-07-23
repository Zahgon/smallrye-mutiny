package io.smallrye.mutiny.subscription;

import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

import io.smallrye.mutiny.Context;

/**
 * An implementation of {@link Subscription} that allows switching the upstream, dealing with the requests accordingly.
 * <p>
 * You must invoke {@link #emitted(long)} after delivered items to manage the request per
 * subscription consistently.
 *
 * @param <O> outgoing item type
 */
public abstract class SwitchableSubscriptionSubscriber<O> implements MultiSubscriber<O>, Subscription, ContextSupport {

    /**
     * The downstream subscriber
     */
    protected final MultiSubscriber<? super O> downstream;

    /**
     * The current upstream
     */
    protected final AtomicReference<Subscription> currentUpstream = new AtomicReference<>();

    /**
     * Outstanding request amount.
     * Package-private for testing purpose.
     */
    long requested;

    /**
     * {@code true} if request is Long.MAX_VALUE.
     * Package-private for testing purpose.
     */
    boolean unbounded;

    /**
     * Pending subscription.
     */
    final AtomicReference<Subscription> pendingSubscription = new AtomicReference<>();

    /**
     * Pending amount of request.
     */
    final AtomicLong missedRequested = new AtomicLong();

    /**
     * Pending amount of emitted items.
     */
    final AtomicLong missedItems = new AtomicLong();

    /**
     * Whether or not there is work in progress.
     * Package-private for testing purpose.
     */
    final AtomicInteger wip = new AtomicInteger();

    /**
     * Whether or not the downstream cancelled the subscription.
     */
    private final AtomicBoolean cancelled = new AtomicBoolean();

    public SwitchableSubscriptionSubscriber(MultiSubscriber<? super O> downstream) {
        this.downstream = downstream;
    }

    @Override
    public Context context() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void cancel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isCancelled() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onCompletion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onFailure(Throwable t) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onSubscribe(Subscription s) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void emitted(long n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long requested() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final void request(long n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final void setOrSwitchUpstream(Subscription newUpstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean cancelUpstreamOnSwitch() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void drain() {
        if (wip.getAndIncrement() != 0) {
            return;
        }
        drainLoop();
    }

    void drainLoop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

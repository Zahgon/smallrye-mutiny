package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public abstract class MultiOperatorProcessor<I, O> implements MultiSubscriber<I>, Subscription, ContextSupport {

    /*
     * We used to have an interpretation of the RS TCK that it had to be null on cancellation to release the subscriber.
     * It's actually not necessary (and NPE-prone) since operators are instantiated per-subscription, so the *publisher*
     * does not actually keep references on cancelled subscribers.
     */
    protected volatile MultiSubscriber<? super O> downstream;

    protected volatile Subscription upstream = null;

    private volatile int cancellationRequested = 0;

    private static final AtomicReferenceFieldUpdater<MultiOperatorProcessor, Subscription> UPSTREAM_UPDATER = AtomicReferenceFieldUpdater
            .newUpdater(MultiOperatorProcessor.class, Subscription.class, "upstream");

    private static final AtomicIntegerFieldUpdater<MultiOperatorProcessor> CANCELLATION_REQUESTED_UPDATER = AtomicIntegerFieldUpdater
            .newUpdater(MultiOperatorProcessor.class, "cancellationRequested");

    public MultiOperatorProcessor(MultiSubscriber<? super O> downstream) {
        this.downstream = ParameterValidation.nonNull(downstream, "downstream");
    }

    void failAndCancel(Throwable throwable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected Subscription getUpstreamSubscription() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean compareAndSetUpstreamSubscription(Subscription expectedValue, Subscription newValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected Subscription getAndSetUpstreamSubscription(Subscription newValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean isDone() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean isCancelled() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Context context() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onSubscribe(Subscription subscription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onFailure(Throwable throwable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onItem(I item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onCompletion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void request(long numberOfItems) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void cancel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final boolean compareAndSwapDownstreamCancellationRequest() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void cancelUpstream() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

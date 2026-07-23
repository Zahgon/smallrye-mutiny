package io.smallrye.mutiny.operators.uni;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

public abstract class UniOperatorProcessor<I, O> implements UniSubscriber<I>, UniSubscription {

    protected final UniSubscriber<? super O> downstream;

    private static final AtomicReferenceFieldUpdater<UniOperatorProcessor, UniSubscription> updater = AtomicReferenceFieldUpdater
            .newUpdater(UniOperatorProcessor.class, UniSubscription.class, "upstream");

    private volatile UniSubscription upstream;

    public UniOperatorProcessor(final UniSubscriber<? super O> downstream) {
        ParameterValidation.nonNull(downstream, "downstream");
        this.downstream = downstream;
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
    @SuppressWarnings("unchecked")
    public void onItem(I item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onFailure(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void cancel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isCancelled() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final UniSubscription getCurrentUpstreamSubscription() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final UniSubscription getAndSetUpstreamSubscription(UniSubscription newValue) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected final boolean compareAndSetUpstreamSubscription(UniSubscription expect, UniSubscription update) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

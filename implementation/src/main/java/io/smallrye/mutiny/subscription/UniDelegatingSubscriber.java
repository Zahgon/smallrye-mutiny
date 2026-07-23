package io.smallrye.mutiny.subscription;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import io.smallrye.mutiny.Context;

public class UniDelegatingSubscriber<I, O> implements UniSubscriber<I> {

    private final UniSubscriber<? super O> delegate;

    public UniDelegatingSubscriber(UniSubscriber<? super O> subscriber) {
        this.delegate = nonNull(subscriber, "delegate");
    }

    @Override
    public Context context() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onSubscribe(UniSubscription subscription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onItem(I item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onFailure(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

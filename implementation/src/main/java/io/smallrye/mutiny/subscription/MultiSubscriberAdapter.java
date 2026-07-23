package io.smallrye.mutiny.subscription;

import java.util.concurrent.Flow;

import io.smallrye.mutiny.Context;

/**
 * Thin adapter of a {@link Flow.Subscriber} to a Mutiny {@link MultiSubscriber}.
 *
 * @param <T> the elements type
 */
public class MultiSubscriberAdapter<T> implements MultiSubscriber<T>, ContextSupport {

    private final Flow.Subscriber<? super T> downstream;

    public MultiSubscriberAdapter(Flow.Subscriber<? super T> downstream) {
        this.downstream = downstream;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onItem(T item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onFailure(Throwable failure) {
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

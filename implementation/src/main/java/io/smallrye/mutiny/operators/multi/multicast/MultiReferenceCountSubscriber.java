package io.smallrye.mutiny.operators.multi.multicast;

import java.util.concurrent.atomic.AtomicBoolean;

import io.smallrye.mutiny.operators.multi.MultiOperatorProcessor;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiReferenceCountSubscriber<T> extends MultiOperatorProcessor<T, T> {

    private final AtomicBoolean done = new AtomicBoolean();

    private final MultiReferenceCount<T> parent;

    private final ConnectableMultiConnection connection;

    MultiReferenceCountSubscriber(MultiSubscriber<? super T> downstream, MultiReferenceCount<T> parent,
            ConnectableMultiConnection connection) {
        super(downstream);
        this.parent = parent;
        this.connection = connection;
    }

    @Override
    public void onItem(T t) {
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
    public void cancel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

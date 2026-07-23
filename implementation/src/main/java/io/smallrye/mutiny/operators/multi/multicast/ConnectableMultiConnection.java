package io.smallrye.mutiny.operators.multi.multicast;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

import io.smallrye.mutiny.subscription.Cancellable;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class ConnectableMultiConnection implements Runnable, Consumer<Cancellable> {

    private static final Cancellable CANCELLED = () -> {
        // do nothing.
    };

    private final MultiReferenceCount<?> parent;

    private final MultiSubscriber<?> subscriber;

    private final AtomicReference<Cancellable> onCancellation = new AtomicReference<>();

    private Cancellable timer;

    private long subscriberCount;

    private boolean connected;

    ConnectableMultiConnection(MultiReferenceCount<?> parent, MultiSubscriber<?> subscriber) {
        this.parent = parent;
        this.subscriber = subscriber;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void accept(Cancellable action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public synchronized boolean shouldConnectAfterIncrement(int toBeReached) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getSubscriberCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isConnected() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void cancelTimerIf0() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void cancel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    synchronized boolean decrementAndReached0() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    synchronized long decrement() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    synchronized void setTimer(Cancellable cancellable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MultiSubscriber<?> getSubscriber() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package io.smallrye.mutiny.operators.multi.multicast;

import java.time.Duration;
import java.util.concurrent.ScheduledExecutorService;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * A {@link Multi} stays connected to the source as long as there is at least one subscription.
 *
 * @param <T> the type of item
 */
public class MultiReferenceCount<T> extends AbstractMulti<T> implements Multi<T> {

    private final ConnectableMulti<T> upstream;

    private final int numberOfSubscribers;

    private final Duration duration;

    private final ScheduledExecutorService executor;

    private ConnectableMultiConnection connection;

    public MultiReferenceCount(ConnectableMulti<T> upstream) {
        this(upstream, 1, null);
    }

    public MultiReferenceCount(ConnectableMulti<T> upstream, int numberOfSubscribers, Duration duration) {
        this.upstream = upstream;
        this.numberOfSubscribers = numberOfSubscribers;
        this.duration = duration;
        this.executor = Infrastructure.getDefaultWorkerPool();
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void cancel(ConnectableMultiConnection connection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void terminated(ConnectableMultiConnection connection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void timeout(ConnectableMultiConnection connection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

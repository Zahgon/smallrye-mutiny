package io.smallrye.mutiny.operators.multi.multicast;

import java.time.Duration;
import java.util.concurrent.Flow;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.AbstractMulti;

/**
 * A {@code ConnectableMulti} is similar to a regular {@link Multi}, except that it does not begin
 * emitting items (from upstream to downstream) when it is subscribed to, but only when its {@link #connect} method is
 * called. This allows deferring the dispatching of events. For example, it can wait until a set number of subscribers
 * have subscribed.
 *
 * @param <T> the type of item
 */
public abstract class ConnectableMulti<T> extends AbstractMulti<T> {

    protected final Multi<T> upstream;

    protected ConnectableMulti(Multi<T> upstream) {
        this.upstream = upstream;
    }

    /**
     * Allows this {@link ConnectableMulti} to start emitting the items from its upstream {@link Multi} to
     * its {@link Flow.Subscriber}s.
     *
     * @param connection the connection.
     */
    protected abstract void connect(ConnectableMultiConnection connection);

    public Multi<T> referenceCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Multi<T> referenceCount(int count, Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Multi<T> connectAfter(int numberOfSubscribers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

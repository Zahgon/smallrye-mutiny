package io.smallrye.mutiny.groups;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.BackPressureStrategy;
import io.smallrye.mutiny.subscription.DemandPauser;

/**
 * Configures a pausable {@link Multi} stream.
 * <p>
 * This class allows configuring how a stream behaves when paused, including:
 * <ul>
 * <li>Initial pause state</li>
 * <li>Late subscription (delaying upstream subscription until resumed)</li>
 * <li>Buffer strategy (BUFFER, DROP, or IGNORE)</li>
 * <li>Buffer size limits</li>
 * </ul>
 *
 * @param <T> the type of items emitted by the stream
 */
public class MultiDemandPausing<T> {

    private final AbstractMulti<T> upstream;

    private boolean paused = false;

    private boolean lateSubscription = false;

    private int bufferSize = Infrastructure.getMultiOverflowDefaultBufferSize();

    private boolean unbounded = false;

    private BackPressureStrategy bufferStrategy = BackPressureStrategy.BUFFER;

    public MultiDemandPausing(AbstractMulti<T> upstream) {
        this.upstream = upstream;
    }

    @CheckReturnValue
    public MultiDemandPausing<T> paused(boolean paused) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiDemandPausing<T> lateSubscription(boolean lateSubscription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiDemandPausing<T> bufferSize(int bufferSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiDemandPausing<T> bufferUnconditionally() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiDemandPausing<T> bufferStrategy(BackPressureStrategy bufferStrategy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> using(DemandPauser pauser) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

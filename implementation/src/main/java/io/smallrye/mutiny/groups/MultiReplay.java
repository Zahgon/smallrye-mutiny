package io.smallrye.mutiny.groups;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;

/**
 * Group to configure replaying a {@link Multi} to multiple subscribers.
 */
public class MultiReplay {

    private long numberOfItemsToReplay = Long.MAX_VALUE;

    @CheckReturnValue
    public MultiReplay upTo(long numberOfItemsToReplay) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> ofMulti(Multi<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> ofSeedAndMulti(Iterable<T> seed, Multi<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

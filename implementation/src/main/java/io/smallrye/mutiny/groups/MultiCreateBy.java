package io.smallrye.mutiny.groups;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;

/**
 * Allows the creation of instances of {@link Multi} by merging/combining/concatenating multiple upstreams.
 */
public class MultiCreateBy {

    public static final MultiCreateBy INSTANCE = new MultiCreateBy();

    private MultiCreateBy() {
        // Avoid direct instantiation
    }

    @CheckReturnValue
    public MultiConcat concatenating() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiMerge merging() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiItemCombination combining() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiRepetition repeating() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiReplay replaying() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

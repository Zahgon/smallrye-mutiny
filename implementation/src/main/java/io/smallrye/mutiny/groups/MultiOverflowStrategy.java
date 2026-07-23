package io.smallrye.mutiny.groups;

import java.util.function.Consumer;
import java.util.function.Function;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class MultiOverflowStrategy<T> {

    private final Multi<T> upstream;

    private final Consumer<T> dropConsumer;

    private final Function<T, Uni<?>> dropUniMapper;

    public MultiOverflowStrategy(Multi<T> upstream, Consumer<T> dropConsumer, Function<T, Uni<?>> dropUniMapper) {
        // No need for null checks since MultiOverflow must have performed them
        this.upstream = upstream;
        this.dropConsumer = dropConsumer;
        this.dropUniMapper = dropUniMapper;
    }

    @CheckReturnValue
    public Multi<T> drop() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> buffer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> buffer(int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> bufferUnconditionally() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> dropPreviousItems() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

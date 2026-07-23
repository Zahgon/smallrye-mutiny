package io.smallrye.mutiny.groups;

import java.util.List;
import java.util.concurrent.Flow.Publisher;
import java.util.function.Function;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;

public class MultiItemCombineIterable {

    private boolean collectFailures;

    private boolean latest;

    private final Iterable<? extends Publisher<?>> iterable;

    public MultiItemCombineIterable(Iterable<? extends Publisher<?>> iterable) {
        this.iterable = iterable;
    }

    @CheckReturnValue
    public MultiItemCombineIterable collectFailures() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiItemCombineIterable latestItems() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <O> Multi<O> using(Function<List<?>, O> combinator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    <O> Multi<O> combine(Function<List<?>, ? extends O> combinator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

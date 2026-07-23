package io.smallrye.mutiny.groups;

import java.util.concurrent.Flow;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.tuples.Functions;
import io.smallrye.mutiny.tuples.Tuple3;

public class MultiItemCombine3<T1, T2, T3> extends MultiItemCombineIterable {

    public MultiItemCombine3(Iterable<Flow.Publisher<?>> iterable) {
        super(iterable);
    }

    @Override
    @CheckReturnValue
    public MultiItemCombine3<T1, T2, T3> collectFailures() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @CheckReturnValue
    public MultiItemCombine3<T1, T2, T3> latestItems() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<Tuple3<T1, T2, T3>> asTuple() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @CheckReturnValue
    public <O> Multi<O> using(Functions.Function3<T1, T2, T3, O> combinator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

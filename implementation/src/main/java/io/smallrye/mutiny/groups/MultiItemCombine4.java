package io.smallrye.mutiny.groups;

import java.util.concurrent.Flow.Publisher;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.tuples.Functions;
import io.smallrye.mutiny.tuples.Tuple4;

public class MultiItemCombine4<T1, T2, T3, T4> extends MultiItemCombineIterable {

    public MultiItemCombine4(Iterable<Publisher<?>> iterable) {
        super(iterable);
    }

    @Override
    @CheckReturnValue
    public MultiItemCombine4<T1, T2, T3, T4> collectFailures() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @CheckReturnValue
    public MultiItemCombine4<T1, T2, T3, T4> latestItems() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<Tuple4<T1, T2, T3, T4>> asTuple() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @CheckReturnValue
    public <O> Multi<O> using(Functions.Function4<T1, T2, T3, T4, O> combinator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package io.smallrye.mutiny.groups;

import java.util.concurrent.Flow.Publisher;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.tuples.Functions;
import io.smallrye.mutiny.tuples.Tuple8;

public class MultiItemCombine8<T1, T2, T3, T4, T5, T6, T7, T8> extends MultiItemCombineIterable {

    public MultiItemCombine8(Iterable<Publisher<?>> iterable) {
        super(iterable);
    }

    @Override
    @CheckReturnValue
    public MultiItemCombine8<T1, T2, T3, T4, T5, T6, T7, T8> collectFailures() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @CheckReturnValue
    public MultiItemCombine8<T1, T2, T3, T4, T5, T6, T7, T8> latestItems() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asTuple() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @CheckReturnValue
    public <O> Multi<O> using(Functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, O> combinator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

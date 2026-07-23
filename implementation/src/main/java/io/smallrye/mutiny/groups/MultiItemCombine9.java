package io.smallrye.mutiny.groups;

import java.util.concurrent.Flow.Publisher;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.tuples.Functions;
import io.smallrye.mutiny.tuples.Tuple9;

public class MultiItemCombine9<T1, T2, T3, T4, T5, T6, T7, T8, T9> extends MultiItemCombineIterable {

    public MultiItemCombine9(Iterable<Publisher<?>> iterable) {
        super(iterable);
    }

    @Override
    @CheckReturnValue
    public MultiItemCombine9<T1, T2, T3, T4, T5, T6, T7, T8, T9> collectFailures() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @CheckReturnValue
    public MultiItemCombine9<T1, T2, T3, T4, T5, T6, T7, T8, T9> latestItems() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> asTuple() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @CheckReturnValue
    public <O> Multi<O> using(Functions.Function9<T1, T2, T3, T4, T5, T6, T7, T8, T9, O> combinator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

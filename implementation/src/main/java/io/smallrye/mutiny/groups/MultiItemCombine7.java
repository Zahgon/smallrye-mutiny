package io.smallrye.mutiny.groups;

import java.util.concurrent.Flow.Publisher;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.tuples.Functions;
import io.smallrye.mutiny.tuples.Tuple7;

public class MultiItemCombine7<T1, T2, T3, T4, T5, T6, T7> extends MultiItemCombineIterable {

    public MultiItemCombine7(Iterable<Publisher<?>> iterable) {
        super(iterable);
    }

    @Override
    @CheckReturnValue
    public MultiItemCombine7<T1, T2, T3, T4, T5, T6, T7> collectFailures() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @CheckReturnValue
    public MultiItemCombine7<T1, T2, T3, T4, T5, T6, T7> latestItems() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<Tuple7<T1, T2, T3, T4, T5, T6, T7>> asTuple() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @CheckReturnValue
    public <O> Multi<O> using(Functions.Function7<T1, T2, T3, T4, T5, T6, T7, O> combinator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

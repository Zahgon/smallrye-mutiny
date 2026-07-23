package io.smallrye.mutiny.groups;

import java.util.concurrent.Flow.Publisher;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.tuples.Functions;
import io.smallrye.mutiny.tuples.Tuple6;

public class MultiItemCombine6<T1, T2, T3, T4, T5, T6> extends MultiItemCombineIterable {

    public MultiItemCombine6(Iterable<Publisher<?>> iterable) {
        super(iterable);
    }

    @Override
    @CheckReturnValue
    public MultiItemCombine6<T1, T2, T3, T4, T5, T6> collectFailures() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @CheckReturnValue
    public MultiItemCombine6<T1, T2, T3, T4, T5, T6> latestItems() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<Tuple6<T1, T2, T3, T4, T5, T6>> asTuple() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @CheckReturnValue
    public <O> Multi<O> using(Functions.Function6<T1, T2, T3, T4, T5, T6, O> combinator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

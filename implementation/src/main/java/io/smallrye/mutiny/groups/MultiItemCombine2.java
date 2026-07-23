package io.smallrye.mutiny.groups;

import java.util.concurrent.Flow.Publisher;
import java.util.function.BiFunction;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.tuples.Tuple2;

public class MultiItemCombine2<T1, T2> extends MultiItemCombineIterable {

    public MultiItemCombine2(Iterable<Publisher<?>> iterable) {
        super(iterable);
    }

    @Override
    public MultiItemCombine2<T1, T2> collectFailures() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @CheckReturnValue
    public MultiItemCombine2<T1, T2> latestItems() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<Tuple2<T1, T2>> asTuple() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @CheckReturnValue
    public <O> Multi<O> using(BiFunction<T1, T2, O> combinator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

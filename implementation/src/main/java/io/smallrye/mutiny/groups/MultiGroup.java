package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.function.Function;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.GroupedMulti;
import io.smallrye.mutiny.Multi;

public class MultiGroup<T> {

    private final Multi<T> upstream;

    public MultiGroup(Multi<T> upstream) {
        this.upstream = nonNull(upstream, "upstream");
    }

    @CheckReturnValue
    public MultiGroupIntoLists<T> intoLists() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiGroupIntoMultis<T> intoMultis() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // TODO grouping can also have prefetch and failure collection delay.
    @CheckReturnValue
    public <K> Multi<GroupedMulti<K, T>> by(Function<? super T, ? extends K> keyMapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <K, V> Multi<GroupedMulti<K, V>> by(Function<? super T, ? extends K> keyMapper,
            Function<? super T, ? extends V> valueMapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <K> Multi<GroupedMulti<K, T>> by(Function<? super T, ? extends K> keyMapper, long prefetch) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <K, V> Multi<GroupedMulti<K, V>> by(Function<? super T, ? extends K> keyMapper,
            Function<? super T, ? extends V> valueMapper, long prefetch) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

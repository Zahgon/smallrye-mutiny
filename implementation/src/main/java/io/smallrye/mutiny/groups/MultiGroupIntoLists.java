package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.*;

import java.time.Duration;
import java.util.List;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;

public class MultiGroupIntoLists<T> {

    private final Multi<T> upstream;

    public MultiGroupIntoLists(Multi<T> upstream) {
        this.upstream = nonNull(upstream, "upstream");
    }

    @CheckReturnValue
    public Multi<List<T>> every(Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<List<T>> every(Duration duration, boolean emitEmptyListIfNoItems) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<List<T>> of(int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<List<T>> of(int size, int skip) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<List<T>> of(int size, Duration maximumDelay) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

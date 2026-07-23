package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.time.Duration;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;

public class MultiGroupIntoMultis<T> {

    private final Multi<T> upstream;

    public MultiGroupIntoMultis(Multi<T> upstream) {
        this.upstream = nonNull(upstream, "upstream");
    }

    @CheckReturnValue
    public Multi<Multi<T>> every(Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<Multi<T>> of(int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<Multi<T>> of(int size, int skip) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

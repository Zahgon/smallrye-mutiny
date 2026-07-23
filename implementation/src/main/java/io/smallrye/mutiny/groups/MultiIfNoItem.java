package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.time.Duration;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;

public class MultiIfNoItem<T> {

    private final Multi<T> upstream;

    public MultiIfNoItem(Multi<T> upstream) {
        this.upstream = nonNull(upstream, "upstream");
    }

    @CheckReturnValue
    public MultiOnItemTimeout<T> after(Duration timeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

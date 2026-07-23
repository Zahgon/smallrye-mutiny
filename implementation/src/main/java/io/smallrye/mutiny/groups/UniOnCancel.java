package io.smallrye.mutiny.groups;

import java.util.function.Supplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.ParameterValidation;

public class UniOnCancel<T> {

    private final Uni<T> upstream;

    public UniOnCancel(Uni<T> upstream) {
        this.upstream = ParameterValidation.nonNull(upstream, "upstream");
    }

    @CheckReturnValue
    public Uni<T> invoke(Runnable action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> call(Supplier<Uni<?>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

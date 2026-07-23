package io.smallrye.mutiny.groups;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.ParameterValidation;

public class MultiOnTerminate<T> {

    private final Multi<T> upstream;

    public MultiOnTerminate(Multi<T> upstream) {
        this.upstream = ParameterValidation.nonNull(upstream, "upstream");
    }

    @CheckReturnValue
    public Multi<T> invoke(BiConsumer<Throwable, Boolean> callback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> invoke(Runnable action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> call(BiFunction<Throwable, Boolean, Uni<?>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> call(Supplier<Uni<?>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

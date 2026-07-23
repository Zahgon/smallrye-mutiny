package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.UniEmitter;
import io.smallrye.mutiny.tuples.Functions;

public class UniOnItemOrFailure<T> {

    private final Uni<T> upstream;

    public UniOnItemOrFailure(Uni<T> upstream) {
        this.upstream = nonNull(upstream, "upstream");
    }

    @CheckReturnValue
    public Uni<T> invoke(BiConsumer<? super T, Throwable> callback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> invoke(Runnable callback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> call(BiFunction<? super T, Throwable, Uni<?>> callback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> call(Supplier<Uni<?>> callback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <R> Uni<R> transform(BiFunction<? super T, Throwable, ? extends R> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <R> Uni<R> transformToUni(BiFunction<? super T, Throwable, Uni<? extends R>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <R> Uni<R> transformToUni(Functions.TriConsumer<? super T, Throwable, UniEmitter<? super R>> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

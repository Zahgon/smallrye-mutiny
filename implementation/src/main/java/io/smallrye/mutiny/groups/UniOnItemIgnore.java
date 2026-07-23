package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.function.Supplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Uni;

public class UniOnItemIgnore<T> {

    private final UniOnItem<T> onItem;

    public UniOnItemIgnore(UniOnItem<T> onItem) {
        this.onItem = nonNull(onItem, "onItem");
    }

    @CheckReturnValue
    public Uni<T> andFail(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> andFail(Supplier<Throwable> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> andFail() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <O> Uni<O> andSwitchTo(Uni<? extends O> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <O> Uni<O> andSwitchTo(Supplier<Uni<? extends O>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> andContinueWith(T fallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<Void> andContinueWithNull() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> andContinueWith(Supplier<? extends T> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

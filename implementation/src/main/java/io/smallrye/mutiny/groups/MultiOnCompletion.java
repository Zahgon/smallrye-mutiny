package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.concurrent.Flow.Publisher;
import java.util.function.Consumer;
import java.util.function.Supplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.MultiEmitter;

public class MultiOnCompletion<T> {

    private final Multi<T> upstream;

    public MultiOnCompletion(Multi<T> upstream) {
        this.upstream = nonNull(upstream, "upstream");
    }

    @CheckReturnValue
    public Multi<T> invoke(Runnable action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> call(Supplier<Uni<?>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> failWith(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> failWith(Supplier<Throwable> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> fail() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> switchToEmitter(Consumer<MultiEmitter<? super T>> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> switchTo(Publisher<? extends T> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> switchTo(Supplier<Publisher<? extends T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SafeVarargs
    @CheckReturnValue
    public final Multi<T> continueWith(T... items) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> continueWith(Iterable<T> items) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> continueWith(Supplier<? extends Iterable<? extends T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiIfEmpty<T> ifEmpty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

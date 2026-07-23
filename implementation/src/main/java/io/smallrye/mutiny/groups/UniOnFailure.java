package io.smallrye.mutiny.groups;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Uni;

/**
 * Configures the failure handler.
 * <p>
 * The upstream uni has sent us a failure, this class lets you decide what need to be done in this case. Typically,
 * you can recover with a fallback item ({@link #recoverWithItem(Object)}), or with another Uni
 * ({@link #recoverWithUni(Uni)}). You can also retry ({@link #retry()}). Maybe, you just want to look at the failure
 * ({@link #invoke(Consumer)}).
 * <p>
 * You can configure the type of failure on which your handler is called using:
 *
 * <pre>
 * {@code
 * uni.onFailure(IOException.class).recoverWithItem("boom")
 * uni.onFailure(IllegalStateException.class).recoverWithItem("kaboom")
 * uni.onFailure(t -> accept(t)).recoverWithItem("another boom")
 * }
 * </pre>
 *
 * @param <T> the type of item
 * @param <E> the type of failure
 */
public class UniOnFailure<T, E extends Throwable> {

    private final Uni<T> upstream;

    private final Class<E> typeOfFailure;

    private final Predicate<? super Throwable> predicate;

    public UniOnFailure(Uni<T> upstream, Class<E> typeOfFailure, Predicate<? super Throwable> predicate) {
        this.upstream = upstream;
        this.predicate = predicate == null ? x -> true : predicate;
        this.typeOfFailure = typeOfFailure;
    }

    @CheckReturnValue
    public Uni<T> invoke(Consumer<E> callback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> invoke(Runnable callback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> call(Function<E, Uni<?>> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> call(Supplier<Uni<?>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> transform(Function<E, ? extends Throwable> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> recoverWithItem(T fallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> recoverWithItem(Supplier<T> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> recoverWithItem(Function<E, ? extends T> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> recoverWithUni(Function<E, Uni<? extends T>> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> recoverWithUni(Supplier<Uni<? extends T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> recoverWithUni(Uni<? extends T> fallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public UniRetry<T> retry() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> recoverWithNull() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

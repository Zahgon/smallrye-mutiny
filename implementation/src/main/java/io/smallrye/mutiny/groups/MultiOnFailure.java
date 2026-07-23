package io.smallrye.mutiny.groups;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

/**
 * Configures the failure handler.
 * <p>
 * The upstream multi has sent us a failure, this class lets you decide what need to be done in this case. Typically,
 * you can recover with a fallback item ({@link #recoverWithItem(Object)}), or with another Multi
 * ({@link #recoverWithMulti(Multi)}), or simply completes the stream ({@link #recoverWithCompletion()}). You can also
 * retry ({@link #retry()}). Maybe, you just want to look at the failure ({@link #invoke(Consumer)}).
 * <p>
 * You can configure the type of failure on which your handler is called using:
 *
 * <pre>
 * {@code
 * multi.onFailure(IOException.class).recoverWithItem("boom")
 * multi.onFailure(IllegalStateException.class).recoverWithItem("kaboom")
 * multi.onFailure(NoMoreDataException.class).recoverWithCompletion()
 * multi.onFailure(t -> accept(t)).recoverWithItem("another boom")
 * }
 * </pre>
 *
 * @param <T> the type of item
 */
public class MultiOnFailure<T> {

    private final Multi<T> upstream;

    private final Predicate<? super Throwable> predicate;

    public MultiOnFailure(Multi<T> upstream, Predicate<? super Throwable> predicate) {
        this.upstream = upstream;
        this.predicate = predicate == null ? x -> true : predicate;
    }

    @CheckReturnValue
    public Multi<T> invoke(Consumer<Throwable> callback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> invoke(Runnable callback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> call(Function<Throwable, Uni<?>> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> call(Supplier<Uni<?>> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> transform(Function<? super Throwable, ? extends Throwable> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> recoverWithItem(T fallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> recoverWithItem(Supplier<T> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> recoverWithItem(Function<? super Throwable, ? extends T> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> recoverWithCompletion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> recoverWithMulti(Function<? super Throwable, Multi<? extends T>> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> recoverWithMulti(Supplier<Multi<? extends T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> recoverWithMulti(Multi<? extends T> fallback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiRetry<T> retry() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

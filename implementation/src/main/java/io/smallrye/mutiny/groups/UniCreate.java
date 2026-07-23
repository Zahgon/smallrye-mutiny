package io.smallrye.mutiny.groups;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Future;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.converters.UniConverter;
import io.smallrye.mutiny.operators.uni.builders.*;
import io.smallrye.mutiny.subscription.UniEmitter;

/**
 * Group methods allowing to create {@link Uni} instances from various sources.
 */
public class UniCreate {

    public static final UniCreate INSTANCE = new UniCreate();

    @SuppressWarnings("rawtypes")
    private static final Uni UNI_OF_NULL = Uni.createFrom().item((Object) null);

    private UniCreate() {
        // avoid direct instantiation.
    }

    @CheckReturnValue
    public <I, T> Uni<T> converter(UniConverter<I, T> converter, I instance) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Uni<T> completionStage(CompletionStage<? extends T> stage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T, S> Uni<T> completionStage(Supplier<S> stateSupplier,
            Function<S, ? extends CompletionStage<? extends T>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Uni<T> completionStage(Supplier<? extends CompletionStage<? extends T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Uni<T> future(Future<? extends T> future) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Uni<T> future(Supplier<Future<? extends T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Uni<T> future(Future<? extends T> future, Duration timeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Uni<T> future(Supplier<Future<? extends T>> supplier, Duration timeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Uni<T> publisher(Publisher<? extends T> publisher) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Uni<T> item(Supplier<? extends T> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T, S> Uni<T> item(Supplier<S> stateSupplier, Function<S, ? extends T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Uni<T> item(T item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<Void> voidItem() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @CheckReturnValue
    public <T> Uni<T> nullItem() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    @CheckReturnValue
    public <T> Uni<T> optional(Optional<T> optional) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Uni<T> optional(Supplier<Optional<T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Uni<T> emitter(Consumer<UniEmitter<? super T>> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T, S> Uni<T> emitter(Supplier<S> stateSupplier, BiConsumer<S, UniEmitter<? super T>> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Uni<T> deferred(Supplier<Uni<? extends T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Uni<T> context(Function<Context, Uni<? extends T>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T, S> Uni<T> deferred(Supplier<S> stateSupplier, Function<S, Uni<? extends T>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Uni<T> failure(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Uni<T> failure(Supplier<Throwable> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @CheckReturnValue
    public <T> Uni<T> nothing() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Uni<T> multi(Multi<T> multi) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.*;

import java.util.Optional;
import java.util.concurrent.*;
import java.util.concurrent.Flow.Publisher;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.converters.MultiConverter;
import io.smallrye.mutiny.operators.multi.builders.*;
import io.smallrye.mutiny.subscription.BackPressureStrategy;
import io.smallrye.mutiny.subscription.MultiEmitter;

/**
 * Group methods allowing to create {@link Multi} instances from various sources.
 */
public class MultiCreate {

    public static final MultiCreate INSTANCE = new MultiCreate();

    private MultiCreate() {
        // avoid direct instantiation.
    }

    @CheckReturnValue
    public <I, T> Multi<T> converter(MultiConverter<I, T> converter, I instance) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> completionStage(CompletionStage<? extends T> stage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> completionStage(Supplier<? extends CompletionStage<? extends T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> safePublisher(Publisher<T> publisher) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> publisher(Publisher<T> publisher) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> uni(Uni<T> uni) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> item(Supplier<? extends T> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> items(Supplier<? extends Stream<? extends T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> item(T item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SafeVarargs
    @CheckReturnValue
    public final <T> Multi<T> items(T... items) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> iterable(Iterable<T> iterable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> items(Stream<T> items) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("OptionalUsedAsFieldOrParameterType")
    @CheckReturnValue
    public <T> Multi<T> optional(Optional<T> optional) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> optional(Supplier<Optional<T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> emitter(Consumer<MultiEmitter<? super T>> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> emitter(Consumer<MultiEmitter<? super T>> consumer, int bufferSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> emitter(Consumer<MultiEmitter<? super T>> consumer, BackPressureStrategy strategy) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> deferred(Supplier<Multi<? extends T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> context(Function<Context, Multi<? extends T>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> failure(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> failure(Supplier<Throwable> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> nothing() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> empty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiTimePeriod ticks() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<Integer> range(int startInclusive, int endExclusive) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <R, I> MultiResource<R, I> resource(Supplier<? extends R> resourceSupplier,
            Function<? super R, ? extends Publisher<I>> streamSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <R, I> MultiResourceUni<R, I> resourceFromUni(Supplier<Uni<R>> resourceSupplier,
            Function<? super R, ? extends Publisher<I>> streamSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <S, T> Multi<T> generator(Supplier<S> initialStateSupplier,
            BiFunction<S, GeneratorEmitter<? super T>, S> generator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

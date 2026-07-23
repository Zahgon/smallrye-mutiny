package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.*;

import java.util.concurrent.Flow.Publisher;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.common.annotation.Experimental;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

public class MultiOnItem<T> {

    private final Multi<T> upstream;

    public MultiOnItem(Multi<T> upstream) {
        this.upstream = nonNull(upstream, "upstream");
    }

    @CheckReturnValue
    public <R> Multi<R> transform(Function<? super T, ? extends R> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> invoke(Consumer<? super T> callback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> invoke(Runnable callback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> call(Function<? super T, Uni<?>> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> call(Supplier<Uni<?>> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @CheckReturnValue
    public <O> Multi<O> disjoint() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <O> MultiFlatten<T, O> transformToMulti(Function<? super T, ? extends Publisher<? extends O>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <O> Multi<O> transformToMultiAndConcatenate(Function<? super T, ? extends Publisher<? extends O>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <O> Multi<O> transformToMultiAndMerge(Function<? super T, ? extends Publisher<? extends O>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <O> Multi<O> transformToIterable(Function<? super T, ? extends Iterable<O>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <O> MultiFlatten<T, O> transformToUni(Function<? super T, Uni<? extends O>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <O> Multi<O> transformToUniAndConcatenate(Function<? super T, Uni<? extends O>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <O> Multi<O> transformToUniAndMerge(Function<? super T, Uni<? extends O>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<Void> ignore() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<Void> ignoreAsUni() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <O> Multi<O> castTo(Class<O> target) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <S> Multi<S> scan(Supplier<S> initialStateProducer, BiFunction<S, ? super T, S> accumulator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> scan(BinaryOperator<T> accumulator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> failWith(Function<? super T, ? extends Throwable> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> failWith(Supplier<? extends Throwable> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Experimental("This API is still being designed and may change in the future")
    @CheckReturnValue
    public MultiOnItemGather<T> gather() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Experimental("This API is still being designed and may change in the future")
    @CheckReturnValue
    public <ACC, O> Multi<O> gather(Gatherer<T, ACC, O> gatherer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

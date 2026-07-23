package io.smallrye.mutiny.groups;

import java.util.concurrent.CompletionStage;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.UniEmitter;

public class MultiRepetition {

    @CheckReturnValue
    public <S, T> UniRepeat<T> uni(Supplier<S> stateSupplier, Function<S, Uni<? extends T>> producer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> UniRepeat<T> uni(Supplier<Uni<? extends T>> uniSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <S, T> UniRepeat<T> completionStage(Supplier<S> stateSupplier,
            Function<S, ? extends CompletionStage<? extends T>> producer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> UniRepeat<T> completionStage(Supplier<? extends CompletionStage<? extends T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <S, T> UniRepeat<T> uni(Supplier<S> stateSupplier, BiConsumer<S, UniEmitter<? super T>> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> UniRepeat<T> uni(Consumer<UniEmitter<? super T>> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> UniRepeat<T> supplier(Supplier<? extends T> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <S, T> UniRepeat<T> supplier(Supplier<S> stateSupplier, Function<S, ? extends T> producer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

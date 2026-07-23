package io.smallrye.mutiny.infrastructure;

import java.util.concurrent.Callable;
import java.util.function.*;

import io.smallrye.mutiny.tuples.Functions;

/**
 * Intercept user callbacks.
 * Decorators are called when the user passes a callback to Mutiny and so decorators can modify the passed callback.
 * <p>
 * The default behavior is to return the user's callback, unchanged.
 * <p>
 * Decorators must not transform a user callback into {@code null}.
 */
public interface CallbackDecorator extends MutinyInterceptor {

    default <T> Supplier<T> decorate(Supplier<T> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <T> Consumer<T> decorate(Consumer<T> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default LongConsumer decorate(LongConsumer consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <R> LongFunction<R> decorate(LongFunction<R> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Runnable decorate(Runnable runnable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <V> Callable<V> decorate(Callable<V> callable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <T1, T2> BiConsumer<T1, T2> decorate(BiConsumer<T1, T2> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <I, O> Function<I, O> decorate(Function<I, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <I1, I2, I3, O> Functions.Function3<I1, I2, I3, O> decorate(Functions.Function3<I1, I2, I3, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <I1, I2, I3, I4, O> Functions.Function4<I1, I2, I3, I4, O> decorate(
            Functions.Function4<I1, I2, I3, I4, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <I1, I2, I3, I4, I5, O> Functions.Function5<I1, I2, I3, I4, I5, O> decorate(
            Functions.Function5<I1, I2, I3, I4, I5, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <I1, I2, I3, I4, I5, I6, O> Functions.Function6<I1, I2, I3, I4, I5, I6, O> decorate(
            Functions.Function6<I1, I2, I3, I4, I5, I6, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <I1, I2, I3, I4, I5, I6, I7, O> Functions.Function7<I1, I2, I3, I4, I5, I6, I7, O> decorate(
            Functions.Function7<I1, I2, I3, I4, I5, I6, I7, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <I1, I2, I3, I4, I5, I6, I7, I8, O> Functions.Function8<I1, I2, I3, I4, I5, I6, I7, I8, O> decorate(
            Functions.Function8<I1, I2, I3, I4, I5, I6, I7, I8, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <I1, I2, I3, I4, I5, I6, I7, I8, I9, O> Functions.Function9<I1, I2, I3, I4, I5, I6, I7, I8, I9, O> decorate(
            Functions.Function9<I1, I2, I3, I4, I5, I6, I7, I8, I9, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <I1, I2, O> BiFunction<I1, I2, O> decorate(BiFunction<I1, I2, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <T> BinaryOperator<T> decorate(BinaryOperator<T> operator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <T1, T2, T3> Functions.TriConsumer<T1, T2, T3> decorate(Functions.TriConsumer<T1, T2, T3> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default BooleanSupplier decorate(BooleanSupplier supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <T> Predicate<T> decorate(Predicate<T> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

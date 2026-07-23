package io.smallrye.mutiny.unchecked;

import java.util.function.Function;

/**
 * Represents a function that accepts one argument and produces a result.
 * <p>
 * The operation can throw {@link Exception Exceptions}.
 *
 * @param <T> the type of the input to the function
 * @param <R> the type of the result of the function
 */
@FunctionalInterface
public interface UncheckedFunction<T, R> {

    static <T, R> UncheckedFunction<T, R> from(Function<T, R> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Applies this function to the given argument.
     *
     * @param t the function argument
     * @return the function result
     * @throws Exception if anything wrong happen
     */
    R apply(T t) throws Exception;

    default Function<T, R> toFunction() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <V> UncheckedFunction<V, R> compose(UncheckedFunction<? super V, ? extends T> before) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default <V> UncheckedFunction<T, V> andThen(UncheckedFunction<? super R, ? extends V> after) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

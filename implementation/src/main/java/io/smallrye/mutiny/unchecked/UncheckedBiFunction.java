package io.smallrye.mutiny.unchecked;

import java.util.function.BiFunction;

/**
 * Represents a function that accepts two arguments and produces a result.
 * This is the two-arity specialization of {@link UncheckedFunction}.
 * <p>
 * The operation can throw {@link Exception Exceptions}.
 *
 * @param <T> the type of the first argument to the function
 * @param <U> the type of the second argument to the function
 * @param <R> the type of the result of the function
 */
@FunctionalInterface
public interface UncheckedBiFunction<T, U, R> {

    static <T, U, R> UncheckedBiFunction<T, U, R> from(BiFunction<T, U, R> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default BiFunction<T, U, R> toBiFunction() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Applies this function to the given arguments.
     *
     * @param t the first function argument
     * @param u the second function argument
     * @return the function result
     * @throws Exception if anything wrong happen
     */
    R apply(T t, U u) throws Exception;

    default <V> UncheckedBiFunction<T, U, V> andThen(UncheckedFunction<? super R, ? extends V> after) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

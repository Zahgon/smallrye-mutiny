package io.smallrye.mutiny.unchecked;

import java.util.function.BiConsumer;

/**
 * Represents an operation that accepts two input arguments and returns no
 * result. This is the two-arity specialization of {@link UncheckedConsumer}.
 * <p>
 * The operation can throw {@link Exception Exceptions}.
 *
 * @param <T> the type of the first argument to the operation
 * @param <U> the type of the second argument to the operation
 */
@FunctionalInterface
public interface UncheckedBiConsumer<T, U> {

    static <T, U> UncheckedBiConsumer<T, U> from(BiConsumer<T, U> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Performs this operation on the given arguments.
     *
     * @param t the first input argument
     * @param u the second input argument
     * @throws Exception if something <em>bad</em> happen during the execution
     */
    void accept(T t, U u) throws Exception;

    default UncheckedBiConsumer<T, U> andThen(UncheckedBiConsumer<? super T, ? super U> after) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default BiConsumer<T, U> toBiConsumer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

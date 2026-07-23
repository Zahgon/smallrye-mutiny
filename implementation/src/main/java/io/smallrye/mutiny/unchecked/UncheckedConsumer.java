package io.smallrye.mutiny.unchecked;

import java.util.function.Consumer;

/**
 * Represents an operation that accepts a single input argument and returns no
 * result.
 * <p>
 * The operation can throw {@link Exception Exceptions}.
 *
 * @param <T> the type of the input to the operation
 */
@FunctionalInterface
public interface UncheckedConsumer<T> {

    static <T> UncheckedConsumer<T> from(Consumer<T> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Performs this operation on the given argument.
     *
     * @param t the input argument
     * @throws Exception if anything wrong happen
     */
    void accept(T t) throws Exception;

    default UncheckedConsumer<T> andThen(UncheckedConsumer<? super T> after) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    default Consumer<T> toConsumer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

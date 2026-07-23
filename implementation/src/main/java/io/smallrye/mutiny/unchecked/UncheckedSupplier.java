package io.smallrye.mutiny.unchecked;

import java.util.function.Supplier;

/**
 * Represents a supplier of items.
 * <p>
 * The supplier can throw {@link Exception Exceptions}.
 *
 * @param <T> the type of items supplied by this supplier
 */
@FunctionalInterface
public interface UncheckedSupplier<T> {

    static <T> UncheckedSupplier<T> from(Supplier<T> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Gets an item.
     *
     * @return an item
     * @throws Exception if anything wrong happen
     */
    T get() throws Exception;

    default Supplier<T> toSupplier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

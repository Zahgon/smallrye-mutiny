package io.smallrye.mutiny.unchecked;

import java.util.function.*;

/**
 * Provides wrapper to handle functions / consumers / suppliers that throw checked exceptions.
 */
public class Unchecked {

    private Unchecked() {
        // avoid direct instantiation.
    }

    public static <T, U, R> UncheckedBiFunction<T, U, R> unchecked(BiFunction<T, U, R> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T, R> UncheckedFunction<T, R> unchecked(Function<T, R> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> UncheckedConsumer<T> unchecked(Consumer<T> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T, U> UncheckedBiConsumer<T, U> unchecked(BiConsumer<T, U> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> UncheckedSupplier<T> unchecked(Supplier<T> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T, R> Function<T, R> function(UncheckedFunction<T, R> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T, U, R> BiFunction<T, U, R> function(UncheckedBiFunction<T, U, R> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T, U> BiConsumer<T, U> consumer(UncheckedBiConsumer<T, U> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Consumer<T> consumer(UncheckedConsumer<T> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Supplier<T> supplier(UncheckedSupplier<T> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

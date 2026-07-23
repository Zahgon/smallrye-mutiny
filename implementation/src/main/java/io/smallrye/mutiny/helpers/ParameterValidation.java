package io.smallrye.mutiny.helpers;

import java.time.Duration;
import java.util.Collection;

/**
 * A class to validate method parameters.
 * these methods throw {@link IllegalArgumentException} is the validation fails.
 */
public class ParameterValidation {

    public static final String SUPPLIER_PRODUCED_NULL = "The supplier returned `null`";

    public static final String MAPPER_RETURNED_NULL = "The mapper returned `null`";

    private ParameterValidation() {
        // avoid direct instantiation
    }

    public static Duration validate(Duration duration, String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> T nonNull(T instance, String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> T nonNullNpe(T instance, String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static long positive(long amount, String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static int positive(int amount, String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static int positiveOrZero(int amount, String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static long positiveOrZero(long amount, String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T extends Iterable<?>> T doesNotContainNull(T iterable, String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> T[] doesNotContainNull(T[] array, String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T extends Collection<?>> T isNotEmpty(T collection, String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T extends Collection<?>> T size(T instance, int expectedSize, String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

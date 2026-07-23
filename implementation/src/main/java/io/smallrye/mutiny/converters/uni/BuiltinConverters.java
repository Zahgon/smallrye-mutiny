package io.smallrye.mutiny.converters.uni;

public class BuiltinConverters {

    private BuiltinConverters() {
        // Avoid direct instantiation
    }

    @SuppressWarnings("unchecked")
    public static <T> FromCompletionStage<T> fromCompletionStage() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public static <T> ToCompletionStage<T> toCompletionStage() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public static <T> ToCompletableFuture<T> toCompletableFuture() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public static <T> ToPublisher<T> toPublisher() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

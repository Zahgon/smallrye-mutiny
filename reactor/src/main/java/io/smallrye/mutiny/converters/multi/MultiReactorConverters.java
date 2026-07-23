package io.smallrye.mutiny.converters.multi;

public class MultiReactorConverters {

    private MultiReactorConverters() {
        // Avoid direct instantiation
    }

    @SuppressWarnings("unchecked")
    public static <T> FromMono<T> fromMono() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public static <T> FromFlux<T> fromFlux() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public static <T> ToMono<T> toMono() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public static <T> ToFlux<T> toFlux() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

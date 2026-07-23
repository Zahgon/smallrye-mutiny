package io.smallrye.mutiny.converters.uni;

import io.reactivex.rxjava3.core.Maybe;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.converters.UniConverter;

public class FromMaybe<T> implements UniConverter<Maybe<T>, T> {

    @SuppressWarnings("rawtypes")
    public static final FromMaybe INSTANCE = new FromMaybe();

    private FromMaybe() {
        // Avoid direct instantiation
    }

    @Override
    public Uni<T> from(Maybe<T> instance) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

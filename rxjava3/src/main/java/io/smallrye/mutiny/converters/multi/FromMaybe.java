package io.smallrye.mutiny.converters.multi;

import io.reactivex.rxjava3.core.Maybe;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.converters.MultiConverter;

public class FromMaybe<T> implements MultiConverter<Maybe<T>, T> {

    public static final FromMaybe INSTANCE = new FromMaybe();

    private FromMaybe() {
        // Avoid direct instantiation
    }

    @Override
    public Multi<T> from(Maybe<T> instance) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

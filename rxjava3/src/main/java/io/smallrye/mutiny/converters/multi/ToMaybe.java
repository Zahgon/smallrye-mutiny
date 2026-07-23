package io.smallrye.mutiny.converters.multi;

import java.util.function.Function;

import io.reactivex.rxjava3.core.Maybe;
import io.smallrye.mutiny.Multi;

public class ToMaybe<T> implements Function<Multi<T>, Maybe<T>> {

    @SuppressWarnings("rawtypes")
    public static final ToMaybe INSTANCE = new ToMaybe();

    private ToMaybe() {
        // Avoid direct instantiation
    }

    @Override
    public Maybe<T> apply(Multi<T> multi) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

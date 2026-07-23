package io.smallrye.mutiny.converters.uni;

import java.util.function.Function;

import io.reactivex.rxjava3.core.Maybe;
import io.smallrye.mutiny.Uni;

public class ToMaybe<T> implements Function<Uni<T>, Maybe<T>> {

    @SuppressWarnings("rawtypes")
    public static final ToMaybe INSTANCE = new ToMaybe();

    private ToMaybe() {
        // Avoid direct instantiation
    }

    @Override
    public Maybe<T> apply(Uni<T> uni) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

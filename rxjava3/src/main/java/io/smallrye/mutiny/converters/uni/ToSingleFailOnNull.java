package io.smallrye.mutiny.converters.uni;

import java.util.function.Function;

import io.reactivex.rxjava3.core.Single;
import io.smallrye.mutiny.Uni;

public class ToSingleFailOnNull<T> implements Function<Uni<T>, Single<T>> {

    public static final ToSingleFailOnNull INSTANCE = new ToSingleFailOnNull();

    private ToSingleFailOnNull() {
        // Avoid direct instantiation
    }

    @Override
    public Single<T> apply(Uni<T> uni) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

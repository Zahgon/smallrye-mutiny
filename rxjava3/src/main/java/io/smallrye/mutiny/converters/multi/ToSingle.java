package io.smallrye.mutiny.converters.multi;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import io.reactivex.rxjava3.core.Single;
import io.smallrye.mutiny.Multi;

public class ToSingle<T> implements Function<Multi<T>, Single<Optional<T>>> {

    @SuppressWarnings("rawtypes")
    public static final ToSingle INSTANCE = new ToSingle();

    private ToSingle() {
        // Avoid direct instantiation
    }

    public <R> ToSingleFailOnNull<R> onEmptyThrow(Supplier<? extends Throwable> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Single<Optional<T>> apply(Multi<T> multi) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

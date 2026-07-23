package io.smallrye.mutiny.converters.uni;

import io.reactivex.rxjava3.core.Observable;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.converters.UniConverter;

public class FromObservable<T> implements UniConverter<Observable<T>, T> {

    public static final FromObservable INSTANCE = new FromObservable();

    private FromObservable() {
        // Avoid direct instantiation
    }

    @Override
    public Uni<T> from(Observable<T> instance) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

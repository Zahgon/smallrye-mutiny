package io.smallrye.mutiny.converters.uni;

import java.util.function.Function;

import io.smallrye.mutiny.Uni;
import reactor.core.publisher.Flux;

public class ToFlux<T> implements Function<Uni<T>, Flux<T>> {

    public final static ToFlux INSTANCE = new ToFlux();

    private ToFlux() {
        // Avoid direct instantiation
    }

    @Override
    public Flux<T> apply(Uni<T> uni) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

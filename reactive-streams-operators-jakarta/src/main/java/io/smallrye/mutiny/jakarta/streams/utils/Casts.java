package io.smallrye.mutiny.jakarta.streams.utils;

import java.util.concurrent.CompletionStage;
import java.util.function.Function;
import java.util.function.Predicate;

import org.reactivestreams.Processor;

import io.smallrye.mutiny.jakarta.streams.operators.ProcessingStage;

/**
 * Cosmetic cast / generic / erasure fixes.
 * <p>
 * At some point this class should disappear...
 *
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
@SuppressWarnings("unchecked")
public class Casts {

    private Casts() {
        // Avoid direct instantiation.
    }

    public static <I, O> Function<I, O> cast(Function<?, ?> fun) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <I> Predicate<I> cast(Predicate<?> p) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <I, O> ProcessingStage<I, O> cast(ProcessingStage<?, ?> p) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <I, O> Processor<I, O> cast(Processor<?, ?> p) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <O> CompletionStage<O> cast(CompletionStage<?> cs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

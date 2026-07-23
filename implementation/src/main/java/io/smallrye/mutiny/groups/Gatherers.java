package io.smallrye.mutiny.groups;

import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import io.smallrye.common.annotation.Experimental;
import io.smallrye.mutiny.groups.Gatherer.Extraction;

/**
 * Factory interface for creating {@link Gatherer} instances.
 * <p>
 * This interface provides various static methods to create different types of gatherers.
 */
@Experimental("This API is still being designed and may change in the future")
public interface Gatherers {

    static <I, ACC, O> Gatherer<I, ACC, O> of(Supplier<ACC> initialAccumulatorSupplier,
            BiFunction<ACC, I, ACC> accumulatorFunction, BiFunction<ACC, Boolean, Optional<Extraction<ACC, O>>> extractor,
            Function<ACC, Optional<O>> finalizer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <I> Gatherer<I, I, I> scan(Supplier<I> initialAccumulatorSupplier, BiFunction<I, I, I> accumulatorFunction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <I> Gatherer<I, I, I> fold(Supplier<I> initialAccumulatorSupplier, BiFunction<I, I, I> accumulatorFunction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <I> Gatherer<I, List<I>, List<I>> window(int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <I> Gatherer<I, List<I>, List<I>> slidingWindow(int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Default implementation of the {@link Gatherer} interface.
     *
     * @param <I> the type of the items emitted by the upstream
     * @param <ACC> the type of the accumulator
     * @param <O> the type of the items emitted to the downstream
     */
    class DefaultGatherer<I, ACC, O> implements Gatherer<I, ACC, O> {

        private final Supplier<ACC> initialAccumulatorSupplier;

        private final BiFunction<ACC, I, ACC> accumulatorFunction;

        private final BiFunction<ACC, Boolean, Optional<Extraction<ACC, O>>> extractor;

        private final Function<ACC, Optional<O>> finalizer;

        public DefaultGatherer(Supplier<ACC> initialAccumulatorSupplier, BiFunction<ACC, I, ACC> accumulatorFunction,
                BiFunction<ACC, Boolean, Optional<Extraction<ACC, O>>> extractor, Function<ACC, Optional<O>> finalizer) {
            this.initialAccumulatorSupplier = initialAccumulatorSupplier;
            this.accumulatorFunction = accumulatorFunction;
            this.extractor = extractor;
            this.finalizer = finalizer;
        }

        @Override
        public ACC accumulator() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public ACC accumulate(ACC accumulator, I item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Optional<Extraction<ACC, O>> extract(ACC accumulator, boolean upstreamCompleted) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Optional<O> finalize(ACC accumulator) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static <I> Gatherer.Builder<I> builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

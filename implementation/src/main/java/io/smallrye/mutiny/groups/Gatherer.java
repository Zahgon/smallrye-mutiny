package io.smallrye.mutiny.groups;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.common.annotation.Experimental;
import io.smallrye.mutiny.Multi;

/**
 * A Gatherer operator transforms a stream of items by accumulating them into an accumulator and extracting
 * items from that accumulator when certain conditions are met.
 *
 * @param <I> the type of the items emitted by the upstream
 * @param <ACC> the type of the accumulator
 * @param <O> the type of the items emitted to the downstream
 */
@Experimental("This API is still being designed and may change in the future")
public interface Gatherer<I, ACC, O> {

    /**
     * Creates a new accumulator.
     *
     * @return a new accumulator
     */
    ACC accumulator();

    /**
     * Accumulates an item into the accumulator.
     *
     * @param accumulator the current accumulator
     * @param item the item to accumulate
     * @return the updated accumulator
     */
    ACC accumulate(ACC accumulator, I item);

    /**
     * Extracts an item from the accumulator.
     *
     * @param accumulator the current accumulator
     * @param upstreamCompleted whether the upstream has completed
     * @return an Optional containing a Extraction with the updated accumulator and the extracted item, or an empty Optional if
     *         no
     *         item can be extracted
     */
    Optional<Extraction<ACC, O>> extract(ACC accumulator, boolean upstreamCompleted);

    /**
     * Finalizes the accumulator and extracts the final item, if any.
     * This method is called when the upstream has completed and no more items can be extracted using the extract method.
     *
     * @param accumulator the current accumulator
     * @return an Optional containing the final item, or an empty Optional if no final item can be extracted
     */
    Optional<O> finalize(ACC accumulator);

    /**
     * An extraction result containing the next accumulator and the next item to emit.
     *
     * @param nextAccumulator the next accumulator
     * @param nextItem the next item to emit
     * @param <ACC> the type of the accumulator
     * @param <O> the type of the item to emit
     */
    record Extraction<ACC, O>(ACC nextAccumulator, O nextItem) {

        public static <ACC, O> Extraction<ACC, O> of(ACC nextAccumulator, O nextItem) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * Builder for creating a {@link Gatherer}.
     *
     * @param <I> the type of the items emitted by the upstream
     */
    class Builder<I> {

        @CheckReturnValue
        public <ACC> InitialAccumulatorStep<I, ACC> into(Supplier<ACC> initialAccumulatorSupplier) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * The first step in the builder to gather items emitted by a {@link Multi} into an accumulator.
     *
     * @param <I> the type of the items emitted by the upstream {@link Multi}
     * @param <ACC> the type of the accumulator
     */
    class InitialAccumulatorStep<I, ACC> {

        private final Supplier<ACC> initialAccumulatorSupplier;

        private InitialAccumulatorStep(Supplier<ACC> initialAccumulatorSupplier) {
            this.initialAccumulatorSupplier = initialAccumulatorSupplier;
        }

        @CheckReturnValue
        public ExtractStep<I, ACC> accumulate(BiFunction<ACC, I, ACC> accumulator) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * The second step in the builder to gather items emitted by a {@link Multi} into an accumulator.
     *
     * @param <I> the type of the items emitted by the upstream {@link Multi}
     * @param <ACC> the type of the accumulator
     */
    class ExtractStep<I, ACC> {

        private final Supplier<ACC> initialAccumulatorSupplier;

        private final BiFunction<ACC, I, ACC> accumulator;

        private ExtractStep(Supplier<ACC> initialAccumulatorSupplier, BiFunction<ACC, I, ACC> accumulator) {
            this.initialAccumulatorSupplier = initialAccumulatorSupplier;
            this.accumulator = accumulator;
        }

        @CheckReturnValue
        public <O> FinalizerStep<I, ACC, O> extract(BiFunction<ACC, Boolean, Optional<Extraction<ACC, O>>> extractor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * The third step in the builder to gather items emitted by a {@link Multi} into an accumulator.
     *
     * @param <I> the type of the items emitted by the upstream
     * @param <ACC> the type of the accumulator
     * @param <O> the type of the items emitted to the downstream
     */
    class FinalizerStep<I, ACC, O> {

        private final Supplier<ACC> initialAccumulatorSupplier;

        private final BiFunction<ACC, I, ACC> accumulator;

        private final BiFunction<ACC, Boolean, Optional<Extraction<ACC, O>>> extractor;

        private FinalizerStep(Supplier<ACC> initialAccumulatorSupplier, BiFunction<ACC, I, ACC> accumulator,
                BiFunction<ACC, Boolean, Optional<Extraction<ACC, O>>> extractor) {
            this.initialAccumulatorSupplier = initialAccumulatorSupplier;
            this.accumulator = accumulator;
            this.extractor = extractor;
        }

        @CheckReturnValue
        public Gatherer<I, ACC, O> finalize(Function<ACC, Optional<O>> finalizer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

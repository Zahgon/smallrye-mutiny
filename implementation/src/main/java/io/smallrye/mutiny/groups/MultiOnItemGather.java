package io.smallrye.mutiny.groups;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.common.annotation.Experimental;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.groups.Gatherer.Extraction;

/**
 * A builder to gather items emitted by a {@link Multi} into an accumulator.
 *
 * @param <I> the type of the items emitted by the upstream {@link Multi}
 */
@Experimental("This API is still being designed and may change in the future")
public class MultiOnItemGather<I> {

    private final Multi<I> upstream;

    public MultiOnItemGather(Multi<I> upstream) {
        this.upstream = upstream;
    }

    @CheckReturnValue
    public <ACC> InitialAccumulatorStep<I, ACC> into(Supplier<ACC> initialAccumulatorSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The first step in the builder to gather items emitted by a {@link Multi} into an accumulator.
     *
     * @param <I> the type of the items emitted by the upstream {@link Multi}
     * @param <ACC> the type of the accumulator
     */
    public static class InitialAccumulatorStep<I, ACC> {

        private final Multi<I> upstream;

        private final Supplier<ACC> initialAccumulatorSupplier;

        private InitialAccumulatorStep(Multi<I> upstream, Supplier<ACC> initialAccumulatorSupplier) {
            this.upstream = upstream;
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
    public static class ExtractStep<I, ACC> {

        private final Multi<I> upstream;

        private final Supplier<ACC> initialAccumulatorSupplier;

        private final BiFunction<ACC, I, ACC> accumulator;

        private ExtractStep(Multi<I> upstream, Supplier<ACC> initialAccumulatorSupplier, BiFunction<ACC, I, ACC> accumulator) {
            this.upstream = upstream;
            this.initialAccumulatorSupplier = initialAccumulatorSupplier;
            this.accumulator = accumulator;
        }

        @CheckReturnValue
        public <O> FinalizerStep<I, ACC, O> extract(BiFunction<ACC, Boolean, Optional<Extraction<ACC, O>>> extractor) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    /**
     * The last step in the builder to gather items emitted by a {@link Multi} into an accumulator.
     *
     * @param <I> the type of the items emitted by the upstream {@link Multi}
     * @param <ACC> the type of the accumulator
     * @param <O> the type of the values to emit
     */
    public static class FinalizerStep<I, ACC, O> {

        private final Multi<I> upstream;

        private final Supplier<ACC> initialAccumulatorSupplier;

        private final BiFunction<ACC, I, ACC> accumulator;

        private final BiFunction<ACC, Boolean, Optional<Extraction<ACC, O>>> extractor;

        private FinalizerStep(Multi<I> upstream, Supplier<ACC> initialAccumulatorSupplier, BiFunction<ACC, I, ACC> accumulator,
                BiFunction<ACC, Boolean, Optional<Extraction<ACC, O>>> extractor) {
            this.upstream = upstream;
            this.initialAccumulatorSupplier = initialAccumulatorSupplier;
            this.accumulator = accumulator;
            this.extractor = extractor;
        }

        @CheckReturnValue
        public Multi<O> finalize(Function<ACC, Optional<O>> finalizer) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

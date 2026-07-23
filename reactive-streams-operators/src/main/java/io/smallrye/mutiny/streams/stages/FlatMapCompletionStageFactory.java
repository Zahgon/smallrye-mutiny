package io.smallrye.mutiny.streams.stages;

import java.util.Objects;
import java.util.concurrent.CompletionStage;
import java.util.function.Function;

import org.eclipse.microprofile.reactive.streams.operators.spi.Stage;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.streams.Engine;
import io.smallrye.mutiny.streams.operators.ProcessingStage;
import io.smallrye.mutiny.streams.operators.ProcessingStageFactory;

/**
 * Implementation of the {@link Stage.FlatMapCompletionStage} stage.
 *
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class FlatMapCompletionStageFactory implements ProcessingStageFactory<Stage.FlatMapCompletionStage> {

    @Override
    public <I, O> ProcessingStage<I, O> create(Engine engine, Stage.FlatMapCompletionStage stage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class FlatMapCompletionStage<I, O> implements ProcessingStage<I, O> {

        private final Function<I, CompletionStage<O>> mapper;

        private FlatMapCompletionStage(Function<I, CompletionStage<O>> mapper) {
            this.mapper = Objects.requireNonNull(mapper);
        }

        @Override
        public Multi<O> apply(Multi<I> source) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

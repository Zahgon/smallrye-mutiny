package io.smallrye.mutiny.jakarta.streams.stages;

import java.util.Objects;
import java.util.function.Function;

import org.eclipse.microprofile.reactive.streams.operators.spi.Graph;
import org.eclipse.microprofile.reactive.streams.operators.spi.Stage;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.jakarta.streams.Engine;
import io.smallrye.mutiny.jakarta.streams.operators.ProcessingStage;
import io.smallrye.mutiny.jakarta.streams.operators.ProcessingStageFactory;

/**
 * Implementation of the {@link Stage.FlatMap} stage. Be aware it behaves as a RX `concatMap`.
 *
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class FlatMapStageFactory implements ProcessingStageFactory<Stage.FlatMap> {

    @Override
    public <I, O> ProcessingStage<I, O> create(Engine engine, Stage.FlatMap stage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class FlatMapStage<I, O> implements ProcessingStage<I, O> {

        private final Engine engine;

        private final Function<I, Graph> mapper;

        private FlatMapStage(Engine engine, Function<I, Graph> mapper) {
            this.mapper = Objects.requireNonNull(mapper);
            this.engine = engine;
        }

        @Override
        public Multi<O> apply(Multi<I> source) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

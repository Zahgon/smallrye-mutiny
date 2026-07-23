package io.smallrye.mutiny.jakarta.streams.stages;

import java.util.Objects;
import java.util.function.Predicate;

import org.eclipse.microprofile.reactive.streams.operators.spi.Stage;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.jakarta.streams.Engine;
import io.smallrye.mutiny.jakarta.streams.operators.ProcessingStage;
import io.smallrye.mutiny.jakarta.streams.operators.ProcessingStageFactory;

/**
 * Implementation of the {@link Stage.DropWhile} stage.
 *
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class DropWhileStageFactory implements ProcessingStageFactory<Stage.DropWhile> {

    @Override
    public <I, O> ProcessingStage<I, O> create(Engine engine, Stage.DropWhile stage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class TakeWhile<I> implements ProcessingStage<I, I> {

        private final Predicate<I> predicate;

        TakeWhile(Predicate<I> predicate) {
            this.predicate = Objects.requireNonNull(predicate);
        }

        @Override
        public Multi<I> apply(Multi<I> source) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

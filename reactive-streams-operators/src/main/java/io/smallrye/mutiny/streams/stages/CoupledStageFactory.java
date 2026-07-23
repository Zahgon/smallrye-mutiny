package io.smallrye.mutiny.streams.stages;

import org.eclipse.microprofile.reactive.streams.operators.spi.Stage;

import io.smallrye.mutiny.streams.Engine;
import io.smallrye.mutiny.streams.operators.ProcessingStage;
import io.smallrye.mutiny.streams.operators.ProcessingStageFactory;

/**
 * Implementation of the {@link Stage.Coupled} stage.
 *
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class CoupledStageFactory implements ProcessingStageFactory<Stage.Coupled> {

    @Override
    public <I, O> ProcessingStage<I, O> create(Engine engine, Stage.Coupled stage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package io.smallrye.mutiny.jakarta.streams.stages;

import org.eclipse.microprofile.reactive.streams.operators.spi.Stage;

import io.smallrye.mutiny.jakarta.streams.Engine;
import io.smallrye.mutiny.jakarta.streams.operators.ProcessingStage;
import io.smallrye.mutiny.jakarta.streams.operators.ProcessingStageFactory;

/**
 * Implementation of the {@link Stage.Map} stage.
 *
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class MapStageFactory implements ProcessingStageFactory<Stage.Map> {

    @Override
    public <I, O> ProcessingStage<I, O> create(Engine engine, Stage.Map stage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package io.smallrye.mutiny.streams.stages;

import org.eclipse.microprofile.reactive.streams.operators.spi.Stage;

import io.smallrye.mutiny.streams.Engine;
import io.smallrye.mutiny.streams.operators.ProcessingStage;
import io.smallrye.mutiny.streams.operators.ProcessingStageFactory;

/**
 * Implementation of the {@link Stage.ProcessorStage} stage ({@code via} operators).
 *
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class ProcessorStageFactory implements ProcessingStageFactory<Stage.ProcessorStage> {

    @Override
    public <I, O> ProcessingStage<I, O> create(Engine engine, Stage.ProcessorStage stage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

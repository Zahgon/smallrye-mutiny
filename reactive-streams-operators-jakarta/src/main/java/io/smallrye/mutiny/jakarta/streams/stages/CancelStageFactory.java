package io.smallrye.mutiny.jakarta.streams.stages;

import org.eclipse.microprofile.reactive.streams.operators.spi.Stage;

import io.smallrye.mutiny.jakarta.streams.Engine;
import io.smallrye.mutiny.jakarta.streams.operators.TerminalStage;
import io.smallrye.mutiny.jakarta.streams.operators.TerminalStageFactory;

/**
 * Implementation of {@link Stage.Cancel}. It subscribes and disposes the stream immediately.
 *
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class CancelStageFactory implements TerminalStageFactory<Stage.Cancel> {

    @Override
    public <I, O> TerminalStage<I, O> create(Engine engine, Stage.Cancel stage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package io.smallrye.mutiny.jakarta.streams.stages;

import org.eclipse.microprofile.reactive.streams.operators.spi.Stage;

import io.smallrye.mutiny.jakarta.streams.Engine;
import io.smallrye.mutiny.jakarta.streams.operators.PublisherStage;
import io.smallrye.mutiny.jakarta.streams.operators.PublisherStageFactory;

public class FromCompletionStageNullableFactory implements PublisherStageFactory<Stage.FromCompletionStageNullable> {

    @Override
    public <O> PublisherStage<O> create(Engine engine, Stage.FromCompletionStageNullable stage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

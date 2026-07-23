package io.smallrye.mutiny.streams.stages;

import java.util.concurrent.CompletionStage;

import org.eclipse.microprofile.reactive.streams.operators.spi.Stage;
import org.reactivestreams.Subscriber;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.streams.Engine;
import io.smallrye.mutiny.streams.operators.TerminalStage;
import io.smallrye.mutiny.streams.operators.TerminalStageFactory;

/**
 * Implementation of the {@link Stage.SubscriberStage} stage.
 *
 * @author <a href="http://escoffier.me">Clement Escoffier</a>
 */
public class SubscriberStageFactory implements TerminalStageFactory<Stage.SubscriberStage> {

    @SuppressWarnings("unchecked")
    @Override
    public <I, O> TerminalStage<I, O> create(Engine engine, Stage.SubscriberStage stage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class SubscriberStage<I> implements TerminalStage<I, Void> {

        private final Subscriber<I> subscriber;

        SubscriberStage(Subscriber<I> subscriber) {
            this.subscriber = subscriber;
        }

        @Override
        public CompletionStage<Void> apply(Multi<I> source) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

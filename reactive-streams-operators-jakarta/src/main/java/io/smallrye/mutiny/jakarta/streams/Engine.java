package io.smallrye.mutiny.jakarta.streams;

import java.util.concurrent.CompletionStage;

import org.eclipse.microprofile.reactive.streams.operators.spi.Graph;
import org.eclipse.microprofile.reactive.streams.operators.spi.ReactiveStreamsEngine;
import org.eclipse.microprofile.reactive.streams.operators.spi.Stage;
import org.eclipse.microprofile.reactive.streams.operators.spi.SubscriberWithCompletionStage;
import org.reactivestreams.Processor;
import org.reactivestreams.Publisher;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.jakarta.streams.operators.ProcessingStage;
import io.smallrye.mutiny.jakarta.streams.operators.ProcessorOperator;
import io.smallrye.mutiny.jakarta.streams.operators.PublisherOperator;
import io.smallrye.mutiny.jakarta.streams.operators.PublisherStage;
import io.smallrye.mutiny.jakarta.streams.operators.TerminalOperator;
import io.smallrye.mutiny.jakarta.streams.operators.TerminalStage;
import io.smallrye.mutiny.jakarta.streams.spi.Transformer;

public class Engine implements ReactiveStreamsEngine {

    @Override
    public <T> Publisher<T> buildPublisher(Graph graph) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T, R> SubscriberWithCompletionStage<T, R> buildSubscriber(Graph graph) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T, R> Processor<T, R> buildProcessor(Graph graph) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> CompletionStage<T> buildCompletion(Graph graph) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private <I, O> Multi<O> applyProcessors(Multi<I> multi, Stage stage, ProcessorOperator operator) {
        @SuppressWarnings("unchecked")
        ProcessingStage<I, O> ps = operator.create(this, stage);
        return Transformer.apply(ps.apply(multi));
    }

    private <T, R> CompletionStage<R> applySubscriber(Multi<T> multi, Stage stage, TerminalOperator operator) {
        @SuppressWarnings("unchecked")
        TerminalStage<T, R> ps = operator.create(this, stage);
        return ps.apply(Transformer.apply(multi));
    }

    private <O> Multi<O> createPublisher(Stage stage, PublisherOperator operator) {
        @SuppressWarnings("unchecked")
        PublisherStage<O> ps = operator.create(this, stage);
        return Transformer.apply(ps.get());
    }
}

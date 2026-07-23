package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Flow;
import java.util.function.Function;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Uni;

public class UniConvert<T> {

    private final Uni<T> upstream;

    public UniConvert(Uni<T> upstream) {
        this.upstream = nonNull(upstream, "upstream");
    }

    public <R> R with(Function<Uni<T>, R> converter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public CompletionStage<T> toCompletionStage() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public CompletableFuture<T> toCompletableFuture() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Flow.Publisher<T> toPublisher() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

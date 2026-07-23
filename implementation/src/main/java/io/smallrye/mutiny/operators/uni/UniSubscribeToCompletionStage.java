package io.smallrye.mutiny.operators.uni;

import java.util.concurrent.CompletableFuture;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;

public class UniSubscribeToCompletionStage {

    public static <T> CompletableFuture<T> subscribe(Uni<T> uni, Context context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

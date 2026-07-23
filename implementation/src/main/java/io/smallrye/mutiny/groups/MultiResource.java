package io.smallrye.mutiny.groups;

import java.util.concurrent.Flow.Publisher;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

/**
 * Allows configuring a <em>finalizer</em> to close the resource attached to the stream.
 *
 * @param <R> the type of resource
 * @param <I> the type of item emitted by the resulting {@code Multi}
 * @see MultiCreate#resource(Supplier, Function)
 */
public class MultiResource<R, I> {

    private final Function<? super R, ? extends Publisher<I>> streamSupplier;

    private final Supplier<? extends R> resourceSupplier;

    public MultiResource(Supplier<? extends R> resourceSupplier, Function<? super R, ? extends Publisher<I>> streamSupplier) {
        this.resourceSupplier = resourceSupplier;
        this.streamSupplier = streamSupplier;
    }

    @CheckReturnValue
    public Multi<I> withFinalizer(Consumer<? super R> finalizer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <R> Function<? super R, Uni<Void>> getUniFunction(Consumer<? super R> finalizer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<I> withFinalizer(Function<? super R, Uni<Void>> finalizer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<I> withFinalizer(Function<? super R, Uni<Void>> onCompletion,
            BiFunction<? super R, ? super Throwable, Uni<Void>> onFailure, Function<? super R, Uni<Void>> onCancellation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

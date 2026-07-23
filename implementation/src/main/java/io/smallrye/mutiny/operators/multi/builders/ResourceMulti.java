package io.smallrye.mutiny.operators.multi.builders;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class ResourceMulti<R, I> extends AbstractMulti<I> {

    private final Supplier<? extends R> resourceSupplier;

    private final Function<? super R, ? extends Publisher<I>> streamSupplier;

    private final Function<? super R, Uni<Void>> onCompletion;

    private final BiFunction<? super R, ? super Throwable, Uni<Void>> onFailure;

    private final Function<? super R, Uni<Void>> onCancellation;

    public ResourceMulti(Supplier<? extends R> resourceSupplier, Function<? super R, ? extends Publisher<I>> streamSupplier,
            Function<? super R, Uni<Void>> onCompletion, BiFunction<? super R, ? super Throwable, Uni<Void>> onFailure,
            Function<? super R, Uni<Void>> onCancellation) {
        this.resourceSupplier = resourceSupplier;
        this.streamSupplier = streamSupplier;
        this.onCompletion = onCompletion;
        this.onFailure = onFailure;
        this.onCancellation = onCancellation;
    }

    @Override
    public void subscribe(MultiSubscriber<? super I> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class ResourceSubscriber<I, R> implements Subscription, MultiSubscriber<I>, ContextSupport {

        private final MultiSubscriber<? super I> downstream;

        private final R resource;

        private final Function<? super R, Uni<Void>> onCompletion;

        private final BiFunction<? super R, ? super Throwable, Uni<Void>> onFailure;

        private final Function<? super R, Uni<Void>> onCancellation;

        private final AtomicBoolean terminated = new AtomicBoolean();

        private final AtomicReference<Subscription> upstream = new AtomicReference<>();

        public ResourceSubscriber(MultiSubscriber<? super I> downstream, R resource,
                Function<? super R, Uni<Void>> onCompletion, BiFunction<? super R, ? super Throwable, Uni<Void>> onFailure,
                Function<? super R, Uni<Void>> onCancellation) {
            this.downstream = downstream;
            this.resource = resource;
            this.onCompletion = onCompletion;
            this.onFailure = onFailure;
            this.onCancellation = onCancellation;
        }

        @Override
        public void onSubscribe(Subscription s) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(I item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Context context() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

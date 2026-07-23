package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.Queue;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.helpers.BlockingIterable;
import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.Cancellable;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiSubscribe<T> {

    private final AbstractMulti<T> upstream;

    public MultiSubscribe(AbstractMulti<T> upstream) {
        this.upstream = nonNull(upstream, "upstream");
    }

    public <S extends Subscriber<? super T>> S withSubscriber(S subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <S extends MultiSubscriber<? super T>> S withSubscriber(S subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Cancellable with(Consumer<? super Subscription> onSubscription, Consumer<? super T> onItem,
            Consumer<? super Throwable> onFailure, Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Cancellable with(Context context, Consumer<? super Subscription> onSubscription, Consumer<? super T> onItem,
            Consumer<? super Throwable> onFailure, Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Cancellable with(Consumer<? super T> onItem, Consumer<? super Throwable> onFailure, Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Cancellable with(Context context, Consumer<? super T> onItem, Consumer<? super Throwable> onFailure,
            Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Cancellable with(Consumer<? super T> onItem, Consumer<? super Throwable> onFailure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Cancellable with(Context context, Consumer<? super T> onItem, Consumer<? super Throwable> onFailure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Cancellable with(Consumer<? super T> onItem) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Cancellable with(Context context, Consumer<? super T> onItem) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Cancellable with(Consumer<? super T> onItem, Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Cancellable with(Context context, Consumer<? super T> onItem, Runnable onComplete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public BlockingIterable<T> asIterable() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public BlockingIterable<T> asIterable(Supplier<Context> contextSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public BlockingIterable<T> asIterable(int batchSize, Supplier<Queue<T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public BlockingIterable<T> asIterable(Supplier<Context> contextSupplier, int batchSize, Supplier<Queue<T>> queueSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Stream<T> asStream() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Stream<T> asStream(Supplier<Context> contextSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Stream<T> asStream(int batchSize, Supplier<Queue<T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Stream<T> asStream(Supplier<Context> contextSupplier, int batchSize, Supplier<Queue<T>> queueSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

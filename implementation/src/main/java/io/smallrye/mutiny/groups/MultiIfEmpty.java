package io.smallrye.mutiny.groups;

import java.util.concurrent.Flow;
import java.util.function.Consumer;
import java.util.function.Supplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiEmitter;

public class MultiIfEmpty<T> {

    private final Multi<T> upstream;

    MultiIfEmpty(Multi<T> upstream) {
        this.upstream = upstream;
    }

    @CheckReturnValue
    public Multi<T> failWith(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> failWith(Supplier<? extends Throwable> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> Consumer<MultiEmitter<? super T>> createMultiFromFailureSupplier(Supplier<? extends Throwable> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> fail() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> switchToEmitter(Consumer<MultiEmitter<? super T>> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> switchTo(Flow.Publisher<? extends T> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> switchTo(Supplier<Flow.Publisher<? extends T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SafeVarargs
    @CheckReturnValue
    public final Multi<T> continueWith(T... items) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> continueWith(Iterable<T> items) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> continueWith(Supplier<? extends Iterable<? extends T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> Flow.Publisher<? extends T> createMultiFromIterableSupplier(Supplier<? extends Iterable<? extends T>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

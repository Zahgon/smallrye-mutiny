package io.smallrye.mutiny.operators.multi.builders;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;

import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.BackPressureStrategy;
import io.smallrye.mutiny.subscription.MultiEmitter;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public final class EmitterBasedMulti<T> extends AbstractMulti<T> {

    public static final int HINT = 16;

    private final Consumer<MultiEmitter<? super T>> consumer;

    private final BackPressureStrategy backpressure;

    private final int overflowBufferSize;

    public EmitterBasedMulti(Consumer<MultiEmitter<? super T>> consumer, BackPressureStrategy backpressure) {
        this(consumer, backpressure, -1);
    }

    public EmitterBasedMulti(Consumer<MultiEmitter<? super T>> consumer, BackPressureStrategy backpressure,
            int overflowBufferSize) {
        this.consumer = consumer;
        this.backpressure = backpressure;
        this.overflowBufferSize = overflowBufferSize;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class IgnoreBackPressureMultiEmitter<T> extends BaseMultiEmitter<T> {

        IgnoreBackPressureMultiEmitter(MultiSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        public MultiEmitter<T> emit(T item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    abstract static class NoOverflowBaseMultiEmitter<T> extends BaseMultiEmitter<T> {

        NoOverflowBaseMultiEmitter(MultiSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        public final MultiEmitter<T> emit(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        abstract void onOverflow();
    }

    static final class DropItemOnOverflowMultiEmitter<T> extends NoOverflowBaseMultiEmitter<T> {

        DropItemOnOverflowMultiEmitter(MultiSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        void onOverflow() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static final class ErrorOnOverflowMultiEmitter<T> extends NoOverflowBaseMultiEmitter<T> {

        ErrorOnOverflowMultiEmitter(MultiSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        void onOverflow() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static final class DropLatestOnOverflowMultiEmitter<T> extends BaseMultiEmitter<T> {

        private final AtomicReference<T> queue = new AtomicReference<>();

        private Throwable failure;

        private volatile boolean done;

        private final AtomicInteger wip = new AtomicInteger();

        DropLatestOnOverflowMultiEmitter(MultiSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        public MultiEmitter<T> emit(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void failed(Throwable e) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void completion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        void onRequested() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        void onUnsubscribed() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void drain() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

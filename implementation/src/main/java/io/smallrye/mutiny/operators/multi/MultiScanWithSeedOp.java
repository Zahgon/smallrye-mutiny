package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;
import io.smallrye.mutiny.subscription.SwitchableSubscriptionSubscriber;

public final class MultiScanWithSeedOp<T, R> extends AbstractMultiOperator<T, R> {

    private final BiFunction<R, ? super T, R> accumulator;

    private final Supplier<R> seed;

    public MultiScanWithSeedOp(Multi<? extends T> upstream, Supplier<R> seed, BiFunction<R, ? super T, R> accumulator) {
        super(upstream);
        this.seed = seed;
        this.accumulator = accumulator;
    }

    @Override
    public void subscribe(MultiSubscriber<? super R> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class ScanSubscriber<T, R> extends SwitchableSubscriptionSubscriber<R> {

        private final Multi<? extends T> upstream;

        private final Supplier<R> initialSupplier;

        private final BiFunction<R, ? super T, R> accumulator;

        private final AtomicInteger wip = new AtomicInteger();

        long produced;

        private ScanSeedProcessor<T, R> subscriber;

        ScanSubscriber(Multi<? extends T> upstream, MultiSubscriber<? super R> downstream,
                BiFunction<R, ? super T, R> accumulator, Supplier<R> seed) {
            super(downstream);
            this.upstream = upstream;
            this.accumulator = accumulator;
            this.initialSupplier = seed;
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(R r) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class ScanSeedProcessor<T, R> extends MultiOperatorProcessor<T, R> {

        private final BiFunction<R, ? super T, R> accumulator;

        R current;

        ScanSeedProcessor(MultiSubscriber<? super R> downstream, BiFunction<R, ? super T, R> accumulator, R initial) {
            super(downstream);
            this.accumulator = accumulator;
            this.current = initial;
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

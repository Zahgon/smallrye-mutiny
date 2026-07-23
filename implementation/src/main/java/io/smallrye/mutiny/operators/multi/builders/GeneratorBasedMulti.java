package io.smallrye.mutiny.operators.multi.builders;

import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import io.smallrye.mutiny.groups.GeneratorEmitter;
import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class GeneratorBasedMulti<T, S> extends AbstractMulti<T> {

    private final Supplier<S> initialStateSupplier;

    private final BiFunction<S, GeneratorEmitter<? super T>, S> generator;

    public GeneratorBasedMulti(Supplier<S> initialStateSupplier, BiFunction<S, GeneratorEmitter<? super T>, S> generator) {
        this.initialStateSupplier = initialStateSupplier;
        this.generator = generator;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class GeneratorSubscription implements Flow.Subscription, GeneratorEmitter<T> {

        private final MultiSubscriber<? super T> downstream;

        private S state;

        protected volatile boolean cancelled;

        protected final AtomicLong requested = new AtomicLong();

        GeneratorSubscription(MultiSubscriber<? super T> downstream, S state) {
            this.downstream = downstream;
            this.state = state;
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void doGenerate() {
            try {
                this.state = generator.apply(this.state, this);
            } catch (Throwable failure) {
                this.fail(failure);
            }
        }

        private void generateAll() {
            while (!cancelled) {
                doGenerate();
            }
        }

        private void generateSome(long n) {
            long emitted = 0L;
            long upperBound = n;
            for (;;) {
                if (cancelled) {
                    return;
                }
                while (!cancelled && emitted != upperBound) {
                    doGenerate();
                    emitted++;
                    if (cancelled) {
                        return;
                    }
                }
                if (emitted == upperBound) {
                    upperBound = requested.addAndGet(-emitted);
                    if (upperBound == 0L) {
                        return;
                    }
                    emitted = 0L;
                }
            }
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void emit(T item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void fail(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void complete() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

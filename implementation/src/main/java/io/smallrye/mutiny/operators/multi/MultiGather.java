package io.smallrye.mutiny.operators.multi;

import java.util.Optional;
import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.groups.Gatherer;
import io.smallrye.mutiny.groups.Gatherer.Extraction;
import io.smallrye.mutiny.helpers.Subscriptions;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiGather<I, ACC, O> extends AbstractMultiOperator<I, O> {

    private final Gatherer<I, ACC, O> gatherer;

    public MultiGather(Multi<? extends I> upstream, Gatherer<I, ACC, O> gatherer) {
        super(upstream);
        this.gatherer = gatherer;
    }

    @Override
    public void subscribe(MultiSubscriber<? super O> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class MultiGatherProcessor extends MultiOperatorProcessor<I, O> {

        private ACC acc;

        private final AtomicLong demand = new AtomicLong();

        private volatile boolean upstreamHasCompleted;

        private final AtomicInteger drainWip = new AtomicInteger();

        public MultiGatherProcessor(MultiSubscriber<? super O> downstream) {
            super(downstream);
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void request(long numberOfItems) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(I item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void drainRemainingElements() {
            if (drainWip.getAndIncrement() > 0) {
                return;
            }
            while (true) {
                long pending = demand.get();
                long emitted = 0L;
                while (emitted < pending) {
                    if (upstream == Subscriptions.CANCELLED) {
                        return;
                    }
                    try {
                        Optional<Extraction<ACC, O>> mapping = gatherer.extract(acc, true);
                        if (mapping == null) {
                            throw new NullPointerException("The extractor returned a null value");
                        }
                        if (mapping.isPresent()) {
                            Extraction<ACC, O> result = mapping.get();
                            acc = result.nextAccumulator();
                            O value = result.nextItem();
                            if (acc == null) {
                                throw new NullPointerException("The extractor returned a null accumulator value");
                            }
                            if (value == null) {
                                throw new NullPointerException("The extractor returned a null value to emit");
                            }
                            downstream.onItem(value);
                            emitted = emitted + 1L;
                        } else {
                            Optional<O> finalValue = gatherer.finalize(acc);
                            if (finalValue == null) {
                                throw new NullPointerException("The finalizer returned a null value");
                            }
                            this.upstream = Subscriptions.CANCELLED;
                            finalValue.ifPresent(o -> downstream.onItem(o));
                            downstream.onCompletion();
                            return;
                        }
                    } catch (Throwable err) {
                        onFailure(err);
                        return;
                    }
                }
                demand.addAndGet(-emitted);
                if (drainWip.decrementAndGet() == 0) {
                    return;
                }
            }
        }
    }
}

package io.smallrye.mutiny.operators.uni;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Function;
import java.util.stream.Collectors;

import io.smallrye.mutiny.CompositeException;
import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.UniOperator;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

public class UniAndCombination<I, O> extends UniOperator<I, O> {

    private static final Object SENTINEL = new Object();

    private final Function<List<?>, O> combinator;

    private final List<Uni<?>> unis;

    private final boolean collectAllFailureBeforeFiring;

    private final int concurrency;

    public UniAndCombination(Uni<? extends I> upstream, List<? extends Uni<?>> others, Function<List<?>, O> combinator,
            boolean collectAllFailureBeforeFiring, int concurrency) {
        super(upstream);
        this.concurrency = concurrency;
        this.unis = new ArrayList<>();
        // upstream can be null when using the all (static) operator.
        if (upstream != null) {
            this.unis.add(upstream);
        }
        this.unis.addAll(others);
        this.combinator = combinator;
        this.collectAllFailureBeforeFiring = collectAllFailureBeforeFiring;
    }

    @Override
    public void subscribe(UniSubscriber<? super O> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class AndSupervisor implements UniSubscription {

        private final List<UniHandler> handlers = new ArrayList<>();

        private final UniSubscriber<? super O> subscriber;

        final AtomicBoolean cancelled = new AtomicBoolean();

        final AtomicInteger nextIndex = new AtomicInteger();

        final AtomicInteger wip = new AtomicInteger();

        AndSupervisor(UniSubscriber<? super O> sub) {
            subscriber = sub;
            Context context = subscriber.context();
            for (Uni<?> uni : unis) {
                UniHandler result = new UniHandler(this, uni, context);
                handlers.add(result);
            }
        }

        private void run() {
            int upperBound;
            if (concurrency == -1) {
                upperBound = handlers.size();
            } else {
                upperBound = Math.min(handlers.size(), concurrency);
                nextIndex.set(upperBound);
            }
            for (int i = 0; i < upperBound; i++) {
                if (cancelled.get()) {
                    break;
                }
                handlers.get(i).subscribe();
            }
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void check() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void computeAndFireTheOutcome(List<Throwable> failures, List<Object> items) {
            if (failures.isEmpty()) {
                O aggregated;
                try {
                    aggregated = combinator.apply(items);
                } catch (Throwable e) {
                    subscriber.onFailure(e);
                    return;
                }
                subscriber.onItem(aggregated);
            } else if (failures.size() == 1) {
                // If we had a single failure, fire it without the CompositeException envelope.
                subscriber.onFailure(failures.get(0));
            } else {
                subscriber.onFailure(new CompositeException(failures));
            }
        }

        private List<Object> getItems() {
            return this.handlers.stream().map(u -> u.item).collect(Collectors.toList());
        }

        private List<Throwable> getFailures() {
            return handlers.stream().filter(u -> u.failure != null).map(u -> u.failure).collect(Collectors.toList());
        }
    }

    private class UniHandler implements UniSubscription, UniSubscriber {

        final AndSupervisor supervisor;

        final Uni<?> uni;

        final Context context;

        volatile UniSubscription subscription;

        Object item = SENTINEL;

        Throwable failure;

        private static final AtomicReferenceFieldUpdater<UniAndCombination.UniHandler, UniSubscription> SUBSCRIPTION_UPDATER = AtomicReferenceFieldUpdater
                .newUpdater(UniAndCombination.UniHandler.class, UniSubscription.class, "subscription");

        UniHandler(AndSupervisor supervisor, Uni<?> observed, Context context) {
            this.supervisor = supervisor;
            this.uni = observed;
            this.context = context;
        }

        @Override
        public Context context() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public final void onSubscribe(UniSubscription sub) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public final void onFailure(Throwable t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public final void onItem(Object x) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings("unchecked")
        public void subscribe() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

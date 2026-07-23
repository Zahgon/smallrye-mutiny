package io.smallrye.mutiny.operators.multi.split;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * Splits a {@link Multi} into several co-operating {@link Multi}.
 * <p>
 * Each split {@link Multi} receives items based on a function that maps each item to a key from an enumeration.
 * <p>
 * The demand of each split {@link Multi} is independent.
 * Items flow when all keys from the enumeration have a split subscriber, and until either one of the split has a {@code 0}
 * demand,
 * or when one of the split subscriber cancels.
 * The flow resumes when all keys have a subscriber again, and when the demand for each split is strictly positive.
 * <p>
 * Calls to {@link #get(Enum)} result in new {@link Multi} objects, but given a key {@code K} then there can be only one
 * active subscription. If there is already a subscriber for {@code K} then any subscription request to a {@link Multi} for key
 * {@code K} results in a terminal failure.
 * Note that when a subscriber for {@code K} has cancelled then a request to subscribe for a {@link Multi} for {@code K} can
 * succeed.
 * <p>
 * If the upstream {@link Multi} has already completed or failed, then any new subscriber will receive the terminal signal
 * (see {@link MultiSubscriber#onCompletion()} and {@link MultiSubscriber#onFailure(Throwable)}).
 * <p>
 * Note on {@link Context} support: it is assumed that all split subscribers share the same {@link Context} instance, if any.
 * The {@link Context} is passed to the upstream {@link Multi} when the first split subscription happens.
 * When disjoint {@link Context} are in use by the different split subscribers then the behavior of your code will be most
 * likely incorrect.
 *
 * @param <T> the items type
 * @param <K> the enumeration type
 */
public class MultiSplitter<T, K extends Enum<K>> {

    private final Multi<? extends T> upstream;

    private final Function<T, K> splitter;

    private final ConcurrentHashMap<K, SplitMulti.Split> splits;

    private final int requiredNumberOfSubscribers;

    private final Class<K> keyType;

    public MultiSplitter(Multi<? extends T> upstream, Class<K> keyType, Function<T, K> splitter) {
        this.upstream = nonNull(upstream, "upstream");
        if (!nonNull(keyType, "keyType").isEnum()) {
            // Note: the Java compiler enforces a type check on keyType being some enum, so this branch is only here for added peace of mind
            throw new IllegalArgumentException("The key type must be that of an enumeration");
        }
        this.keyType = keyType;
        this.splitter = nonNull(splitter, "splitter");
        this.splits = new ConcurrentHashMap<>();
        this.requiredNumberOfSubscribers = keyType.getEnumConstants().length;
    }

    @CheckReturnValue
    public Multi<T> get(K key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Class<K> keyType() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private enum State {

        INIT,
        AWAITING_SUBSCRIPTION,
        SUBSCRIBED,
        COMPLETED,
        FAILED
    }

    private final AtomicReference<State> state = new AtomicReference<>(State.INIT);

    private volatile Throwable terminalFailure;

    private Flow.Subscription upstreamSubscription;

    // At most one upstream request is in flight at a time
    private final AtomicBoolean upstreamRequestInFlight = new AtomicBoolean();

    private void onSplitRequest() {
        if (state.get() != State.SUBSCRIBED || splits.size() < requiredNumberOfSubscribers) {
            return;
        }
        for (SplitMulti.Split split : splits.values()) {
            if (split.demand.get() == 0L) {
                return;
            }
        }
        if (upstreamRequestInFlight.compareAndSet(false, true)) {
            upstreamSubscription.request(1L);
        }
    }

    private void onUpstreamFailure() {
        for (SplitMulti.Split split : splits.values()) {
            split.downstream.onFailure(terminalFailure);
        }
        splits.clear();
    }

    private void onUpstreamCompletion() {
        for (SplitMulti.Split split : splits.values()) {
            split.downstream.onCompletion();
        }
        splits.clear();
    }

    private void onUpstreamItem(T item) {
        try {
            K key = splitter.apply(item);
            if (key == null) {
                throw new NullPointerException("The splitter function returned null");
            }
            // An item routed to a branch with no demand is discarded rather than delivered without demand
            SplitMulti.Split target = splits.get(key);
            if (target != null && claimDemand(target.demand)) {
                target.downstream.onItem(item);
            }
            upstreamRequestInFlight.set(false);
            onSplitRequest();
        } catch (Throwable err) {
            terminalFailure = err;
            state.set(State.FAILED);
            onUpstreamFailure();
        }
    }

    // Decrements demand by one, leaving an unbounded (Long.MAX_VALUE) demand untouched.
    // Returns false when there is no demand to claim.
    private static boolean claimDemand(AtomicLong demand) {
        for (;;) {
            long current = demand.get();
            if (current <= 0L) {
                return false;
            }
            if (current == Long.MAX_VALUE) {
                return true;
            }
            if (demand.compareAndSet(current, current - 1L)) {
                return true;
            }
        }
    }

    // Note: we need a subscriber class because another onCompletion definition exists in Multi
    private class Forwarder implements MultiSubscriber<T>, ContextSupport {

        private final Context context;

        private Forwarder(MultiSubscriber<? super T> firstSubscriber) {
            if (firstSubscriber instanceof ContextSupport) {
                context = ((ContextSupport) firstSubscriber).context();
            } else {
                context = Context.empty();
            }
        }

        @Override
        public void onItem(T item) {
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
        public void onSubscribe(Flow.Subscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Context context() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private class SplitMulti extends AbstractMulti<T> {

        private final K key;

        private SplitMulti(K key) {
            this.key = key;
        }

        @Override
        public void subscribe(MultiSubscriber<? super T> subscriber) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private class Split implements Flow.Subscription {

            MultiSubscriber<? super T> downstream;

            AtomicLong demand = new AtomicLong();

            private Split(MultiSubscriber<? super T> subscriber) {
                this.downstream = subscriber;
            }

            @Override
            public void request(long n) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            @Override
            public void cancel() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }
}

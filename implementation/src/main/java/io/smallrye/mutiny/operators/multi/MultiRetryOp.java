package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

import io.smallrye.mutiny.CompositeException;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;
import io.smallrye.mutiny.subscription.SwitchableSubscriptionSubscriber;

/**
 * Multi operator re-subscribing to the upstream if it receives a failure event.
 * It can re-subscribe indefinitely (passing Long.MAX_VALUE as number of attempts) or a fixed number of times.
 *
 * @param <T> the type of item
 */
public final class MultiRetryOp<T> extends AbstractMultiOperator<T, T> {

    private final long times;

    private final Predicate<? super Throwable> onFailurePredicate;

    public MultiRetryOp(Multi<? extends T> upstream, Predicate<? super Throwable> onFailurePredicate, long times) {
        super(upstream);
        this.onFailurePredicate = onFailurePredicate;
        this.times = times;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class RetrySubscriber<T> extends SwitchableSubscriptionSubscriber<T> {

        private final Flow.Publisher<? extends T> upstream;

        private final AtomicInteger wip = new AtomicInteger();

        private long remaining;

        long produced;

        private final Predicate<? super Throwable> onFailurePredicate;

        RetrySubscriber(Flow.Publisher<? extends T> upstream, Predicate<? super Throwable> onFailurePredicate,
                MultiSubscriber<? super T> downstream, long attempts) {
            super(downstream);
            this.upstream = upstream;
            this.remaining = attempts;
            this.onFailurePredicate = onFailurePredicate;
        }

        @Override
        public void onItem(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private boolean testOnFailurePredicate(Throwable t) {
            // The onFailurePredicate cannot be null.
            try {
                if (!onFailurePredicate.test(t)) {
                    cancel();
                    downstream.onFailure(t);
                    return true;
                }
            } catch (Throwable e) {
                cancel();
                downstream.onFailure(new CompositeException(e, t));
                return true;
            }
            return false;
        }

        void resubscribe() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

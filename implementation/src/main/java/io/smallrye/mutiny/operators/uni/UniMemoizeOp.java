package io.smallrye.mutiny.operators.uni;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BooleanSupplier;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.UniOperator;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

public class UniMemoizeOp<I> extends UniOperator<I, I> implements UniSubscriber<I>, ContextSupport {

    private record FailureHolder(Throwable failure) {
    }

    private UniSubscription currentUpstreamSubscription;

    private Context currentContext = Context.empty();

    private enum State {

        INIT,
        WAITING_FOR_UPSTREAM,
        CACHING
    }

    private final BooleanSupplier invalidationRequested;

    private State state = State.INIT;

    private final ReentrantLock internalLock = new ReentrantLock();

    private final List<UniSubscriber<? super I>> awaiters = new ArrayList<>();

    private Object cachedResult = null;

    public UniMemoizeOp(Uni<? extends I> upstream) {
        this(upstream, () -> false);
    }

    public UniMemoizeOp(Uni<? extends I> upstream, BooleanSupplier invalidationRequested) {
        super(nonNull(upstream, "upstream"));
        this.invalidationRequested = invalidationRequested;
    }

    @Override
    public void subscribe(UniSubscriber<? super I> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void checkForInvalidation() {
        if (invalidationRequested.getAsBoolean()) {
            state = State.INIT;
            if (currentUpstreamSubscription != null) {
                currentUpstreamSubscription.cancel();
                currentUpstreamSubscription = null;
            }
        }
    }

    @Override
    public void onSubscribe(UniSubscription subscription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onItem(I item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private List<UniSubscriber<? super I>> gatherAwaiters() {
        ArrayList<UniSubscriber<? super I>> copy = new ArrayList<>(awaiters);
        awaiters.clear();
        return copy;
    }

    private void notifyAwaiters(List<UniSubscriber<? super I>> toNotify, Object result) {
        Iterator<UniSubscriber<? super I>> iterator = toNotify.iterator();
        while (iterator.hasNext()) {
            UniSubscriber<? super I> awaiter = iterator.next();
            forwardTo(awaiter, result);
            iterator.remove();
        }
    }

    @Override
    public void onFailure(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    private void forwardTo(UniSubscriber<? super I> subscriber, Object result) {
        if (result instanceof FailureHolder holder) {
            subscriber.onFailure(holder.failure());
        } else {
            subscriber.onItem((I) result);
        }
    }

    @Override
    public Context context() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class MemoizedSubscription implements UniSubscription {

        private final UniSubscriber<? super I> subscriber;

        MemoizedSubscription(UniSubscriber<? super I> subscriber) {
            this.subscriber = subscriber;
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;

import io.smallrye.mutiny.CompositeException;
import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.Subscriptions;
import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.operators.multi.processors.UnicastProcessor;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.MultiSubscriber;
import io.smallrye.mutiny.subscription.SerializedSubscriber;
import io.smallrye.mutiny.subscription.SwitchableSubscriptionSubscriber;

/**
 * Retries a source when a companion stream signals an item in response to the main's failure event.
 * <p>
 * If the companion stream signals when the main source is active, the repeat
 * attempt is suppressed and any terminal signal will terminate the main source with the same signal immediately.
 *
 * @param <T> the type of item
 */
public final class MultiRetryWhenOp<T> extends AbstractMultiOperator<T, T> {

    private final Function<? super Multi<Throwable>, ? extends Publisher<?>> triggerStreamFactory;

    private final Predicate<? super Throwable> onFailurePredicate;

    public MultiRetryWhenOp(Multi<? extends T> upstream, Predicate<? super Throwable> onFailurePredicate,
            Function<? super Multi<Throwable>, ? extends Publisher<?>> triggerStreamFactory) {
        super(upstream);
        this.onFailurePredicate = onFailurePredicate;
        this.triggerStreamFactory = triggerStreamFactory;
    }

    private static <T> void subscribe(MultiSubscriber<? super T> downstream, Predicate<? super Throwable> onFailurePredicate,
            Function<? super Multi<Throwable>, ? extends Publisher<?>> triggerStreamFactory, Multi<? extends T> upstream) {
        Context context;
        if (downstream instanceof ContextSupport provider) {
            context = provider.context();
        } else {
            context = Context.empty();
        }
        TriggerSubscriber other = new TriggerSubscriber(context);
        Subscriber<Throwable> signaller = new SerializedSubscriber<>(other.processor);
        signaller.onSubscribe(Subscriptions.empty());
        MultiSubscriber<T> serialized = new SerializedSubscriber<>(downstream);
        RetryWhenOperator<T> operator = new RetryWhenOperator<>(upstream, onFailurePredicate, serialized, signaller);
        other.operator = operator;
        serialized.onSubscribe(operator);
        Publisher<?> publisher;
        try {
            publisher = triggerStreamFactory.apply(other);
            if (publisher == null) {
                throw new NullPointerException("The stream factory returned `null`");
            }
        } catch (Throwable e) {
            downstream.onFailure(e);
            return;
        }
        publisher.subscribe(other);
        if (!operator.isCancelled()) {
            upstream.subscribe(operator);
        }
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class RetryWhenOperator<T> extends SwitchableSubscriptionSubscriber<T> {

        private final Publisher<? extends T> upstream;

        private final AtomicInteger wip = new AtomicInteger();

        private final Subscriber<Throwable> signaller;

        private final Subscriptions.DeferredSubscription arbiter = new Subscriptions.DeferredSubscription();

        private final Predicate<? super Throwable> onFailurePredicate;

        long produced;

        RetryWhenOperator(Publisher<? extends T> upstream, Predicate<? super Throwable> onFailurePredicate,
                MultiSubscriber<? super T> downstream, Subscriber<Throwable> signaller) {
            super(downstream);
            this.onFailurePredicate = onFailurePredicate;
            this.upstream = upstream;
            this.signaller = signaller;
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void setWhen(Flow.Subscription w) {
            throw new UnsupportedOperationException("STUB: not implemented");
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
            try {
                if (!onFailurePredicate.test(t)) {
                    arbiter.cancel();
                    downstream.onFailure(t);
                }
            } catch (Throwable e) {
                arbiter.cancel();
                downstream.onFailure(new CompositeException(e, t));
                return true;
            }
            return false;
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void resubscribe() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void whenFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void whenComplete() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @SuppressWarnings({ "SubscriberImplementation" })
    static final class TriggerSubscriber extends AbstractMulti<Throwable>
            implements Multi<Throwable>, Subscriber<Object>, ContextSupport {

        RetryWhenOperator<?> operator;

        private final Flow.Processor<Throwable, Throwable> processor = UnicastProcessor.<Throwable> create().serialized();

        private final Context context;

        TriggerSubscriber(Context context) {
            this.context = context;
        }

        @Override
        public void onSubscribe(Flow.Subscription s) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onNext(Object t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onError(Throwable t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onComplete() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void subscribe(Subscriber<? super Throwable> actual) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Context context() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

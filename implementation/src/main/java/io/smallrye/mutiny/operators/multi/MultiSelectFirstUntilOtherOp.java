package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicReference;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.MultiSubscriber;
import io.smallrye.mutiny.subscription.SerializedSubscriber;

/**
 * Emits items from upstream until another Publisher signals an event (items, failures or completion).
 * Once this signal is received, the subscription to upstream is cancelled.
 *
 * @param <T> the type of item from upstream
 * @param <U> the type of item from the other publisher
 */
public final class MultiSelectFirstUntilOtherOp<T, U> extends AbstractMultiOperator<T, T> {

    private final Publisher<U> other;

    public MultiSelectFirstUntilOtherOp(Multi<? extends T> upstream, Publisher<U> other) {
        super(upstream);
        this.other = ParameterValidation.nonNull(other, "other");
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> actual) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static final class TakeUntilOtherSubscriber<U> implements MultiSubscriber<U>, ContextSupport {

        final TakeUntilMainProcessor<?> main;

        boolean once;

        public TakeUntilOtherSubscriber(TakeUntilMainProcessor<?> main) {
            this.main = main;
        }

        @Override
        public void onSubscribe(Subscription s) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(U t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public Context context() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static final class TakeUntilMainProcessor<T> extends MultiOperatorProcessor<T, T> {

        private final AtomicReference<Subscription> other = new AtomicReference<>();

        public TakeUntilMainProcessor(Flow.Subscriber<? super T> downstream) {
            super(new SerializedSubscriber<>(downstream));
        }

        void setOtherSubscription(Subscription s) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void onOtherFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void onOtherCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

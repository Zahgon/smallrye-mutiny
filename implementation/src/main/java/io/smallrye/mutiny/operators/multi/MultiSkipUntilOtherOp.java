package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.MultiSubscriber;
import io.smallrye.mutiny.subscription.SerializedSubscriber;

/**
 * Skips items emitted by the upstream until the other publisher emits either an item or completes.
 *
 * @param <T> the type of items emitted by the upstream (and propagated downstream)
 * @param <U> the type of items emitted by the other publisher
 */
public final class MultiSkipUntilOtherOp<T, U> extends AbstractMultiOperator<T, T> {

    private final Publisher<U> other;

    public MultiSkipUntilOtherOp(Multi<? extends T> upstream, Publisher<U> other) {
        super(upstream);
        this.other = ParameterValidation.nonNull(other, "other");
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> actual) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("SubscriberImplementation")
    static final class OtherStreamTracker<U> implements MultiSubscriber<U>, ContextSupport {

        private final SkipUntilMainProcessor<?> main;

        OtherStreamTracker(SkipUntilMainProcessor<?> main) {
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

    static final class SkipUntilMainProcessor<T> extends MultiOperatorProcessor<T, T> {

        private final AtomicReference<Subscription> other = new AtomicReference<>();

        private final AtomicBoolean gate = new AtomicBoolean(false);

        SkipUntilMainProcessor(Subscriber<? super T> downstream) {
            super(new SerializedSubscriber<>(downstream));
        }

        void open() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        boolean isOpened() {
            throw new UnsupportedOperationException("STUB: not implemented");
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
        public void onFailure(Throwable t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

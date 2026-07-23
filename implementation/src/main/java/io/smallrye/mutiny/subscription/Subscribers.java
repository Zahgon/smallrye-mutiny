package io.smallrye.mutiny.subscription;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Consumer;

import io.smallrye.mutiny.Context;

public class Subscribers {

    @SuppressWarnings("ThrowableNotThrown")
    public static final Consumer<? super Throwable> NO_ON_FAILURE = failure -> new Exception(
            "Missing onFailure/onError handler in the subscriber", failure).// NOSONAR
            printStackTrace();

    public static <T> CancellableSubscriber<T> from(Context context, Consumer<? super T> onItem,
            Consumer<? super Throwable> onFailure, Runnable onCompletion, Consumer<? super Subscription> onSubscription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static class CallbackBasedSubscriber<T> implements CancellableSubscriber<T>, Subscription, ContextSupport {

        private volatile Subscription subscription;

        private static final AtomicReferenceFieldUpdater<CallbackBasedSubscriber, Subscription> SUBSCRIPTION_UPDATER = AtomicReferenceFieldUpdater
                .newUpdater(CallbackBasedSubscriber.class, Subscription.class, "subscription");

        private final Context context;

        private final Consumer<? super T> onItem;

        private final Consumer<? super Throwable> onFailure;

        private final Runnable onCompletion;

        private final Consumer<? super Subscription> onSubscription;

        public CallbackBasedSubscriber(Context context, Consumer<? super T> onItem, Consumer<? super Throwable> onFailure,
                Runnable onCompletion, Consumer<? super Subscription> onSubscription) {
            this.context = context;
            this.onItem = nonNull(onItem, "onItem");
            this.onFailure = onFailure;
            this.onCompletion = onCompletion;
            this.onSubscription = nonNull(onSubscription, "onSubscription");
        }

        @Override
        public Context context() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onSubscribe(Subscription s) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T item) {
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
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

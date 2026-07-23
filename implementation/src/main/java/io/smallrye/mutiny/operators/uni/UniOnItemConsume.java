package io.smallrye.mutiny.operators.uni;

import java.util.function.Consumer;
import java.util.function.Predicate;

import io.smallrye.mutiny.CompositeException;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.UniOperator;
import io.smallrye.mutiny.subscription.UniSubscriber;

public class UniOnItemConsume<T, E> extends UniOperator<T, T> {

    private final Consumer<? super T> onItemCallback;

    private final Consumer<E> onFailureCallback;

    private final Predicate<? super Throwable> onFailurePredicate;

    private final Class<E> throwableType;

    public UniOnItemConsume(Uni<? extends T> upstream, Consumer<? super T> onItemCallback, Consumer<E> onFailureCallback,
            Predicate<? super Throwable> predicate, Class<E> throwableType) {
        super(upstream);
        this.onItemCallback = onItemCallback;
        this.onFailureCallback = onFailureCallback;
        this.onFailurePredicate = predicate;
        this.throwableType = throwableType;
    }

    @Override
    public void subscribe(UniSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class UniOnItemComsumeProcessor extends UniOperatorProcessor<T, T> {

        public UniOnItemComsumeProcessor(UniSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        public void onItem(T item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private <E> boolean invokeEventHandler(Consumer<? super E> handler, E event, boolean wasCalledByOnFailure,
                UniSubscriber<? super T> subscriber) {
            if (handler != null) {
                try {
                    handler.accept(event);
                } catch (Throwable e) {
                    if (wasCalledByOnFailure) {
                        subscriber.onFailure(new CompositeException((Throwable) event, e));
                    } else {
                        subscriber.onFailure(e);
                    }
                    return false;
                }
            }
            return true;
        }
    }
}

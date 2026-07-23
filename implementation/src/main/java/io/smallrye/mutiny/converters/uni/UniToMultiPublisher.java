package io.smallrye.mutiny.converters.uni;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

public final class UniToMultiPublisher<T> implements Flow.Publisher<T> {

    private final Uni<T> uni;

    public UniToMultiPublisher(Uni<T> uni) {
        this.uni = uni;
    }

    @Override
    public void subscribe(Subscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class UniToMultiSubscription<T> implements UniSubscription, Subscription, UniSubscriber<T>, ContextSupport {

        private final Uni<T> uni;

        private final Subscriber<? super T> downstream;

        enum State {

            INIT,
            UNI_REQUESTED,
            DONE
        }

        private volatile UniSubscription upstream;

        private volatile State state = State.INIT;

        private static final AtomicReferenceFieldUpdater<UniToMultiSubscription, State> STATE_UPDATER = AtomicReferenceFieldUpdater
                .newUpdater(UniToMultiSubscription.class, State.class, "state");

        private UniToMultiSubscription(Uni<T> uni, Subscriber<? super T> downstream) {
            this.uni = uni;
            this.downstream = downstream;
        }

        @Override
        public Context context() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onSubscribe(UniSubscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

package io.smallrye.mutiny.operators.uni.builders;

import java.util.concurrent.CompletionException;
import java.util.concurrent.CompletionStage;
import java.util.function.Supplier;

import io.smallrye.mutiny.operators.AbstractUni;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

public class UniCreateFromCompletionStage<T> extends AbstractUni<T> {

    private final Supplier<? extends CompletionStage<? extends T>> supplier;

    public UniCreateFromCompletionStage(Supplier<? extends CompletionStage<? extends T>> supplier) {
        // Already checked
        this.supplier = supplier;
    }

    @Override
    public void subscribe(UniSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class CompletionStageUniSubscription<T> implements UniSubscription {

        private final UniSubscriber<? super T> subscriber;

        private final CompletionStage<? extends T> stage;

        private volatile boolean cancelled = false;

        CompletionStageUniSubscription(UniSubscriber<? super T> subscriber, CompletionStage<? extends T> stage) {
            this.subscriber = subscriber;
            this.stage = stage;
        }

        public void forward() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void forwardResult(T res, Throwable fail) {
            if (!cancelled) {
                if (fail != null) {
                    if (fail instanceof CompletionException) {
                        subscriber.onFailure(fail.getCause());
                    } else {
                        subscriber.onFailure(fail);
                    }
                } else {
                    subscriber.onItem(res);
                }
            }
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

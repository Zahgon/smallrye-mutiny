package io.smallrye.mutiny.operators.uni;

import java.util.function.Consumer;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.UniOperator;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

public class UniOnSubscribeInvoke<T> extends UniOperator<T, T> {

    private final Consumer<? super UniSubscription> callback;

    public UniOnSubscribeInvoke(Uni<? extends T> upstream, Consumer<? super UniSubscription> callback) {
        super(upstream);
        this.callback = callback;
    }

    @Override
    public void subscribe(UniSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class UniOnSubscribeInvokeProcessor extends UniOperatorProcessor<T, T> {

        public UniOnSubscribeInvokeProcessor(UniSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        public void onSubscribe(UniSubscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

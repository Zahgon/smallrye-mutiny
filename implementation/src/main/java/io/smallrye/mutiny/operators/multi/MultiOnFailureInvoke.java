package io.smallrye.mutiny.operators.multi;

import java.util.function.Consumer;
import java.util.function.Predicate;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiOnFailureInvoke<T> extends AbstractMultiOperator<T, T> {

    private final Consumer<Throwable> callback;

    private final Predicate<? super Throwable> predicate;

    public MultiOnFailureInvoke(Multi<? extends T> upstream, Consumer<Throwable> callback,
            Predicate<? super Throwable> predicate) {
        super(upstream);
        this.callback = callback;
        this.predicate = predicate;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class MultiOnFailureInvokeProcessor extends MultiOperatorProcessor<T, T> {

        public MultiOnFailureInvokeProcessor(MultiSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        public void onFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

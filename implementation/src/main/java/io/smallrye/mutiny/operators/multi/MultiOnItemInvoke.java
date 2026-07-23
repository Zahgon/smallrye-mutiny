package io.smallrye.mutiny.operators.multi;

import java.util.function.Consumer;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiOnItemInvoke<T> extends AbstractMultiOperator<T, T> {

    private final Consumer<? super T> callback;

    public MultiOnItemInvoke(Multi<? extends T> upstream, Consumer<? super T> callback) {
        super(upstream);
        this.callback = callback;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class MultiOnItemInvokeProcessor extends MultiOperatorProcessor<T, T> {

        public MultiOnItemInvokeProcessor(MultiSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        public void onItem(T item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

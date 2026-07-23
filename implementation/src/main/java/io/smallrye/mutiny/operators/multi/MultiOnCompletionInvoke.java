package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.atomic.AtomicBoolean;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiOnCompletionInvoke<T> extends AbstractMultiOperator<T, T> {

    private final Runnable action;

    public MultiOnCompletionInvoke(Multi<? extends T> upstream, Runnable action) {
        super(upstream);
        this.action = action;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class MultiOnCompletionInvokeProcessor extends MultiOperatorProcessor<T, T> {

        private final AtomicBoolean actionInvoked = new AtomicBoolean();

        public MultiOnCompletionInvokeProcessor(MultiSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

package io.smallrye.mutiny.operators.multi;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.concurrent.atomic.AtomicBoolean;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiOnCancellationInvoke<T> extends AbstractMultiOperator<T, T> {

    private final Runnable action;

    public MultiOnCancellationInvoke(Multi<? extends T> upstream, Runnable action) {
        super(nonNull(upstream, "upstream"));
        this.action = nonNull(action, "action");
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class MultiOnCancellationInvokeProcessor extends MultiOperatorProcessor<T, T> {

        private final AtomicBoolean actionInvoked = new AtomicBoolean();

        public MultiOnCancellationInvokeProcessor(MultiSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

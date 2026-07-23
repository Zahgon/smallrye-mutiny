package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiConsumer;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiOnTerminationInvoke<T> extends AbstractMultiOperator<T, T> {

    private final BiConsumer<Throwable, Boolean> callback;

    public MultiOnTerminationInvoke(Multi<? extends T> upstream, BiConsumer<Throwable, Boolean> callback) {
        super(upstream);
        this.callback = callback;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class MultiOnTerminationInvokeProcessor extends MultiOperatorProcessor<T, T> {

        private final AtomicBoolean actionInvoke = new AtomicBoolean();

        public MultiOnTerminationInvokeProcessor(MultiSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        public void onFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void execute(Throwable err, Boolean cancelled) {
            if (actionInvoke.compareAndSet(false, true)) {
                callback.accept(err, cancelled);
            }
        }
    }
}

package io.smallrye.mutiny.operators.multi;

import java.util.Objects;
import java.util.concurrent.Flow.Publisher;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;
import io.smallrye.mutiny.subscription.SwitchableSubscriptionSubscriber;

/**
 * Switches to another Multi if the upstream is empty (completes without having emitted any items).
 */
public final class MultiSwitchOnEmptyOp<T> extends AbstractMultiOperator<T, T> {

    private final Publisher<? extends T> alternative;

    public MultiSwitchOnEmptyOp(Multi<? extends T> upstream, Publisher<? extends T> alternative) {
        super(upstream);
        this.alternative = Objects.requireNonNull(alternative, "alternative");
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> actual) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class SwitchIfEmptySubscriber<T> extends SwitchableSubscriptionSubscriber<T> {

        private final Publisher<? extends T> alternative;

        boolean notEmpty;

        SwitchIfEmptySubscriber(MultiSubscriber<? super T> downstream, Publisher<? extends T> alternative) {
            super(downstream);
            this.alternative = alternative;
        }

        @Override
        public void onItem(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

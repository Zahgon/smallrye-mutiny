package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;
import java.util.function.Function;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.subscription.MultiSubscriber;
import io.smallrye.mutiny.subscription.SwitchableSubscriptionSubscriber;

public class MultiOnFailureResumeOp<T> extends AbstractMultiOperator<T, T> {

    private final Function<? super Throwable, ? extends Publisher<? extends T>> next;

    public MultiOnFailureResumeOp(Multi<? extends T> upstream,
            Function<? super Throwable, ? extends Publisher<? extends T>> next) {
        super(upstream);
        this.next = ParameterValidation.nonNull(next, "next");
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class ResumeSubscriber<T> extends SwitchableSubscriptionSubscriber<T> {

        private final Function<? super Throwable, ? extends Publisher<? extends T>> next;

        private boolean switched;

        ResumeSubscriber(MultiSubscriber<? super T> downstream,
                Function<? super Throwable, ? extends Publisher<? extends T>> next) {
            super(downstream);
            this.next = next;
        }

        @Override
        public void onSubscribe(Flow.Subscription su) {
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

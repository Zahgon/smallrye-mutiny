package io.smallrye.mutiny.operators.uni;

import static io.smallrye.mutiny.helpers.ParameterValidation.MAPPER_RETURNED_NULL;

import java.util.function.BiFunction;

import io.smallrye.mutiny.CompositeException;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.AbstractUni;
import io.smallrye.mutiny.operators.UniOperator;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

public class UniOnItemOrFailureFlatMap<I, O> extends UniOperator<I, O> {

    private final BiFunction<? super I, Throwable, Uni<? extends O>> mapper;

    public UniOnItemOrFailureFlatMap(Uni<I> upstream, BiFunction<? super I, Throwable, Uni<? extends O>> mapper) {
        super(upstream);
        this.mapper = mapper;
    }

    @Override
    public void subscribe(UniSubscriber<? super O> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private class UniOnItemOrFailureFlatMapProcessor extends UniOperatorProcessor<I, O> {

        private volatile UniSubscription innerSubscription;

        public UniOnItemOrFailureFlatMapProcessor(UniSubscriber<? super O> downstream) {
            super(downstream);
        }

        @Override
        public void onSubscribe(UniSubscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        @SuppressWarnings("unchecked")
        public void onItem(I item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @SuppressWarnings("unchecked")
        private void performInnerSubscription(I item, Throwable failure) {
            Uni<? extends O> uni;
            try {
                uni = mapper.apply(item, failure);
            } catch (Throwable err) {
                if (failure != null) {
                    downstream.onFailure(new CompositeException(failure, err));
                } else {
                    downstream.onFailure(err);
                }
                return;
            }
            if (uni == null) {
                downstream.onFailure(new NullPointerException(MAPPER_RETURNED_NULL));
                return;
            }
            // Dirty cast
            AbstractUni.subscribe(uni, (UniSubscriber) this);
        }
    }
}

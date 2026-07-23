package io.smallrye.mutiny.operators.multi;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.LongFunction;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.Cancellable;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiOnRequestCall<T> extends AbstractMultiOperator<T, T> {

    private final LongFunction<Uni<?>> mapper;

    public MultiOnRequestCall(Multi<? extends T> upstream, LongFunction<Uni<?>> mapper) {
        super(nonNull(upstream, "upstream"));
        this.mapper = nonNull(mapper, "consumer");
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class MultiOnRequestCallOperator extends MultiOperatorProcessor<T, T> {

        public MultiOnRequestCallOperator(MultiSubscriber<? super T> downstream) {
            super(downstream);
        }

        // Note that as per reactive streams specifications request and cancel calls need to happen serially
        private final AtomicReference<Cancellable> cancellable = new AtomicReference<>();

        @Override
        public void request(long numberOfItems) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private Uni<?> execute(long numberOfItems) {
            try {
                return nonNull(mapper.apply(numberOfItems), "uni");
            } catch (Throwable err) {
                return Uni.createFrom().failure(err);
            }
        }
    }
}

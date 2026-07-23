package io.smallrye.mutiny.operators.multi.overflow;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Function;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.multi.AbstractMultiOperator;
import io.smallrye.mutiny.operators.multi.MultiOperatorProcessor;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiOnOverflowDropItemsOp<T> extends AbstractMultiOperator<T, T> {

    private final Consumer<T> dropConsumer;

    private final Function<T, Uni<?>> dropUniMapper;

    public MultiOnOverflowDropItemsOp(Multi<? extends T> upstream, Consumer<T> dropConsumer,
            Function<T, Uni<?>> dropUniMapper) {
        super(upstream);
        this.dropConsumer = dropConsumer;
        this.dropUniMapper = dropUniMapper;
    }

    public MultiOnOverflowDropItemsOp(Multi<T> upstream) {
        this(upstream, null, null);
    }

    public MultiOnOverflowDropItemsOp(Multi<T> upstream, Consumer<T> dropConsumer) {
        this(upstream, dropConsumer, null);
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class MultiOnOverflowDropItemsProcessor extends MultiOperatorProcessor<T, T> {

        private final AtomicLong requested = new AtomicLong();

        MultiOnOverflowDropItemsProcessor(MultiSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void notifyOnOverflowInvoke(T item) {
            try {
                dropConsumer.accept(item);
            } catch (Throwable e) {
                super.onFailure(e);
            }
        }

        private void notifyOnOverflowCall(T item) {
            try {
                Uni<?> uni = nonNull(dropUniMapper.apply(item), "uni");
                uni.subscribe().with(context(), ignored -> {
                    // Just drop and ignore
                }, super::onFailure);
            } catch (Throwable failure) {
                super.onFailure(failure);
            }
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

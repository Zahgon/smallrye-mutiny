package io.smallrye.mutiny.operators.multi.overflow;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.function.Function;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.multi.AbstractMultiOperator;
import io.smallrye.mutiny.operators.multi.MultiOperatorProcessor;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiOnOverflowKeepLastOp<T> extends AbstractMultiOperator<T, T> {

    private final Consumer<T> dropConsumer;

    private final Function<T, Uni<?>> dropUniMapper;

    public MultiOnOverflowKeepLastOp(Multi<? extends T> upstream, Consumer<T> dropConsumer, Function<T, Uni<?>> dropUniMapper) {
        super(upstream);
        this.dropConsumer = dropConsumer;
        this.dropUniMapper = dropUniMapper;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class MultiOnOverflowLatestProcessor extends MultiOperatorProcessor<T, T> {

        private final AtomicInteger wip = new AtomicInteger();

        private Throwable failure;

        private final AtomicLong requested = new AtomicLong();

        private volatile boolean done;

        private volatile boolean cancelled;

        private final AtomicReference<T> last = new AtomicReference<>();

        MultiOnOverflowLatestProcessor(MultiSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable f) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void drain() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void notifyOnOverflowInvoke(T possiblyDropped) {
            try {
                dropConsumer.accept(possiblyDropped);
            } catch (Throwable failure) {
                super.onFailure(failure);
            }
        }

        private void notifyOnOverflowCall(T possiblyDropped) {
            // Some exceptions may be dropped in cascade
            try {
                Uni<?> uni = nonNull(dropUniMapper.apply(possiblyDropped), "uni");
                uni.subscribe().with(context(), ignored -> {
                    // Nothing to do
                }, super::onFailure);
            } catch (Throwable failure) {
                super.onFailure(failure);
            }
        }

        boolean checkTerminated(boolean wasDone, boolean wasEmpty) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

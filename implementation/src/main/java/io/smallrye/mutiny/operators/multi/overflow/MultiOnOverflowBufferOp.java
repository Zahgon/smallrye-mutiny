package io.smallrye.mutiny.operators.multi.overflow;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.Queue;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Function;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.queues.Queues;
import io.smallrye.mutiny.operators.multi.AbstractMultiOperator;
import io.smallrye.mutiny.operators.multi.MultiOperatorProcessor;
import io.smallrye.mutiny.subscription.BackPressureFailure;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiOnOverflowBufferOp<T> extends AbstractMultiOperator<T, T> {

    private final int bufferSize;

    private final boolean unbounded;

    private final Consumer<T> dropConsumer;

    private final Function<T, Uni<?>> dropUniMapper;

    public MultiOnOverflowBufferOp(Multi<T> upstream, int bufferSize, boolean unbounded, Consumer<T> dropConsumer,
            Function<T, Uni<?>> dropUniMapper) {
        super(upstream);
        this.bufferSize = bufferSize;
        this.unbounded = unbounded;
        this.dropConsumer = dropConsumer;
        this.dropUniMapper = dropUniMapper;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class OnOverflowBufferProcessor extends MultiOperatorProcessor<T, T> {

        private final Queue<T> queue;

        Throwable failure;

        private final AtomicLong requested = new AtomicLong();

        private final AtomicInteger wip = new AtomicInteger();

        private final AtomicInteger strictBoundCounter = new AtomicInteger();

        volatile boolean cancelled;

        volatile boolean done;

        OnOverflowBufferProcessor(MultiSubscriber<? super T> downstream, int bufferSize, boolean unbounded) {
            super(downstream);
            this.queue = unbounded ? Queues.<T> unbounded(bufferSize).get() : Queues.createMpscArrayQueue(bufferSize);
        }

        @Override
        public void onSubscribe(Subscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void notifyOnOverflowInvoke(T t, BackPressureFailure bpf) {
            if (dropConsumer != null) {
                try {
                    dropConsumer.accept(t);
                } catch (Throwable e) {
                    bpf.addSuppressed(e);
                }
            }
            onFailure(bpf);
        }

        private void notifyOnOverflowCall(T t, BackPressureFailure bpf) {
            try {
                Uni<?> uni = nonNull(dropUniMapper.apply(t), "uni");
                uni.subscribe().with(context(), ignored -> {
                    failure = bpf;
                    done = true;
                    super.cancel();
                    drain();
                }, err -> {
                    bpf.addSuppressed(err);
                    failure = bpf;
                    done = true;
                    super.cancel();
                    drain();
                });
            } catch (Throwable err) {
                bpf.addSuppressed(err);
                failure = bpf;
                done = true;
                super.cancel();
                drain();
            }
        }

        @Override
        public void onFailure(Throwable failure) {
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

        boolean checkTerminated(boolean wasDone, boolean wasEmpty) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

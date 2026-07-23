package io.smallrye.mutiny.helpers;

import static io.smallrye.mutiny.helpers.ParameterValidation.*;

import java.util.*;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;
import java.util.stream.Stream;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.ContextSupport;

public class BlockingIterable<T> implements Iterable<T> {

    private final Multi<? extends T> upstream;

    private final Supplier<Queue<T>> supplier;

    private final int batchSize;

    private final Supplier<Context> contextSupplier;

    public BlockingIterable(Multi<? extends T> upstream, int batchSize, Supplier<Queue<T>> queueSupplier,
            Supplier<Context> contextSupplier) {
        this.upstream = nonNull(upstream, "upstream");
        this.batchSize = positive(batchSize, "batchSize");
        this.supplier = nonNull(queueSupplier, "queueSupplier");
        this.contextSupplier = nonNull(contextSupplier, "contextSupplier");
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Spliterator<T> spliterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Stream<T> stream() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private SubscriberIterator<T> create() {
        Queue<T> queue = null;
        // Create the instance of queue, check for failure and `null` values.
        try {
            queue = supplier.get();
        } catch (Throwable e) {
            propagateFailure(e);
        }
        if (queue == null) {
            throw new IllegalStateException(SUPPLIER_PRODUCED_NULL);
        }
        Context context = null;
        try {
            context = contextSupplier.get();
        } catch (Throwable e) {
            propagateFailure(e);
        }
        if (context == null) {
            throw new IllegalStateException(SUPPLIER_PRODUCED_NULL);
        }
        return new SubscriberIterator<>(queue, batchSize, context);
    }

    private static void propagateFailure(Throwable e) {
        if (e instanceof RuntimeException) {
            throw (RuntimeException) e;
        } else {
            throw new RuntimeException(e);
        }
    }

    private static final class SubscriberIterator<T> implements Subscriber<T>, Iterator<T>, ContextSupport {

        private final Queue<T> queue;

        private final int batchSize;

        private final int limit;

        private final Lock lock;

        private final Condition condition;

        private final Context context;

        long produced;

        AtomicReference<Subscription> subscription = new AtomicReference<>();

        AtomicBoolean done = new AtomicBoolean();

        Throwable failure;

        SubscriberIterator(Queue<T> queue, int batchSize, Context context) {
            this.queue = queue;
            this.batchSize = batchSize;
            this.limit = batchSize;
            this.context = context;
            this.lock = new ReentrantLock();
            this.condition = lock.newCondition();
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void fire() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void terminateAndFire() {
            terminate();
            fire();
        }

        private void terminate() {
            Subscription s = subscription.getAndSet(EmptyUniSubscription.CANCELLED);
            if (s != null) {
                s.cancel();
            }
        }

        @Override
        public Context context() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onSubscribe(Subscription s) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onNext(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onError(Throwable t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onComplete() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

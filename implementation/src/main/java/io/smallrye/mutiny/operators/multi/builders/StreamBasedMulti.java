package io.smallrye.mutiny.operators.multi.builders;

import java.util.Iterator;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;
import java.util.stream.Stream;

import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class StreamBasedMulti<T> extends AbstractMulti<T> {

    private final Supplier<? extends Stream<? extends T>> supplier;

    public StreamBasedMulti(Supplier<? extends Stream<? extends T>> supplier) {
        this.supplier = supplier;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void closeQuietly(AutoCloseable source) {
        if (source == null) {
            return;
        }
        try {
            source.close();
        } catch (Throwable ex) {
            // ignore the exception
        }
    }

    private static class StreamSubscription<T> implements Subscription {

        private final Iterator<? extends T> iterator;

        private final AutoCloseable closeable;

        private final AtomicLong requested = new AtomicLong();

        private final MultiSubscriber<T> downstream;

        private volatile boolean cancelled;

        StreamSubscription(MultiSubscriber<T> downstream, Iterator<? extends T> iterator, AutoCloseable closeable) {
            this.iterator = iterator;
            this.closeable = closeable;
            this.downstream = downstream;
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void pull(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private boolean handleCompletion() {
            try {
                if (!iterator.hasNext()) {
                    downstream.onCompletion();
                    cancelled = true;
                    return true;
                }
            } catch (Throwable ex) {
                downstream.onFailure(ex);
                cancelled = true;
                return true;
            }
            return false;
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

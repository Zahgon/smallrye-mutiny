package io.smallrye.mutiny.operators.multi.builders;

import java.util.Iterator;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicLong;

import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class IterableBasedMulti<T> extends AbstractMulti<T> {

    private final Iterable<? extends T> source;

    public IterableBasedMulti(Iterable<? extends T> source) {
        this.source = source;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> void subscribe(MultiSubscriber<? super T> downstream, Iterator<? extends T> iterator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static final class IteratorSubscription<T> implements Subscription {

        private final Iterator<? extends T> iterator;

        private final MultiSubscriber<? super T> downstream;

        private volatile boolean cancelled;

        private final AtomicLong requested = new AtomicLong();

        IteratorSubscription(MultiSubscriber<? super T> downstream, Iterator<? extends T> iterator) {
            this.downstream = downstream;
            this.iterator = iterator;
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void fastPath() {
            for (;;) {
                if (cancelled) {
                    return;
                }
                T t;
                try {
                    t = iterator.next();
                } catch (Throwable ex) {
                    downstream.onFailure(ex);
                    return;
                }
                if (cancelled) {
                    return;
                }
                if (t == null) {
                    downstream.onFailure(new NullPointerException("Iterator.next() returned a null value"));
                    return;
                } else {
                    downstream.onItem(t);
                }
                if (cancelled) {
                    return;
                }
                boolean b;
                try {
                    b = iterator.hasNext();
                } catch (Throwable ex) {
                    downstream.onFailure(ex);
                    return;
                }
                if (!b) {
                    if (!cancelled) {
                        downstream.onCompletion();
                    }
                    return;
                }
            }
        }

        private void slowPath(long r) {
            long e = 0L;
            for (;;) {
                while (e != r) {
                    if (cancelled) {
                        return;
                    }
                    T t;
                    try {
                        t = iterator.next();
                    } catch (Throwable ex) {
                        downstream.onFailure(ex);
                        return;
                    }
                    if (cancelled) {
                        return;
                    }
                    if (t == null) {
                        downstream.onFailure(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    } else {
                        downstream.onItem(t);
                    }
                    if (cancelled) {
                        return;
                    }
                    boolean b;
                    try {
                        b = iterator.hasNext();
                    } catch (Throwable ex) {
                        downstream.onFailure(ex);
                        return;
                    }
                    if (!b) {
                        if (!cancelled) {
                            downstream.onCompletion();
                        }
                        return;
                    }
                    e++;
                }
                r = requested.get();
                if (e == r) {
                    r = requested.addAndGet(-e);
                    if (r == 0L) {
                        return;
                    }
                    e = 0L;
                }
            }
        }
    }
}

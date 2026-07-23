package io.smallrye.mutiny.operators.multi;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

import io.smallrye.mutiny.GroupedMulti;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.queues.Queues;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public final class MultiGroupByOp<T, K, V> extends AbstractMultiOperator<T, GroupedMulti<K, V>> {

    private final Function<? super T, ? extends K> keySelector;

    private final Function<? super T, ? extends V> valueSelector;

    private final long prefetch;

    public MultiGroupByOp(Multi<T> upstream, Function<? super T, ? extends K> keySelector,
            Function<? super T, ? extends V> valueSelector, long prefetch) {
        super(upstream);
        this.keySelector = keySelector;
        this.valueSelector = valueSelector;
        this.prefetch = prefetch;
    }

    @Override
    public void subscribe(MultiSubscriber<? super GroupedMulti<K, V>> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static final class MultiGroupByProcessor<T, K, V> extends MultiOperatorProcessor<T, GroupedMulti<K, V>> {

        private final Function<? super T, ? extends K> keySelector;

        private final Function<? super T, ? extends V> valueSelector;

        private final long prefetch;

        private final Map<Object, GroupedUnicast<K, V>> groups;

        private final Queue<GroupedMulti<K, V>> queue;

        private static final Object NO_KEY = new Object();

        private final AtomicBoolean cancelled = new AtomicBoolean();

        private final AtomicLong requested = new AtomicLong();

        private final AtomicInteger groupCount = new AtomicInteger(1);

        private final AtomicInteger wip = new AtomicInteger();

        Throwable failure;

        volatile boolean finished;

        boolean done;

        public MultiGroupByProcessor(MultiSubscriber<? super GroupedMulti<K, V>> downstream,
                Function<? super T, ? extends K> keySelector, Function<? super T, ? extends V> valueSelector,
                Map<Object, GroupedUnicast<K, V>> groups, long prefetch) {
            super(downstream);
            this.keySelector = keySelector;
            this.valueSelector = valueSelector;
            this.prefetch = prefetch;
            this.groups = groups;
            this.queue = Queues.<GroupedMulti<K, V>> unbounded(Infrastructure.getBufferSizeS()).get();
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable throwable) {
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

        public void cancel(K key) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void drain() {
            if (wip.getAndIncrement() != 0) {
                return;
            }
            int missed = 1;
            final Queue<GroupedMulti<K, V>> q = this.queue;
            for (;;) {
                long requests = requested.get();
                long emitted = 0L;
                while (emitted != requests) {
                    boolean isDone = finished;
                    GroupedMulti<K, V> t = q.poll();
                    boolean hasNoMoreGroup = t == null;
                    if (isDoneOrCancelled(isDone, hasNoMoreGroup, q)) {
                        return;
                    }
                    if (hasNoMoreGroup) {
                        break;
                    }
                    this.downstream.onItem(t);
                    emitted++;
                }
                if (emitted == requests && isDoneOrCancelled(finished, q.isEmpty(), q)) {
                    return;
                }
                if (emitted != 0L) {
                    if (requests != Long.MAX_VALUE) {
                        requested.addAndGet(-emitted);
                    }
                }
                missed = wip.addAndGet(-missed);
                if (missed == 0) {
                    break;
                }
            }
        }

        boolean isDoneOrCancelled(boolean d, boolean empty, Queue<?> q) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public static final class GroupedUnicast<K, T> extends AbstractMulti<T> implements GroupedMulti<K, T> {

        private final State<T, K> downstream;

        private final K key;

        static <T, K> GroupedUnicast<K, T> createWith(K key, MultiGroupByProcessor<?, K, T> parent) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private GroupedUnicast(K key, State<T, K> downstream) {
            this.key = key;
            this.downstream = downstream;
        }

        @Override
        public void subscribe(MultiSubscriber<? super T> s) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void onItem(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void onFailure(Throwable e) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void onComplete() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public K key() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static final class State<T, K> implements Flow.Subscription, Flow.Publisher<T> {

        private final AtomicReference<Flow.Subscriber<? super T>> downstream = new AtomicReference<>();

        private final AtomicBoolean cancelled = new AtomicBoolean();

        private final AtomicLong requested = new AtomicLong();

        private final AtomicBoolean done = new AtomicBoolean();

        private final AtomicInteger wip = new AtomicInteger();

        private final K key;

        private final Queue<T> queue;

        private final MultiGroupByProcessor<?, K, T> parent;

        private volatile Throwable failure;

        @SuppressWarnings("unchecked")
        State(MultiGroupByProcessor<?, K, T> parent, K key) {
            this.parent = parent;
            this.queue = (Queue<T>) Queues.unbounded(Infrastructure.getBufferSizeS()).get();
            this.key = key;
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void subscribe(Flow.Subscriber<? super T> s) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void onItem(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void onFailure(Throwable e) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        void drain() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        boolean hasCompleted(boolean isDone, boolean isEmpty, long emitted) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

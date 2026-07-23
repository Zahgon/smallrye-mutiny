package io.smallrye.mutiny.operators.multi.processors;

import java.util.Queue;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Processor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.Consumer;

import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.BackPressureStrategy;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * Implementation of a processor using a queue to store items and allows a single subscriber to receive
 * these items.
 * <p>
 * The back pressure model is not using the request protocol but the queue used to store the items. If the queue
 * gets full, an {@link io.smallrye.mutiny.subscription.BackPressureFailure} exception is propagated downstream.
 * <p>
 * <strong>This processor must not be re-subscribed: it expects exactly 1 subscriber.</strong>
 * If you expect multiple subscribers then you should look at creating a {@link io.smallrye.mutiny.Multi} from an
 * emitter, see {@link io.smallrye.mutiny.groups.MultiCreate#emitter(Consumer, BackPressureStrategy)}.
 *
 * @param <T> the type of item
 */
public class UnicastProcessor<T> extends AbstractMulti<T> implements Processor<T, T>, Flow.Subscription {

    private final Runnable onTermination;

    private final Queue<T> queue;

    private volatile boolean done = false;

    private volatile Throwable failure = null;

    private volatile boolean cancelled = false;

    private volatile Flow.Subscriber<? super T> downstream = null;

    private static final AtomicReferenceFieldUpdater<UnicastProcessor, Flow.Subscriber> DOWNSTREAM_UPDATER = AtomicReferenceFieldUpdater
            .newUpdater(UnicastProcessor.class, Flow.Subscriber.class, "downstream");

    private final AtomicInteger wip = new AtomicInteger();

    private final AtomicLong requested = new AtomicLong();

    private volatile boolean hasUpstream;

    public static <I> UnicastProcessor<I> create() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <I> UnicastProcessor<I> create(Queue<I> queue, Runnable onTermination) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private UnicastProcessor(Queue<T> queue, Runnable onTermination) {
        this.queue = ParameterValidation.nonNull(queue, "queue");
        this.onTermination = onTermination;
    }

    private void onTerminate() {
        if (onTermination != null) {
            onTermination.run();
        }
    }

    void drainWithDownstream(Flow.Subscriber<? super T> actual) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void drain() {
        if (wip.getAndIncrement() != 0) {
            return;
        }
        int missed = 1;
        for (;;) {
            Flow.Subscriber<? super T> actual = downstream;
            if (actual != null) {
                drainWithDownstream(actual);
                return;
            }
            missed = wip.addAndGet(-missed);
            if (missed == 0) {
                break;
            }
        }
    }

    private boolean isCancelledOrDone(boolean isDone, boolean isEmpty) {
        Flow.Subscriber<? super T> subscriber = downstream;
        if (cancelled) {
            queue.clear();
            return true;
        }
        if (isDone && isEmpty) {
            Throwable failed = failure;
            if (failed != null) {
                subscriber.onError(failed);
            } else {
                subscriber.onComplete();
            }
            return true;
        }
        return false;
    }

    @Override
    public void onSubscribe(Flow.Subscription upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public synchronized void onNext(T t) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean isDoneOrCancelled() {
        return done || cancelled;
    }

    @Override
    public void onError(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onComplete() {
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

    public boolean hasSubscriber() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public SerializedProcessor<T, T> serialized() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

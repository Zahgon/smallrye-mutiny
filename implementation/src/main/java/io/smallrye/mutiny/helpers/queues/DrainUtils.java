package io.smallrye.mutiny.helpers.queues;

import java.util.Queue;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BooleanSupplier;

/**
 * Copy from Project Reactor.
 */
public class DrainUtils {

    /**
     * Indicates the source completed and the value field is ready to be emitted.
     * <p>
     * The AtomicLong (this) holds the requested amount in bits 0..62 so there is room
     * for one signal bit. This also means the standard request accounting helper method doesn't work.
     */
    protected static final long COMPLETED_MASK = 0x8000_0000_0000_0000L;

    protected static final long REQUESTED_MASK = 0x7FFF_FFFF_FFFF_FFFFL;

    private DrainUtils() {
        // avoid direct instantiation.
    }

    public static <T> boolean postCompleteRequest(long n, Subscriber<? super T> downstream, Queue<T> queue,
            AtomicLong requested, BooleanSupplier isCancelled) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Drains the queue either in a pre- or post-complete state.
     *
     * @param n the requested amount
     * @param downstream the downstream consumer
     * @param queue the queue holding available values
     * @param requested the atomic long keeping track of requests
     * @param isCancelled callback to detect cancellation
     * @return true if the queue was completely drained or the drain process was cancelled
     */
    private static <T> boolean postCompleteDrain(long n, Subscriber<? super T> downstream, Queue<T> queue, AtomicLong requested,
            BooleanSupplier isCancelled) {
        long e = n & COMPLETED_MASK;
        for (;;) {
            while (e != n) {
                if (isCancelled.getAsBoolean()) {
                    return true;
                }
                T t = queue.poll();
                if (t == null) {
                    downstream.onComplete();
                    return true;
                }
                downstream.onNext(t);
                e++;
            }
            if (isCancelled.getAsBoolean()) {
                return true;
            }
            if (queue.isEmpty()) {
                downstream.onComplete();
                return true;
            }
            n = requested.get();
            if (n == e) {
                n = requested.addAndGet(-(e & REQUESTED_MASK));
                if ((n & REQUESTED_MASK) == 0L) {
                    return false;
                }
                e = n & COMPLETED_MASK;
            }
        }
    }

    public static <T> void postComplete(Subscriber<? super T> downstream, Queue<T> queue, AtomicLong requested,
            BooleanSupplier isCancelled) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

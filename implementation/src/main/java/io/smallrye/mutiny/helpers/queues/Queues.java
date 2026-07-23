package io.smallrye.mutiny.helpers.queues;

import java.util.Queue;
import java.util.function.Supplier;

public class Queues {

    private Queues() {
        // avoid direct instantiation
    }

    public static <T> Queue<T> createSpscArrayQueue(int capacity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Queue<T> createSpscUnboundedArrayQueue(int chunkSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Queue<T> createSpscChunkedArrayQueue(int capacity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Supplier<Queue<T>> getXsQueueSupplier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Supplier<Queue<T>> get(int capacity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Supplier<Queue<T>> unbounded(int chunkSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Queue<T> createMpscQueue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Queue<T> createSpscUnboundedQueue(int chunkSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Queue<T> createMpscArrayQueue(int capacity) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

abstract class FlatMapManager<T> {

    protected AtomicReference<T[]> inners = new AtomicReference<>(empty());

    private int[] free = FREE_EMPTY;

    private long producerIndex;

    private long consumerIndex;

    private final AtomicInteger size = new AtomicInteger();

    private static final int[] FREE_EMPTY = new int[0];

    abstract T[] empty();

    abstract T[] terminated();

    abstract T[] newArray(int size);

    abstract void unsubscribeEntry(T entry, boolean fromOnError);

    abstract void setIndex(T entry, int index);

    final void unsubscribe() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    final void unsubscribe(boolean fromOnError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    final T[] get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    final boolean add(T entry) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    final void remove(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private int pollFree() {
        int[] a = free;
        int m = a.length - 1;
        long ci = consumerIndex;
        if (producerIndex == ci) {
            return -1;
        }
        int offset = (int) ci & m;
        consumerIndex = ci + 1;
        return a[offset];
    }

    private void offerFree(int index) {
        int[] a = free;
        int m = a.length - 1;
        long pi = producerIndex;
        int offset = (int) pi & m;
        a[offset] = index;
        producerIndex = pi + 1;
    }

    final boolean isEmpty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package io.smallrye.mutiny.helpers.test;

/**
 * A onItem signal.
 */
public final class OnItemUniSignal<T> implements UniSignal {

    private final T item;

    public OnItemUniSignal(T item) {
        this.item = item;
    }

    @Override
    public T value() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

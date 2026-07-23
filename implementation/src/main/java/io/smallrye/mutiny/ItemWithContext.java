package io.smallrye.mutiny;

/**
 * Models an item flowing along a Mutiny pipeline with its subscriber context attached.
 *
 * @param <T> the item type
 * @see Uni#attachContext()
 * @see Multi#attachContext()
 */
public final class ItemWithContext<T> {

    private final Context context;

    private final T item;

    /**
     * Creates a new item with a context.
     * <p>
     * Since instances are being created by Mutiny operators there is no {@code null} check on parameters
     * for performance reasons.
     *
     * @param context the context
     * @param item the item
     */
    public ItemWithContext(Context context, T item) {
        this.context = context;
        this.item = item;
    }

    public Context context() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T get() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

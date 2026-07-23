package io.smallrye.mutiny;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Flow;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * A context allows sharing key / value entries along with a subscriber in a Mutiny pipeline, so all operators can
 * share implicit data for a given subscription.
 * <p>
 * A context is provided by a {@link io.smallrye.mutiny.subscription.UniSubscriber} or {@link Flow.Subscriber}
 * that implements {@link io.smallrye.mutiny.subscription.ContextSupport}.
 * <p>
 * Context keys and values can be from heterogeneous types.
 * Keys must have proper {@link Object#equals(Object)} and {@link Object#hashCode()} implementations.
 * <p>
 * {@link Context} instances are thread-safe.
 * Internal storage is not allocated until the first entry is being added.
 * <p>
 * Contexts shall be primarily used to share transient data used for networked I/O processing such as correlation
 * identifiers, tokens, etc.
 * They should not be used as general-purpose data structures that are frequently updated and that hold large amounts of
 * data.
 *
 * @see Uni#withContext(BiFunction)
 * @see Uni#attachContext()
 * @see io.smallrye.mutiny.groups.UniSubscribe
 * @see Multi#withContext(BiFunction)
 * @see Multi#attachContext()
 * @see io.smallrye.mutiny.groups.MultiSubscribe
 */
public final class Context {

    public static Context empty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Context of(Object... entries) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Context from(Map<?, ?> entries) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private volatile ConcurrentHashMap<Object, Object> entries;

    private Context() {
        this.entries = null;
    }

    private Context(Map<?, ?> initialEntries) {
        this.entries = new ConcurrentHashMap<>(initialEntries);
    }

    public boolean contains(Object key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Deprecated(forRemoval = true)
    public boolean contains(String key) {
        return contains((Object) key);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Object key) throws NoSuchElementException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Deprecated(forRemoval = true)
    public <T> T get(String key) throws NoSuchElementException {
        return get((Object) key);
    }

    @SuppressWarnings("unchecked")
    public <T> T getOrElse(Object key, Supplier<? extends T> alternativeSupplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Deprecated(forRemoval = true)
    public <T> T getOrElse(String key, Supplier<? extends T> alternativeSupplier) {
        return getOrElse((Object) key, alternativeSupplier);
    }

    public Context put(Object key, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Deprecated(forRemoval = true)
    public Context put(String key, Object value) {
        return put((Object) key, value);
    }

    public Context delete(Object key) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Deprecated(forRemoval = true)
    public Context delete(String key) {
        return delete((Object) key);
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Set<Object> keys() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

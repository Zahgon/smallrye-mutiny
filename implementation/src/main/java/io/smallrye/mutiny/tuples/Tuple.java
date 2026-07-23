package io.smallrye.mutiny.tuples;

import java.util.Iterator;
import java.util.List;

public interface Tuple extends Iterable<Object> {

    /**
     * Get the item stored at the given index.
     *
     * @param index The index of the item to retrieve.
     * @return The item, can be {@code null}
     * @throws IndexOutOfBoundsException if the index is greater than the size.
     */
    Object nth(int index);

    /**
     * Gets a {@link java.util.List} of {@link Object Objects} containing the items composing this {@link Tuple}
     *
     * @return A list containing the item of the tuple.
     */
    List<Object> asList();

    @Override
    default Iterator<Object> iterator() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return the number of items stored in the {@link Tuple}
     */
    int size();
}

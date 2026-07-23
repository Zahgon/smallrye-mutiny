package io.smallrye.mutiny.tuples;

import java.util.List;
import java.util.function.Function;

/**
 * A tuple containing two items.
 *
 * @param <L> The type of the first item
 * @param <R> The type of the second item
 */
public class Tuple2<L, R> implements Tuple {

    final L item1;

    final R item2;

    protected Tuple2(L left, R right) {
        this.item1 = left;
        this.item2 = right;
    }

    public static <L, R> Tuple2<L, R> of(L l, R r) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public L getItem1() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public R getItem2() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T> Tuple2<T, R> mapItem1(Function<L, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T> Tuple2<L, T> mapItem2(Function<R, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object nth(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void assertIndexInBounds(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<Object> asList() {
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

    public int size() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

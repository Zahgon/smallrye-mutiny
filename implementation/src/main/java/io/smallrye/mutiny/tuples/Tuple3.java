package io.smallrye.mutiny.tuples;

import java.util.List;
import java.util.function.Function;

public class Tuple3<T1, T2, T3> extends Tuple2<T1, T2> implements Tuple {

    final T3 item3;

    Tuple3(T1 a, T2 b, T3 c) {
        super(a, b);
        this.item3 = c;
    }

    public static <T1, T2, T3> Tuple3<T1, T2, T3> of(T1 a, T2 b, T3 c) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T3 getItem3() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object nth(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple3<T, T2, T3> mapItem1(Function<T1, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple3<T1, T, T3> mapItem2(Function<T2, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T> Tuple3<T1, T2, T> mapItem3(Function<T3, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public List<Object> asList() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

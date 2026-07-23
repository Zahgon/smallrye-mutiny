package io.smallrye.mutiny.tuples;

import java.util.List;
import java.util.function.Function;

public class Tuple4<T1, T2, T3, T4> extends Tuple3<T1, T2, T3> implements Tuple {

    final T4 item4;

    Tuple4(T1 a, T2 b, T3 c, T4 d) {
        super(a, b, c);
        this.item4 = d;
    }

    public static <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4> of(T1 a, T2 b, T3 c, T4 d) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T4 getItem4() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object nth(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple4<T, T2, T3, T4> mapItem1(Function<T1, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple4<T1, T, T3, T4> mapItem2(Function<T2, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple4<T1, T2, T, T4> mapItem3(Function<T3, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T> Tuple4<T1, T2, T3, T> mapItem4(Function<T4, T> mapper) {
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
    public boolean equals(Object o) {
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

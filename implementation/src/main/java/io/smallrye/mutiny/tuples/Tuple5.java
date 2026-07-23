package io.smallrye.mutiny.tuples;

import java.util.List;
import java.util.function.Function;

public class Tuple5<T1, T2, T3, T4, T5> extends Tuple4<T1, T2, T3, T4> implements Tuple {

    final T5 item5;

    Tuple5(T1 a, T2 b, T3 c, T4 d, T5 e) {
        super(a, b, c, d);
        this.item5 = e;
    }

    public static <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5> of(T1 a, T2 b, T3 c, T4 d, T5 e) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T5 getItem5() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple5<T, T2, T3, T4, T5> mapItem1(Function<T1, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple5<T1, T, T3, T4, T5> mapItem2(Function<T2, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple5<T1, T2, T, T4, T5> mapItem3(Function<T3, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple5<T1, T2, T3, T, T5> mapItem4(Function<T4, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T> Tuple5<T1, T2, T3, T4, T> mapItem5(Function<T5, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Object nth(int index) {
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

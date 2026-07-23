package io.smallrye.mutiny.tuples;

import java.util.List;
import java.util.function.Function;

public class Tuple6<T1, T2, T3, T4, T5, T6> extends Tuple5<T1, T2, T3, T4, T5> implements Tuple {

    final T6 item6;

    Tuple6(T1 a, T2 b, T3 c, T4 d, T5 e, T6 f) {
        super(a, b, c, d, e);
        this.item6 = f;
    }

    public static <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6> of(T1 a, T2 b, T3 c, T4 d, T5 e, T6 f) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T6 getItem6() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple6<T, T2, T3, T4, T5, T6> mapItem1(Function<T1, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple6<T1, T, T3, T4, T5, T6> mapItem2(Function<T2, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple6<T1, T2, T, T4, T5, T6> mapItem3(Function<T3, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple6<T1, T2, T3, T, T5, T6> mapItem4(Function<T4, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple6<T1, T2, T3, T4, T, T6> mapItem5(Function<T5, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T> Tuple6<T1, T2, T3, T4, T5, T> mapItem6(Function<T6, T> mapper) {
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

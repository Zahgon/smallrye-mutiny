package io.smallrye.mutiny.tuples;

import java.util.List;
import java.util.function.Function;

public class //NOSONAR
Tuple7<//NOSONAR
        T1, //NOSONAR
        T2, //NOSONAR
        T3, //NOSONAR
        T4, //NOSONAR
        T5, //NOSONAR
        T6, //NOSONAR
        T7> extends //NOSONAR
        Tuple6<T1, T2, T3, T4, T5, T6> implements //NOSONAR
        Tuple {

    final T7 item7;

    Tuple7(T1 a, T2 b, T3 c, T4 d, T5 e, T6 f, T7 g) {
        super(a, b, c, d, e, f);
        this.item7 = g;
    }

    public static <T1, T2, T3, T4, T5, T6, T7> Tuple7<T1, T2, T3, T4, T5, T6, T7> of(T1 a, T2 b, T3 c, T4 d, T5 e, T6 f, T7 g) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T7 getItem7() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple7<T, T2, T3, T4, T5, T6, T7> mapItem1(Function<T1, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple7<T1, T, T3, T4, T5, T6, T7> mapItem2(Function<T2, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple7<T1, T2, T, T4, T5, T6, T7> mapItem3(Function<T3, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple7<T1, T2, T3, T, T5, T6, T7> mapItem4(Function<T4, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple7<T1, T2, T3, T4, T, T6, T7> mapItem5(Function<T5, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple7<T1, T2, T3, T4, T5, T, T7> mapItem6(Function<T6, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T> Tuple7<T1, T2, T3, T4, T5, T6, T> mapItem7(Function<T7, T> mapper) {
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

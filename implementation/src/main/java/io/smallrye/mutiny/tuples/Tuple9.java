package io.smallrye.mutiny.tuples;

import java.util.List;
import java.util.function.Function;

public class // NOSONAR
Tuple9<// NOSONAR
        T1, // NOSONAR
        T2, // NOSONAR
        T3, // NOSONAR
        T4, // NOSONAR
        T5, // NOSONAR
        T6, // NOSONAR
        T7, // NOSONAR
        T8, // NOSONAR
        T9> extends // NOSONAR
        Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> implements // NOSONAR
        Tuple {

    final T9 item9;

    Tuple9(T1 a, T2 b, T3 c, T4 d, T5 e, T6 f, T7 g, T8 h, T9 i) {
        // NOSONAR
        super(a, b, c, d, e, f, g, h);
        this.item9 = i;
    }

    public static <//NOSONAR
            T1, //NOSONAR
            T2, //NOSONAR
            T3, //NOSONAR
            T4, //NOSONAR
            T5, //NOSONAR
            T6, //NOSONAR
            T7, //NOSONAR
            T8, //NOSONAR
            T9> //NOSONAR
                    Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> //NOSONAR
                    of(//NOSONAR
                            T1 a, //NOSONAR
                            T2 b, //NOSONAR
                            T3 c, //NOSONAR
                            T4 d, T5 e, T6 f, T7 g, T8 h, T9 i) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T9 getItem9() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple9<T, T2, T3, T4, T5, T6, T7, T8, T9> mapItem1(Function<T1, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple9<T1, T, T3, T4, T5, T6, T7, T8, T9> mapItem2(Function<T2, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple9<T1, T2, T, T4, T5, T6, T7, T8, T9> mapItem3(Function<T3, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple9<T1, T2, T3, T, T5, T6, T7, T8, T9> mapItem4(Function<T4, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple9<T1, T2, T3, T4, T, T6, T7, T8, T9> mapItem5(Function<T5, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple9<T1, T2, T3, T4, T5, T, T7, T8, T9> mapItem6(Function<T6, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple9<T1, T2, T3, T4, T5, T6, T, T8, T9> mapItem7(Function<T7, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple9<T1, T2, T3, T4, T5, T6, T7, T, T9> mapItem8(Function<T8, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T> Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T> mapItem9(Function<T9, T> mapper) {
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

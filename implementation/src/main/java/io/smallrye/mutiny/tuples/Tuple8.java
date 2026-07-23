package io.smallrye.mutiny.tuples;

import java.util.List;
import java.util.function.Function;

public class //NOSONAR
Tuple8<//NOSONAR
        T1, //NOSONAR
        T2, //NOSONAR
        T3, //NOSONAR
        T4, //NOSONAR
        T5, //NOSONAR
        T6, //NOSONAR
        T7, //NOSONAR
        T8> extends //NOSONAR
        Tuple7<T1, T2, T3, T4, T5, T6, T7> implements //NOSONAR
        Tuple {

    final T8 item8;

    Tuple8(T1 a, T2 b, T3 c, T4 d, T5 e, T6 f, T7 g, T8 h) {
        //NOSONAR
        super(a, b, c, d, e, f, g);
        this.item8 = h;
    }

    public static <//NOSONAR
            T1, //NOSONAR
            T2, //NOSONAR
            T3, //NOSONAR
            T4, //NOSONAR
            T5, //NOSONAR
            T6, //NOSONAR
            T7, //NOSONAR
            T8> //NOSONAR
                    Tuple8<T1, T2, T3, T4, T5, T6, T7, T8> //NOSONAR
                    of(//NOSONAR
                            T1 a, //NOSONAR
                            T2 b, //NOSONAR
                            T3 c, //NOSONAR
                            T4 d, //NOSONAR
                            T5 e, //NOSONAR
                            T6 f, T7 g, T8 h) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T8 getItem8() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple8<T, T2, T3, T4, T5, T6, T7, T8> mapItem1(Function<T1, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple8<T1, T, T3, T4, T5, T6, T7, T8> mapItem2(Function<T2, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple8<T1, T2, T, T4, T5, T6, T7, T8> mapItem3(Function<T3, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple8<T1, T2, T3, T, T5, T6, T7, T8> mapItem4(Function<T4, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple8<T1, T2, T3, T4, T, T6, T7, T8> mapItem5(Function<T5, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple8<T1, T2, T3, T4, T5, T, T7, T8> mapItem6(Function<T6, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Tuple8<T1, T2, T3, T4, T5, T6, T, T8> mapItem7(Function<T7, T> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public <T> Tuple8<T1, T2, T3, T4, T5, T6, T7, T> mapItem8(Function<T8, T> mapper) {
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

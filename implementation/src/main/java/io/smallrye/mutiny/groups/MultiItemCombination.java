package io.smallrye.mutiny.groups;

import java.util.concurrent.Flow.Publisher;

import io.smallrye.common.annotation.CheckReturnValue;

public class MultiItemCombination {

    @CheckReturnValue
    public <T1, T2> MultiItemCombine2<T1, T2> streams(Publisher<? extends T1> a, Publisher<? extends T2> b) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T1, T2, T3> MultiItemCombine3<T1, T2, T3> streams(Publisher<? extends T1> a, Publisher<? extends T2> b,
            Publisher<? extends T3> c) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T1, T2, T3, T4> MultiItemCombine4<T1, T2, T3, T4> streams(Publisher<? extends T1> a, Publisher<? extends T2> b,
            Publisher<? extends T3> c, Publisher<? extends T4> d) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T1, T2, T3, T4, T5> MultiItemCombine5<T1, T2, T3, T4, T5> streams(Publisher<? extends T1> a,
            Publisher<? extends T2> b, Publisher<? extends T3> c, Publisher<? extends T4> d, Publisher<? extends T5> e) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T1, T2, T3, T4, T5, T6> MultiItemCombine6<T1, T2, T3, T4, T5, T6> streams(Publisher<? extends T1> a,
            Publisher<? extends T2> b, Publisher<? extends T3> c, Publisher<? extends T4> d, Publisher<? extends T5> e,
            Publisher<? extends T6> f) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <// NOSONAR
            T1, // NOSONAR
            T2, // NOSONAR
            T3, // NOSONAR
            T4, // NOSONAR
            T5, // NOSONAR
            T6, // NOSONAR
            T7> // NOSONAR
                    MultiItemCombine7<T1, T2, T3, T4, T5, T6, T7> // NOSONAR
                    streams(Publisher<? extends T1> a, Publisher<? extends T2> b, Publisher<? extends T3> c,
                            Publisher<? extends T4> d, Publisher<? extends T5> e, Publisher<? extends T6> f,
                            Publisher<? extends T7> g) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <// NOSONAR
            T1, // NOSONAR
            T2, // NOSONAR
            T3, // NOSONAR
            T4, // NOSONAR
            T5, // NOSONAR
            T6, // NOSONAR
            T7, // NOSONAR
            T8> // NOSONAR
                    MultiItemCombine8<T1, T2, T3, T4, T5, T6, T7, T8> // NOSONAR
                    streams(Publisher<? extends T1> a, Publisher<? extends T2> b, Publisher<? extends T3> c,
                            Publisher<? extends T4> d, Publisher<? extends T5> e, Publisher<? extends T6> f,
                            Publisher<? extends T7> g, Publisher<? extends T8> h) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T1, T2, T3, T4, T5, T6, T7, T8, T9> MultiItemCombine9<T1, T2, T3, T4, T5, T6, T7, T8, T9> streams(// NOSONAR
            Publisher<? extends T1> a, Publisher<? extends T2> b, Publisher<? extends T3> c, Publisher<? extends T4> d,
            Publisher<? extends T5> e, Publisher<? extends T6> f, Publisher<? extends T7> g, Publisher<? extends T8> h,
            Publisher<? extends T9> i) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiItemCombineIterable streams(Iterable<? extends Publisher<?>> iterable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

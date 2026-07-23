package io.smallrye.mutiny.groups;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.tuples.*;

/**
 * Combines several {@link Uni} into a new {@link Uni} that will fire an item event when all {@link Uni} are
 * resolved successfully aggregating their results (emitted item) into a {@link Tuple}, or using a combinator function.
 * <p>
 * The produced {@link Uni} fire a failure if one of {@link Uni Unis} produces a failure. This will
 * cause the other {@link Uni} to be cancelled, expect if {@code collectFailures()} is invoked, which delay firing
 * the failure until all {@link Uni}s have completed or failed.
 */
public class UniZip {

    /**
     * Singleton instance.
     */
    static final UniZip INSTANCE = new UniZip();

    private UniZip() {
        // avoid direct instantiation
    }

    @CheckReturnValue
    public <T1, T2> UniAndGroup2<T1, T2> unis(Uni<? extends T1> u1, Uni<? extends T2> u2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T1, T2, T3> UniAndGroup3<T1, T2, T3> unis(Uni<? extends T1> u1, Uni<? extends T2> u2, Uni<? extends T3> u3) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T1, T2, T3, T4> UniAndGroup4<T1, T2, T3, T4> unis(Uni<? extends T1> u1, Uni<? extends T2> u2, Uni<? extends T3> u3,
            Uni<? extends T4> u4) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T1, T2, T3, T4, T5> UniAndGroup5<T1, T2, T3, T4, T5> unis(Uni<? extends T1> u1, Uni<? extends T2> u2,
            Uni<? extends T3> u3, Uni<? extends T4> u4, Uni<? extends T5> u5) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T1, T2, T3, T4, T5, T6> UniAndGroup6<T1, T2, T3, T4, T5, T6> unis(Uni<? extends T1> u1, Uni<? extends T2> u2,
            Uni<? extends T3> u3, Uni<? extends T4> u4, Uni<? extends T5> u5, Uni<? extends T6> u6) {
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
                    UniAndGroup7<T1, T2, T3, T4, T5, T6, T7> // NOSONAR
                    unis(Uni<? extends T1> u1, Uni<? extends T2> u2, Uni<? extends T3> u3, Uni<? extends T4> u4,
                            Uni<? extends T5> u5, Uni<? extends T6> u6, Uni<? extends T7> u7) {
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
                    UniAndGroup8<T1, T2, T3, T4, T5, T6, T7, T8> // NOSONAR
                    unis(Uni<? extends T1> u1, Uni<? extends T2> u2, Uni<? extends T3> u3, Uni<? extends T4> u4,
                            Uni<? extends T5> u5, Uni<? extends T6> u6, Uni<? extends T7> u7, Uni<? extends T8> u8) {
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
            T8, // NOSONAR
            T9> // NOSONAR
                    UniAndGroup9<T1, T2, T3, T4, T5, T6, T7, T8, T9> // NOSONAR
                    unis(Uni<? extends T1> u1, Uni<? extends T2> u2, Uni<? extends T3> u3, Uni<? extends T4> u4,
                            Uni<? extends T5> u5, Uni<? extends T6> u6, Uni<? extends T7> u7, Uni<? extends T8> u8,
                            Uni<? extends T9> u9) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <O> UniAndGroupIterable<O> unis(Uni<?>... unis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <O> UniAndGroupIterable<O> unis(Iterable<? extends Uni<?>> unis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

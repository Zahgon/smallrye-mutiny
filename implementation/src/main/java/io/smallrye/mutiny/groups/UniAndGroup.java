package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.tuples.*;

/**
 * Combines several {@link Uni unis} into a new {@link Uni} that will be fulfilled when <strong>all</strong>
 * {@link Uni unis} have emitted an {@code item} event and then combines the different outcomes into a
 * {@link Tuple}, or using a combinator function.
 * <p>
 * The produced {@link Uni} fires a {@code failure} event if one of the {@link Uni Unis} fires a failure. This
 * causes the other {@link Uni unis} to be cancelled, expect if {@code collectFailures()} is invoked, which delay the
 * {@code failure} event until all {@link Uni}s have completed or failed.
 */
public class UniAndGroup<T1> {

    private final Uni<T1> upstream;

    public UniAndGroup(Uni<T1> upstream) {
        this.upstream = nonNull(upstream, "upstream");
    }

    @CheckReturnValue
    public <T2> UniAndGroup2<T1, T2> uni(Uni<? extends T2> other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T2, T3> UniAndGroup3<T1, T2, T3> unis(Uni<? extends T2> u2, Uni<? extends T3> u3) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T2, T3, T4> UniAndGroup4<T1, T2, T3, T4> unis(Uni<? extends T2> u2, Uni<? extends T3> u3, Uni<? extends T4> u4) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T2, T3, T4, T5> UniAndGroup5<T1, T2, T3, T4, T5> unis(Uni<? extends T2> u2, Uni<? extends T3> u3,
            Uni<? extends T4> u4, Uni<? extends T5> u5) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T2, T3, T4, T5, T6> UniAndGroup6<T1, T2, T3, T4, T5, T6> unis(Uni<? extends T2> u2, Uni<? extends T3> u3,
            Uni<? extends T4> u4, Uni<? extends T5> u5, Uni<? extends T6> u6) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <// NOSONAR
            T2, // NOSONAR
            T3, // NOSONAR
            T4, // NOSONAR
            T5, // NOSONAR
            T6, // NOSONAR
            T7> // NOSONAR
                    UniAndGroup7<T1, T2, T3, T4, T5, T6, T7> // NOSONAR
                    unis(Uni<? extends T2> u2, Uni<? extends T3> u3, Uni<? extends T4> u4, Uni<? extends T5> u5,
                            Uni<? extends T6> u6, Uni<? extends T7> u7) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <// NOSONAR
            T2, // NOSONAR
            T3, // NOSONAR
            T4, // NOSONAR
            T5, // NOSONAR
            T6, // NOSONAR
            T7, // NOSONAR
            T8> // NOSONAR
                    UniAndGroup8<T1, T2, T3, T4, T5, T6, T7, T8> // NOSONAR
                    unis(Uni<? extends T2> u2, Uni<? extends T3> u3, Uni<? extends T4> u4, Uni<? extends T5> u5,
                            Uni<? extends T6> u6, Uni<? extends T7> u7, Uni<? extends T8> u8) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <// NOSONAR
            T2, // NOSONAR
            T3, // NOSONAR
            T4, // NOSONAR
            T5, // NOSONAR
            T6, // NOSONAR
            T7, // NOSONAR
            T8, // NOSONAR
            T9> // NOSONAR
                    UniAndGroup9<T1, T2, T3, T4, T5, T6, T7, T8, T9> // NOSONAR
                    unis(Uni<? extends T2> u2, Uni<? extends T3> u3, Uni<? extends T4> u4, Uni<? extends T5> u5,
                            Uni<? extends T6> u6, Uni<? extends T7> u7, Uni<? extends T8> u8, Uni<? extends T9> u9) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public UniAndGroupIterable<T1> unis(Uni<?>... unis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public UniAndGroupIterable<T1> unis(Iterable<? extends Uni<?>> unis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

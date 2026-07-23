package io.smallrye.mutiny.groups;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.tuples.Functions;
import io.smallrye.mutiny.tuples.Tuple8;
import io.smallrye.mutiny.tuples.Tuples;

public class UniAndGroup8<T1, T2, T3, T4, T5, T6, T7, T8> extends UniAndGroupIterable<T1> {

    public // NOSONAR
    UniAndGroup8(// NOSONAR
            Uni<? extends T1> source, // NOSONAR
            Uni<? extends T2> o1, // NOSONAR
            Uni<? extends T3> o2, Uni<? extends T4> o3, Uni<? extends T5> o4, Uni<? extends T6> o5, Uni<? extends T7> o6,
            Uni<? extends T8> o7) {
        super(source, Arrays.asList(o1, o2, o3, o4, o5, o6, o7));
    }

    @Override
    @CheckReturnValue
    public UniAndGroup8<T1, T2, T3, T4, T5, T6, T7, T8> collectFailures() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>> asTuple() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public UniAndGroup8<T1, T2, T3, T4, T5, T6, T7, T8> usingConcurrencyOf(int level) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @deprecated use {@link #with(Functions.Function8)} instead
     */
    @Deprecated(forRemoval = true)
    @CheckReturnValue
    public <O> Uni<O> combinedWith(Functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, O> combinator) {
        return with(combinator);
    }

    @CheckReturnValue
    public <O> Uni<O> with(Functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, O> combinator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    private <O> Uni<O> combine(Functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, O> combinator) {
        Function<List<?>, O> function = list -> {
            Tuples.ensureArity(list, 8);
            return combinator.apply((T1) list.get(0), (T2) list.get(1), (T3) list.get(2), (T4) list.get(3), (T5) list.get(4),
                    (T6) list.get(5), (T7) list.get(6), (T8) list.get(7));
        };
        return super.with(function);
    }

    @CheckReturnValue
    public <O> Uni<O> withUni(Functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, Uni<O>> combinator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    private <O> Uni<O> combineUni(Functions.Function8<T1, T2, T3, T4, T5, T6, T7, T8, Uni<O>> combinator) {
        Function<List<?>, Uni<O>> function = list -> {
            Tuples.ensureArity(list, 8);
            return combinator.apply((T1) list.get(0), (T2) list.get(1), (T3) list.get(2), (T4) list.get(3), (T5) list.get(4),
                    (T6) list.get(5), (T7) list.get(6), (T8) list.get(7));
        };
        return super.with(function).flatMap(Function.identity());
    }
}

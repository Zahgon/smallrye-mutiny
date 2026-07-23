package io.smallrye.mutiny.groups;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.tuples.Tuple2;
import io.smallrye.mutiny.tuples.Tuples;

/**
 * Configures the combination of 2 {@link Uni unis}.
 *
 * @param <T1> the type of item of the first {@link Uni}
 * @param <T2> the type of item of the second {@link Uni}
 */
public class UniAndGroup2<T1, T2> extends UniAndGroupIterable<T1> {

    public UniAndGroup2(Uni<? extends T1> source, Uni<? extends T2> other) {
        super(source, Collections.singletonList(other), false);
    }

    @CheckReturnValue
    public UniAndGroup2<T1, T2> collectFailures() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<Tuple2<T1, T2>> asTuple() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public UniAndGroup2<T1, T2> usingConcurrencyOf(int level) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Creates the resulting {@link Uni}. The items are combined using the given combinator function.
     *
     * @param combinator the combinator function, must not be {@code null}
     * @param <O> the type of item
     * @return the resulting {@code Uni<O>}. The items are combined into {@link O}
     * @deprecated use {@link #with(BiFunction)} instead
     */
    @Deprecated(forRemoval = true)
    @CheckReturnValue
    public <O> Uni<O> combinedWith(BiFunction<T1, T2, O> combinator) {
        return with(combinator);
    }

    @CheckReturnValue
    public <O> Uni<O> with(BiFunction<T1, T2, O> combinator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    private <O> Uni<O> combine(BiFunction<T1, T2, O> combinator) {
        Function<List<?>, O> function = list -> {
            Tuples.ensureArity(list, 2);
            T1 item1 = (T1) list.get(0);
            T2 item2 = (T2) list.get(1);
            return combinator.apply(item1, item2);
        };
        return super.with(function);
    }

    @CheckReturnValue
    public <O> Uni<O> withUni(BiFunction<T1, T2, Uni<O>> combinator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    private <O> Uni<O> combineUni(BiFunction<T1, T2, Uni<O>> combinator) {
        Function<List<?>, Uni<O>> function = list -> {
            Tuples.ensureArity(list, 2);
            T1 item1 = (T1) list.get(0);
            T2 item2 = (T2) list.get(1);
            return combinator.apply(item1, item2);
        };
        return super.with(function).flatMap(Function.identity());
    }
}

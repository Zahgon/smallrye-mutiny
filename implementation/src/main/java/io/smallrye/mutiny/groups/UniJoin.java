package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.*;

import java.util.ArrayList;
import java.util.List;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.CompositeException;
import io.smallrye.mutiny.Uni;

/**
 * Join multiple {@link Uni Unis}.
 * <p>
 * <strong>Note about emptiness in {@code Uni.join().first(...)}:</strong> If the set of Unis is empty, the set is rejected.
 * Joining an empty set would not propagate any event as it would not subscribe to anything.
 * As a result, you cannot join empty sets of Unis. An {@link IllegalArgumentException} will be thrown in this case.
 * </p>
 */
public class UniJoin {

    public static final UniJoin SHARED_INSTANCE = new UniJoin();

    private UniJoin() {
        // Do nothing
    }

    @SafeVarargs
    @CheckReturnValue
    public final <T> JoinAllStrategy<T> all(Uni<T>... unis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public final <T> JoinAllStrategy<T> all(List<Uni<T>> unis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Terminal interface for {@link UniJoin#all(List)}
     *
     * @param <T> the type of the {@link Uni} values
     */
    public interface JoinAllStrategyTerminal<T> {

        /**
         * Wait for all {@link Uni} references to terminate, and collect all failures in a
         * {@link io.smallrye.mutiny.CompositeException}.
         *
         * @return a new {@link Uni}
         */
        @CheckReturnValue
        Uni<List<T>> andCollectFailures();

        /**
         * Immediately forward the first failure from any of the {@link Uni}, and cancel the remaining {@link Uni}
         * subscriptions, ignoring eventual subsequent failures.
         *
         * @return a new {@link Uni}
         */
        @CheckReturnValue
        Uni<List<T>> andFailFast();
    }

    /**
     * Defines how to deal with failures while joining {@link Uni} references with {@link UniJoin#all(List)}.
     *
     * @param <T> the type of the {@link Uni} values
     */
    public static class JoinAllStrategy<T> implements JoinAllStrategyTerminal<T> {

        private final List<Uni<T>> unis;

        private int concurrency = -1;

        private JoinAllStrategy(List<Uni<T>> unis) {
            this.unis = unis;
        }

        @CheckReturnValue
        public JoinAllStrategyTerminal<T> usingConcurrencyOf(int limit) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @CheckReturnValue
        public Uni<List<T>> andCollectFailures() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @CheckReturnValue
        public Uni<List<T>> andFailFast() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @SafeVarargs
    @CheckReturnValue
    public final <T> JoinFirstStrategy<T> first(Uni<T>... unis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public final <T> JoinFirstStrategy<T> first(List<Uni<T>> unis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Terminal interface for {@link UniJoin#first(List)}
     *
     * @param <T> the type of the {@link Uni} values
     */
    public interface JoinFirstStrategyTerminal<T> {

        /**
         * Forward the value from the first {@link Uni} to terminate with a value.
         * <p>
         * When all {@link Uni} references fail then failures are collected into a {@link CompositeException},
         * which is then forwarded by the returned {@link Uni}.
         *
         * @return a new {@link Uni}
         */
        @CheckReturnValue
        Uni<T> withItem();
    }

    /**
     * Defines how to deal with failures while joining {@link Uni} references with {@link UniJoin#first(List)}}.
     *
     * @param <T> the type of the {@link Uni} values
     */
    public static class JoinFirstStrategy<T> implements JoinFirstStrategyTerminal<T> {

        private final List<Uni<T>> unis;

        private int concurrency = -1;

        private JoinFirstStrategy(List<Uni<T>> unis) {
            this.unis = unis;
        }

        @CheckReturnValue
        public JoinFirstStrategyTerminal<T> usingConcurrencyOf(int limit) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @CheckReturnValue
        public Uni<T> toTerminate() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @CheckReturnValue
        public Uni<T> withItem() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @CheckReturnValue
    public <T> Builder<T> builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Builder to assemble {@link Uni} references to be joined.
     *
     * @param <T> the type of the {@link Uni} values
     */
    public class Builder<T> {

        private final List<Uni<T>> unis = new ArrayList<>();

        @CheckReturnValue
        public Builder<T> add(Uni<T> uni) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @CheckReturnValue
        public JoinAllStrategy<T> joinAll() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @CheckReturnValue
        public JoinFirstStrategy<T> joinFirst() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

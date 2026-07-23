package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import io.smallrye.mutiny.operators.multi.MultiCollectorOp;

/**
 * Collects / aggregates items from the upstream and send the resulting <em>collection</em> / structure when the
 * upstream completes. The resulting structure is emitted through a {@link Uni}.
 * <p>
 * <strong>IMPORTANT:</strong> Do not use on unbounded streams, as it would lead to {@link OutOfMemoryError}.
 *
 * @param <T> the type of item sent by the upstream.
 */
public class MultiCollect<T> {

    private final Multi<T> upstream;

    public MultiCollect(Multi<T> upstream) {
        this.upstream = nonNull(upstream, "upstream");
    }

    @CheckReturnValue
    public Uni<T> first() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> last() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<List<T>> asList() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<Set<T>> asSet() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <X, A> Uni<X> with(Collector<? super T, A, ? extends X> collector) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <X> Uni<X> in(Supplier<X> supplier, BiConsumer<X, T> accumulator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <K> Uni<Map<K, T>> asMap(Function<? super T, ? extends K> keyMapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <K, V> Uni<Map<K, V>> asMap(Function<? super T, ? extends K> keyMapper,
            Function<? super T, ? extends V> valueMapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <K, V> Uni<Map<K, V>> asMap(Function<? super T, ? extends K> keyMapper, Function<? super T, ? extends V> valueMapper,
            BinaryOperator<V> mergeFunction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <K, V> Uni<Map<K, Collection<V>>> asMultiMap(Function<? super T, ? extends K> keyMapper,
            Function<? super T, ? extends V> valueMapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <K> Uni<Map<K, Collection<T>>> asMultiMap(Function<? super T, ? extends K> keyMapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiCollect<T> where(Predicate<T> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiCollect<T> when(Function<? super T, Uni<Boolean>> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T, A, R> Uni<R> collector(Multi<T> upstream, Collector<? super T, A, ? extends R> collector,
            boolean acceptNullAsInitialValue) {
        Multi<R> multi = Infrastructure.onMultiCreation(new MultiCollectorOp<>(upstream, collector, acceptNullAsInitialValue));
        return Uni.createFrom().publisher(multi);
    }
}

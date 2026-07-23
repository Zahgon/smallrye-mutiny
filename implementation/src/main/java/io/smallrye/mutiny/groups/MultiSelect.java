package io.smallrye.mutiny.groups;

import java.time.Duration;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.multi.*;

/**
 * Selects items from the upstream {@link Multi}.
 *
 * @param <T> the type of item
 * @see MultiSkip
 */
public class MultiSelect<T> {

    private final Multi<T> upstream;

    public MultiSelect(Multi<T> upstream) {
        this.upstream = upstream;
    }

    @CheckReturnValue
    public Multi<T> first() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> last() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> first(long n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> last(int n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> first(Predicate<? super T> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> first(Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> where(Predicate<? super T> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> where(Predicate<? super T> predicate, int limit) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> when(Function<? super T, Uni<Boolean>> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> distinct() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> distinct(Comparator<? super T> comparator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <K> Multi<T> distinct(Function<T, K> keyExtractor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

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
 * Skips items from the upstream {@link Multi}.
 *
 * @param <T> the type of item
 * @see MultiSelect
 */
public class MultiSkip<T> {

    private final Multi<T> upstream;

    public MultiSkip(Multi<T> upstream) {
        this.upstream = upstream;
    }

    @CheckReturnValue
    public Multi<T> first(long n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> first() {
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
    public Multi<T> last(int n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> last() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> repetitions() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> repetitions(Comparator<? super T> comparator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> where(Predicate<? super T> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> when(Function<? super T, Uni<Boolean>> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

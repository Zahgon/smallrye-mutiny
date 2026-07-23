package io.smallrye.mutiny.math;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.tuples.Tuple2;

/**
 * A set of Mutiny operators related to various mathematical functions.
 * These operators are intended to be used using {@code plug}. For example:
 * {@code multi.plug(Math.count())}
 */
public class Math {

    private Math() {
    }

    public static <T> Function<Multi<T>, Multi<Long>> count() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T extends Number> Function<Multi<T>, Multi<Double>> sum() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Function<Multi<T>, Multi<Tuple2<Long, T>>> index() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T extends Number> Function<Multi<T>, Multi<Double>> average() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T extends Number & Comparable<T>> Function<Multi<T>, Multi<Double>> median() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T extends Number & Comparable<T>> Function<Multi<T>, Multi<Statistic<T>>> statistics() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T extends Comparable<T>> Function<Multi<T>, Multi<T>> min() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T extends Comparable<T>> Function<Multi<T>, Multi<T>> max() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T extends Comparable<T>> Function<Multi<T>, Multi<List<T>>> top(int count) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Function<Multi<T>, Multi<Map<T, Long>>> occurrence() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package io.smallrye.mutiny.math;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.function.Function;

import io.smallrye.mutiny.Multi;

public class TopOperator<T extends Comparable<T>> implements Function<Multi<T>, Multi<List<T>>> {

    private final int count;

    private final SortedSet<T> list;

    public TopOperator(int count) {
        this.count = count;
        this.list = new ConcurrentSkipListSet<>(Comparator.reverseOrder());
    }

    @Override
    public Multi<List<T>> apply(Multi<T> multi) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package io.smallrye.mutiny.operators.multi;

import java.util.List;
import java.util.concurrent.Flow.Publisher;

import io.smallrye.mutiny.Multi;

public class MultiCombine {

    private MultiCombine() {
        // avoid direct instantiation.
    }

    public static <T> Multi<T> merge(List<Publisher<T>> participants, boolean collectFailures, int requests, int concurrency) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

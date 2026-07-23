package io.smallrye.mutiny.groups;

import java.util.concurrent.Flow;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;

/**
 * Creates new {@link Multi} by merging several {@link Multi} or {@link Flow.Publisher}.
 * <p>
 * This class allows configuring how the merge is executed. Unlike a concatenation, a merge emits the items as they
 * come, so the items may be interleaved.
 */
public class MultiMerge {

    private final boolean collectFailures;

    private final int requests;

    private final int concurrency;

    MultiMerge(boolean collectFailures, int requests, int concurrency) {
        this.collectFailures = collectFailures;
        this.requests = requests;
        this.concurrency = concurrency;
    }

    @SafeVarargs
    @CheckReturnValue
    public final <T> Multi<T> streams(Flow.Publisher<T>... publishers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> streams(Iterable<? extends Flow.Publisher<T>> iterable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiMerge collectFailures() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiMerge withRequests(int requests) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiMerge withConcurrency(int concurrency) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

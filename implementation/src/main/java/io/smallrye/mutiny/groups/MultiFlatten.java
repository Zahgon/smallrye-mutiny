package io.smallrye.mutiny.groups;

import java.util.concurrent.Flow.Publisher;
import java.util.function.Function;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;

/**
 * The object to tune the <em>flatMap</em> operation
 *
 * @param <I> the type of item emitted by the upstream {@link Multi}
 * @param <O> the type of item emitted by the returned {@link Multi}
 */
public class MultiFlatten<I, O> {

    private final Function<? super I, ? extends Publisher<? extends O>> mapper;

    private final Multi<I> upstream;

    private final int requests;

    private final boolean collectFailureUntilCompletion;

    MultiFlatten(Multi<I> upstream, Function<? super I, ? extends Publisher<? extends O>> mapper, int requests,
            boolean collectFailures) {
        this.upstream = upstream;
        this.mapper = mapper;
        this.requests = requests;
        this.collectFailureUntilCompletion = collectFailures;
    }

    @CheckReturnValue
    public MultiFlatten<I, O> collectFailures() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiFlatten<I, O> withRequests(int requests) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<O> merge() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<O> merge(int concurrency) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<O> concatenate(boolean prefetch) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<O> concatenate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

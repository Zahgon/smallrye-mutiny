package io.smallrye.mutiny.groups;

import java.util.concurrent.Flow.Publisher;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;

/**
 * Creates new {@link Multi} by concatenating several {@link Multi} or {@link Publisher}.
 * This class allows configuring how the concatenation is executed. Unlike a merge, a concatenation emits the items in
 * order. Streams are read one-by-one and the items are emitted in this order.
 */
public class MultiConcat {

    private boolean collectFailures;

    public MultiConcat(boolean collectFailures) {
        this.collectFailures = collectFailures;
    }

    @SafeVarargs
    @CheckReturnValue
    public final <T> Multi<T> streams(Publisher<T>... publishers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Multi<T> streams(Iterable<? extends Publisher<T>> iterable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiConcat collectFailures() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

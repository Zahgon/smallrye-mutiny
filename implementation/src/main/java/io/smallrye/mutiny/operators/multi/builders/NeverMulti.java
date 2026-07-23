package io.smallrye.mutiny.operators.multi.builders;

import java.util.concurrent.Flow.Publisher;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * Represents a publisher that does not emits any signals (items, failures or completion).
 */
public final class NeverMulti extends AbstractMulti<Object> {

    private static final Publisher<Object> NEVER = new NeverMulti();

    @SuppressWarnings("unchecked")
    public static <T> Multi<T> never() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private NeverMulti() {
        // avoid direct instantiation
    }

    @Override
    public void subscribe(MultiSubscriber<? super Object> actual) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

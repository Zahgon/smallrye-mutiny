package io.smallrye.mutiny.operators.uni.builders;

import java.util.function.Supplier;

import io.smallrye.mutiny.operators.AbstractUni;
import io.smallrye.mutiny.subscription.UniSubscriber;

/**
 * Specialized {@link io.smallrye.mutiny.Uni} implementation for the case where the item is produced by a supplier.
 * The supplied item can be {@code null}.
 *
 * @param <T> the type of the item
 */
public class UniCreateFromItemSupplier<T> extends AbstractUni<T> {

    private final Supplier<? extends T> supplier;

    public UniCreateFromItemSupplier(Supplier<? extends T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public void subscribe(UniSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

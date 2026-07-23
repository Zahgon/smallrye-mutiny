package io.smallrye.mutiny.operators.uni.builders;

import java.util.function.Supplier;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.AbstractUni;
import io.smallrye.mutiny.subscription.UniSubscriber;

public class UniCreateFromDeferredSupplier<T> extends AbstractUni<T> {

    private final Supplier<Uni<? extends T>> supplier;

    public UniCreateFromDeferredSupplier(Supplier<Uni<? extends T>> supplier) {
        this.supplier = supplier;
    }

    @Override
    public void subscribe(UniSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

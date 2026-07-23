package io.smallrye.mutiny.operators.multi.builders;

import java.util.concurrent.Flow;
import java.util.function.Supplier;

import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class DeferredMulti<T> extends AbstractMulti<T> {

    private final Supplier<? extends Flow.Publisher<? extends T>> supplier;

    public DeferredMulti(Supplier<? extends Flow.Publisher<? extends T>> supplier) {
        this.supplier = supplier;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

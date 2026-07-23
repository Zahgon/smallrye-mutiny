package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.function.Supplier;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.MultiOperator;

public class MultiSwitchOnEmpty<T> extends MultiOperator<T, T> {

    private final Supplier<Publisher<? extends T>> supplier;

    public MultiSwitchOnEmpty(Multi<T> upstream, Supplier<Publisher<? extends T>> supplier) {
        super(upstream);
        this.supplier = supplier;
    }

    @Override
    public void subscribe(Subscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

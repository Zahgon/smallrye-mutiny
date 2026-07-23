package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Publisher;
import java.util.function.Supplier;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.MultiOperator;

public class MultiSwitchOnCompletion<T> extends MultiOperator<T, T> {

    private final Supplier<Publisher<? extends T>> supplier;

    public MultiSwitchOnCompletion(Multi<T> upstream, Supplier<Publisher<? extends T>> supplier) {
        super(upstream);
        this.supplier = supplier;
    }

    @Override
    public void subscribe(Flow.Subscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

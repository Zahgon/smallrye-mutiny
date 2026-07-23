package io.smallrye.mutiny.operators.uni.builders;

import java.util.function.Consumer;

import io.smallrye.mutiny.operators.AbstractUni;
import io.smallrye.mutiny.subscription.UniEmitter;
import io.smallrye.mutiny.subscription.UniSubscriber;

public class UniCreateWithEmitter<T> extends AbstractUni<T> {

    private final Consumer<UniEmitter<? super T>> consumer;

    public UniCreateWithEmitter(Consumer<UniEmitter<? super T>> consumer) {
        this.consumer = consumer;
    }

    @Override
    public void subscribe(UniSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

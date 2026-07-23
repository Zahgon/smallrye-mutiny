package io.smallrye.mutiny.helpers.spies;

import java.util.function.Predicate;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiOnFailureSpy<T> extends MultiSpyBase<T> {

    private Predicate<? super Throwable> predicate;

    private Class<? extends Throwable> typeOfFailure;

    private volatile Throwable lastFailure;

    public Throwable lastFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    MultiOnFailureSpy(Multi<? extends T> upstream) {
        super(upstream);
    }

    MultiOnFailureSpy(Multi<? extends T> upstream, Predicate<? super Throwable> predicate) {
        super(upstream);
        this.predicate = predicate;
    }

    MultiOnFailureSpy(Multi<? extends T> upstream, Class<? extends Throwable> typeOfFailure) {
        super(upstream);
        this.typeOfFailure = typeOfFailure;
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> dowstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

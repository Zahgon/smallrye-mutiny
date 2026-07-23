package io.smallrye.mutiny.helpers.spies;

import java.util.function.Predicate;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.UniSubscriber;

public class UniOnFailureSpy<T> extends UniSpyBase<T> {

    private Predicate<? super Throwable> predicate;

    private Class<? extends Throwable> typeOfFailure;

    private volatile Throwable lastFailure;

    public Throwable lastFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    UniOnFailureSpy(Uni<T> upstream) {
        super(upstream);
    }

    UniOnFailureSpy(Uni<T> upstream, Predicate<? super Throwable> predicate) {
        super(upstream);
        this.predicate = predicate;
    }

    UniOnFailureSpy(Uni<T> upstream, Class<? extends Throwable> typeOfFailure) {
        super(upstream);
        this.typeOfFailure = typeOfFailure;
    }

    @Override
    public void subscribe(UniSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

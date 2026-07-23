package io.smallrye.mutiny.helpers.spies;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.UniSubscriber;

public class UniGlobalSpy<T> extends UniSpyBase<T> {

    private final UniOnCancellationSpy<T> onCancellationSpy;

    private final UniOnFailureSpy<T> onFailureSpy;

    private final UniOnItemOrFailureSpy<T> onItemOrFailureSpy;

    private final UniOnItemSpy<T> onItemSpy;

    private final UniOnSubscribeSpy<T> onSubscribeSpy;

    private final UniOnTerminationSpy<T> onTerminationSpy;

    UniGlobalSpy(Uni<T> upstream) {
        super(upstream);
        onCancellationSpy = Spy.onCancellation(upstream);
        onFailureSpy = Spy.onFailure(onCancellationSpy);
        onItemOrFailureSpy = Spy.onItemOrFailure(onFailureSpy);
        onItemSpy = Spy.onItem(onItemOrFailureSpy);
        onSubscribeSpy = Spy.onSubscribe(onItemSpy);
        onTerminationSpy = Spy.onTermination(onSubscribeSpy);
    }

    public UniOnCancellationSpy<T> onCancellationSpy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniOnFailureSpy<T> onFailureSpy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniOnItemOrFailureSpy<T> onItemOrFailureSpy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniOnItemSpy<T> onItemSpy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniOnSubscribeSpy<T> onSubscribeSpy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniOnTerminationSpy<T> onTerminationSpy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long invocationCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean invoked() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
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

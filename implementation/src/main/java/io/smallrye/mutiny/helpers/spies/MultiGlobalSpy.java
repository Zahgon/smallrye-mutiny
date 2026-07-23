package io.smallrye.mutiny.helpers.spies;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiGlobalSpy<T> extends MultiSpyBase<T> {

    private final MultiOnCancellationSpy<T> onCancellationSpy;

    private final MultiOnCompletionSpy<T> onCompletionSpy;

    private final MultiOnFailureSpy<T> onFailureSpy;

    private final MultiOnItemSpy<T> onItemSpy;

    private final MultiOnRequestSpy<T> onRequestSpy;

    private final MultiOnSubscribeSpy<T> onSubscribeSpy;

    private final MultiOnTerminationSpy<T> onTerminationSpy;

    MultiGlobalSpy(Multi<T> upstream) {
        super(upstream);
        onCancellationSpy = Spy.onCancellation(upstream);
        onCompletionSpy = Spy.onCompletion(onCancellationSpy);
        onFailureSpy = Spy.onFailure(onCompletionSpy);
        onItemSpy = Spy.onItem(onFailureSpy);
        onRequestSpy = Spy.onRequest(onItemSpy);
        onSubscribeSpy = Spy.onSubscribe(onRequestSpy);
        onTerminationSpy = Spy.onTermination(onSubscribeSpy);
    }

    public MultiOnCancellationSpy<T> onCancellationSpy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MultiOnCompletionSpy<T> onCompletionSpy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MultiOnFailureSpy<T> onFailureSpy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MultiOnItemSpy<T> onItemSpy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MultiOnRequestSpy<T> onRequestSpy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MultiOnSubscribeSpy<T> onSubscribeSpy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MultiOnTerminationSpy<T> onTerminationSpy() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
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
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

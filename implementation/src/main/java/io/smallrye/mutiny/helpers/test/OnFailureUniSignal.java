package io.smallrye.mutiny.helpers.test;

/**
 * A onFailure signal.
 */
public final class OnFailureUniSignal implements UniSignal {

    private final Throwable failure;

    public OnFailureUniSignal(Throwable failure) {
        this.failure = failure;
    }

    @Override
    public Throwable value() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

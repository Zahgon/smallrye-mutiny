package io.smallrye.mutiny.subscription;

import io.smallrye.mutiny.Context;

/**
 * Interface for subscribers and types that provide a {@link Context}.
 */
public interface ContextSupport {

    default Context context() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

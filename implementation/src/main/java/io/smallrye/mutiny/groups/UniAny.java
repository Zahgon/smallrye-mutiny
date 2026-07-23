package io.smallrye.mutiny.groups;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Uni;

public class UniAny {

    public static final UniAny INSTANCE = new UniAny();

    private UniAny() {
        // avoid direct instantiation.
    }

    @SafeVarargs
    @CheckReturnValue
    public final <T> Uni<T> of(Uni<? super T>... unis) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public <T> Uni<T> of(Iterable<? extends Uni<? super T>> iterable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

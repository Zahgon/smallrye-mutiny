package io.smallrye.mutiny.groups;

import io.smallrye.common.annotation.CheckReturnValue;

public class UniCombine {

    public static final UniCombine INSTANCE = new UniCombine();

    private UniCombine() {
        // avoid direct instantiation
    }

    @CheckReturnValue
    public UniAny any() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public UniZip all() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

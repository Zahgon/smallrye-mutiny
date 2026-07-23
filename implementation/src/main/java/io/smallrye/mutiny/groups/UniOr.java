package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Uni;

public class UniOr<T> {

    private final Uni<T> upstream;

    public UniOr(Uni<T> upstream) {
        this.upstream = nonNull(upstream, "upstream");
    }

    @SafeVarargs
    @CheckReturnValue
    public final Uni<T> unis(Uni<T>... other) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.time.Duration;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Uni;

public class UniIfNoItem<T> {

    private final Uni<T> upstream;

    public UniIfNoItem(Uni<T> upstream) {
        this.upstream = nonNull(upstream, "upstream");
    }

    @CheckReturnValue
    public UniOnTimeout<T> after(Duration timeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

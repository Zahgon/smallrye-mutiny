package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.concurrent.Flow.Publisher;
import java.util.function.Function;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;

/**
 * Converts the upstream into another reactive type.
 *
 * @param <T> the type of item emitted by the upstream.
 */
public class MultiConvert<T> {

    private final Multi<T> upstream;

    public MultiConvert(Multi<T> upstream) {
        this.upstream = nonNull(upstream, "upstream");
    }

    public <R> R with(Function<Multi<T>, R> converter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Publisher<T> toPublisher() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

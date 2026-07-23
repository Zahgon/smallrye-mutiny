package io.smallrye.mutiny.groups;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.UniSubscription;

/**
 * Group to configure the action to execute when the observed {@link Uni} sends a {@link UniSubscription}.
 * The downstream don't have a subscription yet. It will be passed once the configured action completes.
 *
 * <p>
 * Example:
 * </p>
 *
 * <pre>
 * {@code
 * uni.onSubscription().invoke(sub -> System.out.println("subscribed"));
 * // Delay the subscription by 1 second (or until an asynchronous action completes)
 * uni.onSubscription().call(sub -> Uni.createFrom(1).onItem().delayIt().by(Duration.ofSecond(1)));
 * }
 * </pre>
 *
 * @param <T> the type of item
 */
public class UniOnSubscribe<T> {

    private final Uni<T> upstream;

    public UniOnSubscribe(Uni<T> upstream) {
        this.upstream = nonNull(upstream, "upstream");
    }

    @CheckReturnValue
    public Uni<T> invoke(Consumer<? super UniSubscription> callback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> invoke(Runnable callback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> call(Function<? super UniSubscription, Uni<?>> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Uni<T> call(Supplier<Uni<?>> action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

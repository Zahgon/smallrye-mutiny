package io.smallrye.mutiny.groups;

import java.time.Duration;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;

/**
 * Makes the upstream {@link Multi} be able to broadcast its events ({@code items}, {@code failure}, and
 * {@code completion}) to multiple subscribers.
 * <p>
 * Broadcast transforms the upstream into a <em>hot streams</em> meaning that late subscriber won't see all the events.
 *
 * @param <T> the type of item
 */
public class MultiBroadcast<T> {

    private final Multi<T> upstream;

    private boolean cancelWhenNoOneIsListening;

    private Duration delayAfterLastDeparture;

    public MultiBroadcast(Multi<T> upstream) {
        this.upstream = upstream;
    }

    @CheckReturnValue
    public Multi<T> toAllSubscribers() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> toAtLeast(int numberOfSubscribers) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiBroadcast<T> withCancellationAfterLastSubscriberDeparture() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiBroadcast<T> withCancellationAfterLastSubscriberDeparture(Duration delay) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

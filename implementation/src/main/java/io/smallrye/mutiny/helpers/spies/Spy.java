package io.smallrye.mutiny.helpers.spies;

import java.util.function.Function;
import java.util.function.Predicate;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.groups.MultiOverflowStrategy;

/**
 * Helpers for creating {@link Uni} and {@link Multi} spies to observe events.
 * <p>
 * A spy is a transparent operator that can be plugged into a pipeline to help diagnose what events flow.
 * It observes how many times a given event has been observed.
 * Depending on the event type it will also report values, such as the last observed failure or termination.
 * <p>
 * It is important to note that spies observe and report events for all subscribers, not just one in particular.
 */
public interface Spy {

    // --------------------------------------------------------------------- //
    static <T> UniOnSubscribeSpy<T> onSubscribe(Uni<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> UniOnCancellationSpy<T> onCancellation(Uni<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> UniOnTerminationSpy<T> onTermination(Uni<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> UniOnItemSpy<T> onItem(Uni<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> UniOnItemOrFailureSpy<T> onItemOrFailure(Uni<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> UniOnFailureSpy<T> onFailure(Uni<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> UniOnFailureSpy<T> onFailure(Uni<T> upstream, Predicate<? super Throwable> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> UniOnFailureSpy<T> onFailure(Uni<T> upstream, Class<? extends Throwable> typeOfFailure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> UniGlobalSpy<T> globally(Uni<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // --------------------------------------------------------------------- //
    static <T> MultiOnCancellationSpy<T> onCancellation(Multi<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> MultiOnCompletionSpy<T> onCompletion(Multi<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> MultiOnFailureSpy<T> onFailure(Multi<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> MultiOnFailureSpy<T> onFailure(Multi<T> upstream, Predicate<? super Throwable> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> MultiOnFailureSpy<T> onFailure(Multi<T> upstream, Class<? extends Throwable> typeOfFailure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> MultiOnItemSpy<T> onItem(Multi<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> MultiOnItemSpy<T> onItem(Multi<T> upstream, boolean trackItems) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> MultiOnRequestSpy<T> onRequest(Multi<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> MultiOnSubscribeSpy<T> onSubscribe(Multi<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> MultiOnTerminationSpy<T> onTermination(Multi<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> MultiOnOverflowSpy<T> onOverflow(Multi<T> upstream,
            Function<MultiOverflowStrategy<? extends T>, Multi<? extends T>> strategyMapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> MultiOnOverflowSpy<T> onOverflow(Multi<T> upstream, boolean trackItems,
            Function<MultiOverflowStrategy<? extends T>, Multi<? extends T>> strategyMapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> MultiGlobalSpy<T> globally(Multi<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

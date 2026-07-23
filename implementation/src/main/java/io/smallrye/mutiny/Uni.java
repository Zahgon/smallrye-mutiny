package io.smallrye.mutiny;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Executor;
import java.util.function.*;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.groups.*;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

/**
 * A {@link Uni} represents a lazy asynchronous action. It follows the subscription pattern, meaning that the action
 * is only triggered once a {@link UniSubscriber} subscribes to the {@link Uni}.
 * <p>
 * A {@link Uni} can have two outcomes:
 * <ol>
 * <li>An {@code item} event, forwarding the completion of the action (potentially {@code null} if the item
 * does not represent a value, but the action was completed successfully)</li>
 * <li>A {@code failure} event, forwarding an exception</li>
 * </ol>
 * <p>
 * To trigger the computation, a {@link UniSubscriber} must subscribe to the Uni. It will be notified of the outcome
 * once there is an {@code item} or {@code failure} event fired by the observed Uni. A subscriber receives
 * (asynchronously) a {@link UniSubscription} and can cancel the demand at any time. Note that cancelling after
 * having received the outcome is a no-op.
 * <p>
 *
 * @param <T> the type of item produced by the {@link Uni}
 */
public interface Uni<T> {

    @CheckReturnValue
    static UniCreate createFrom() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default <O> O stage(Function<Uni<T>, O> stage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    static UniCombine combine() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Requests the {@link Uni} to start resolving the item and allows configuring how the signals are propagated
     * (using a {@link UniSubscriber}, callbacks, or a {@link CompletionStage}. Unlike {@link #await()}, this method
     * configures non-blocking retrieval of the item and failure.
     *
     * <p>
     * Examples:
     * </p>
     *
     * <pre>
     * {@code
     *     Uni<String> uni = ...;
     *
     *    Subscription sub = uni.subscribe().with( // The return subscription can be used to cancel the operation
     *              item -> {},           // Callback calls on item
     *              failure -> {}           // Callback calls on failure
     *    );
     *
     *    UniSubscriber<String> myUniSubscriber = ...
     *    uni.subscribe().withSubscriber(myUniSubscriber); // Subscribes to the Uni with the passed subscriber
     *
     *    CompletableFuture future = uni.subscribe().asCompletableFuture(); // Get a CompletionStage receiving the item or failure
     *    // Cancelling the returned future cancels the subscription.
     * }
     * </pre>
     *
     * @return the object to configure the subscription.
     * @see #await() <code>uni.await() </code>for waiting (blocking the caller thread) until the resolution of the observed Uni.
     */
    @CheckReturnValue
    UniSubscribe<T> subscribe();

    @CheckReturnValue
    default CompletableFuture<T> subscribeAsCompletionStage() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default CompletableFuture<T> subscribeAsCompletionStage(Context context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Awaits (blocking the caller thread) until the item or a failure is emitted by the observed {@link Uni}.
     * If the observed uni fails, the failure is thrown. In the case of a checked exception, the exception is wrapped
     * into a {@link java.util.concurrent.CompletionException}.
     *
     * <p>
     * Examples:
     * </p>
     *
     * <pre>
     * {@code
     * Uni<T> uni = ...;
     * T res = uni.await().indefinitely(); // Await indefinitely until it get the item.
     * T res = uni.await().atMost(Duration.ofMillis(1000)); // Awaits at most 1s. After that, a TimeoutException is thrown
     * Optional<T> res = uni.await().asOptional().indefinitely(); // Retrieves the item as an Optional, empty if the item is null
     * }
     * </pre>
     *
     * @return the object to configure the retrieval.
     */
    @CheckReturnValue
    UniAwait<T> await();

    @CheckReturnValue
    default UniAwait<T> awaitUsing(Context context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Configures the action to execute when the observed {@link Uni} emits the item (potentially {@code null}).
     *
     * <p>
     * Examples:
     * </p>
     *
     * <pre>
     * {@code
     * Uni<T> uni = ...;
     * uni.onItem().transform(x -> ...); // Transform the item into another item (~ map)
     * uni.onItem().transformToUni(x -> ...); // Transform the item into a Uni (~ flatMap)
     * }
     * </pre>
     *
     * @return the object to configure the action to execute when an item is emitted
     */
    @CheckReturnValue
    UniOnItem<T> onItem();

    /**
     * Configures the action to execute when the observed {@link Uni} sends a {@link UniSubscription}.
     * The downstream does not have a subscription yet. It will be passed once the configured action completes.
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
     * @return the object to configure the action to execution on subscription.
     */
    @CheckReturnValue
    UniOnSubscribe<T> onSubscription();

    /**
     * Configures the action to execute when the observed {@link Uni} emits either an item (potentially {@code null}))
     * or a failure. Unlike {@link #onItem()} and {@link #onFailure()} the action would handle both cases in on "go".
     *
     * @return the object to configure the action to execute when an item is emitted or when a failure is propagated.
     */
    @CheckReturnValue
    UniOnItemOrFailure<T> onItemOrFailure();

    /**
     * Like {@link #onFailure(Predicate)} but applied to all failures fired by the upstream uni.
     * It allows configuring the on failure behavior (recovery, retry...).
     *
     * @return a UniOnFailure on which you can specify the on failure action
     */
    @CheckReturnValue
    UniOnFailure<T, Throwable> onFailure();

    /**
     * Configures a predicate filtering the failures on which the behavior (specified with the returned
     * {@link UniOnFailure}) is applied.
     * <p>
     * For instance, to only when an {@code IOException} is fired as failure you can use:
     * <code>uni.onFailure(IOException.class).recoverWithItem("hello")</code>
     * <p>
     * The fallback value ({@code hello}) will only be used if the upstream uni fire a failure of type
     * {@code IOException}.
     *
     * @param predicate the predicate, {@code null} means applied to all failures
     * @return a UniOnFailure configured with the given predicate on which you can specify the on failure action
     */
    @CheckReturnValue
    UniOnFailure<T, Throwable> onFailure(Predicate<? super Throwable> predicate);

    /**
     * Configures a type of failure filtering the failures on which the behavior (specified with the returned
     * {@link UniOnFailure}) is applied.
     * <p>
     * For instance, to only when an {@code IOException} is fired as failure you can use:
     * <code>uni.onFailure(IOException.class).recoverWithItem("hello")</code>
     * <p>
     * The fallback value ({@code hello}) will only be used if the upstream uni fire a failure of type
     * {@code IOException}.
     *
     * @param typeOfFailure the class of exception, must not be {@code null}
     * @return a UniOnFailure configured with the given predicate on which you can specify the on failure action
     */
    @CheckReturnValue
    <E extends Throwable> UniOnFailure<T, E> onFailure(Class<E> typeOfFailure);

    /**
     * Produces a {@link Uni} reacting when a no item event is fired by the upstream uni during the specified time
     * period.
     * <p>
     * This {@link Uni} detects if this {@link Uni} does not emit an item before the configured timeout.
     * <p>
     * Examples:
     *
     * <pre>{@code
     * uni.ifNoItem().after(Duration.ofMillis(1000)).fail() // Propagate a TimeOutException
     * uni.ifNoItem().after(Duration.ofMillis(1000)).recoverWithValue("fallback") // Inject a fallback item on timeout
     * uni.ifNoItem().after(Duration.ofMillis(1000)).on(myExecutor)... // Configure the executor calling on timeout actions
     * uni.ifNoItem().after(Duration.ofMillis(1000)).fail().onFailure().retry().atMost(5) // Retry five times
     * }</pre>
     *
     * @return the on timeout group
     */
    @CheckReturnValue
    UniIfNoItem<T> ifNoItem();

    /**
     * Produces a new {@link Uni} invoking the {@link UniSubscriber#onItem(Object)} and
     * {@link UniSubscriber#onFailure(Throwable)} on the supplied {@link Executor}.
     * <p>
     * Instead of receiving the {@code item} event on the thread firing the event, this method influences the
     * threading context to switch to a thread from the given executor.
     * <p>
     * <strong>Be careful as this operator can lead to concurrency problems with non thread-safe objects such as
     * CDI request-scoped beans.</strong>
     *
     * @param executor the executor to use, must not be {@code null}
     * @return a new {@link Uni}
     */
    @CheckReturnValue
    Uni<T> emitOn(Executor executor);

    /**
     * When a subscriber subscribes to this {@link Uni}, executes the subscription to the upstream {@link Uni} on a thread
     * from the given executor. As a result, the {@link UniSubscriber#onSubscribe(UniSubscription)} method will be called
     * on this thread (except mentioned otherwise)
     *
     * @param executor the executor to use, must not be {@code null}
     * @return a new {@link Uni}
     */
    @CheckReturnValue
    Uni<T> runSubscriptionOn(Executor executor);

    /**
     * Configure memoization of the {@link Uni} item or failure.
     *
     * @return the object to configure memoization
     */
    @CheckReturnValue
    UniMemoize<T> memoize();

    @CheckReturnValue
    default <O> Uni<O> map(Function<? super T, ? extends O> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default Uni<T> invoke(Consumer<? super T> callback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default Uni<T> invoke(Runnable callback) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default Uni<T> call(Function<? super T, Uni<?>> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default Uni<T> call(Supplier<Uni<?>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default <O> Uni<O> flatMap(Function<? super T, Uni<? extends O>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default <O> Uni<O> chain(Function<? super T, Uni<? extends O>> mapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default <O> Uni<O> chain(Supplier<Uni<? extends O>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default Uni<T> eventually(Runnable action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default <O> Uni<T> eventually(Supplier<Uni<? extends O>> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Converts an {@link Uni} to other types such as {@link CompletionStage}
     *
     * <p>
     * Examples:
     * </p>
     *
     * <pre>
     * {@code
     * uni.convert().toCompletionStage(); // Convert to CompletionStage using convenience method
     * uni.convert().with(BuiltinConverters.toCompletionStage()); // Convert to CompletionStage using BuiltInConverters
     * uni.convert().with(uni -> x); // Convert with a custom lambda converter
     * }
     * </pre>
     *
     * @return the object to convert an {@link Uni} instance
     * @see UniConvert
     */
    @CheckReturnValue
    UniConvert<T> convert();

    /**
     * Creates an instance of {@link Multi} from this {@link Uni}.
     * <p>
     * When a subscriber subscribes to the returned {@link Multi} and <strong>request</strong> an item, it subscribes
     * to this {@link Uni} and the events from this {@link Uni} are propagated to the {@link Multi}:
     * <ul>
     * <li>if this {@link Uni} emits a non-{@code null} item - this item is propagated to the {@link Multi}
     * and followed with the completion event</li>
     * <li>if this {@link Uni} emits a {@code null} item - the {@link Multi} fires the completion event</li>
     * <li>if this {@link Uni} emits a failure, this failure event is propagated by the {@link Multi}</li>
     * </ul>
     * <p>
     * It's important to note that the subscription to this {@link Uni} happens when the subscriber to the produced
     * {@link Multi} <strong>requests</strong> items, and not at subscription time.
     *
     * @return the produced {@link Multi}, never {@code null}
     */
    @CheckReturnValue
    Multi<T> toMulti();

    /**
     * Allows configuring repeating behavior.
     * Repeating allow transforming a {@link Uni} into a {@link Multi} either a specific amount of times or indefinitely.
     * Each time, a new subscription is attempted on the {@link Uni}.
     * Cancelling the subscription stops the repeating behavior.
     *
     * @return the object to configure the repeating behavior.
     */
    @CheckReturnValue
    UniRepeat<T> repeat();

    /**
     * Configures actions to be performed on termination, that is, on item, on failure, or when the subscriber cancels
     * the subscription.
     *
     * @return the object to configure the termination actions.
     */
    @CheckReturnValue
    UniOnTerminate<T> onTermination();

    /**
     * Configures actions to be performed when the subscriber cancels the subscription.
     *
     * @return the object to configure the cancellation actions.
     */
    @CheckReturnValue
    UniOnCancel<T> onCancellation();

    @CheckReturnValue
    default <R> Uni<R> plug(Function<Uni<T>, Uni<R>> operatorProvider) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default <O> Uni<O> replaceWith(O item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default <O> Uni<O> replaceWith(Supplier<O> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default <O> Uni<O> replaceWith(Uni<O> uni) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default Uni<T> replaceWithNull() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default Uni<Void> replaceWithVoid() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default Uni<T> replaceIfNullWith(Supplier<T> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default Uni<T> replaceIfNullWith(T value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Log events (onSubscribe, onItem, ...) as they come from the upstream or the subscriber.
     * <p>
     * Events will be logged as long as the {@link Uni} hasn't been cancelled or terminated.
     * Logging is framework-agnostic and can be configured in the {@link Infrastructure} class.
     *
     * @param identifier an identifier of this operator to be used in log events
     * @return a new {@link Uni}
     * @see Infrastructure#setOperatorLogger(Infrastructure.OperatorLogger)
     */
    @CheckReturnValue
    Uni<T> log(String identifier);

    /**
     * Log events (onSubscribe, onItem, ...) as they come from the upstream or the subscriber, and derives the identifier from
     * the upstream operator class "simple name".
     * <p>
     * Events will be logged as long as the {@link Uni} hasn't been cancelled or terminated.
     * Logging is framework-agnostic and can be configured in the {@link Infrastructure} class.
     *
     * @return a new {@link Uni}
     * @see Uni#log(String)
     * @see Infrastructure#setOperatorLogger(Infrastructure.OperatorLogger)
     */
    @CheckReturnValue
    Uni<T> log();

    @CheckReturnValue
    static UniJoin join() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default <R> Uni<R> withContext(BiFunction<Uni<T>, Context, Uni<R>> builder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    default Uni<ItemWithContext<T>> attachContext() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

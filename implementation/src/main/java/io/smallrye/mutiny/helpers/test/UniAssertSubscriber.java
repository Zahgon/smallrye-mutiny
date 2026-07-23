package io.smallrye.mutiny.helpers.test;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;
import static io.smallrye.mutiny.helpers.test.AssertionHelper.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.subscription.UniSubscription;

/**
 * A {@link io.smallrye.mutiny.Uni} {@link UniSubscriber} for testing purposes that comes with useful assertion helpers.
 *
 * @param <T> the type of the items
 */
public class UniAssertSubscriber<T> implements UniSubscriber<T> {

    private volatile boolean cancelImmediatelyOnSubscription;

    private final Context context;

    // Writable from the subscribers
    private final CompletableFuture<T> completion = new CompletableFuture<>();

    private final CompletableFuture<UniSubscription> subscribed = new CompletableFuture<>();

    // Readable from the assertions
    private final CompletableFuture<T> hasCompleted;

    private final CompletableFuture<UniSubscription> hasSubscription;

    private volatile UniSubscription subscription;

    private volatile T item;

    private volatile Throwable failure;

    private volatile boolean hasCompletedSuccessfully;

    private volatile String onResultThreadName;

    private volatile String onErrorThreadName;

    private volatile String onSubscribeThreadName;

    private final List<UniSignal> signals = new ArrayList<>(4);

    /**
     * Create a new {@link UniAssertSubscriber}.
     *
     * @param context the subscription context, cannot be {@code null}
     * @param cancelled {@code true} when the subscription shall be cancelled upfront, {@code false} otherwise
     */
    public UniAssertSubscriber(Context context, boolean cancelled) {
        this.context = nonNull(context, "context");
        hasCompleted = completion.whenComplete((item, failure) -> {
            if (failure == null) {
                this.onResultThreadName = Thread.currentThread().getName();
                this.hasCompletedSuccessfully = true;
                this.item = item;
            } else {
                this.onErrorThreadName = Thread.currentThread().getName();
                this.failure = failure;
            }
        }).toCompletableFuture();
        hasSubscription = subscribed.thenApply(s -> {
            this.onSubscribeThreadName = Thread.currentThread().getName();
            this.subscription = s;
            return s;
        }).toCompletableFuture();
        this.cancelImmediatelyOnSubscription = cancelled;
    }

    /**
     * Create a new {@link UniAssertSubscriber} with an upfront cancellation configuration and an empty {@link Context}.
     */
    public UniAssertSubscriber(boolean cancelled) {
        this(Context.empty(), cancelled);
    }

    /**
     * Create a new {@link UniAssertSubscriber} with no upfront cancellation and an empty {@link Context}.
     */
    public UniAssertSubscriber() {
        this(false);
    }

    public static <T> UniAssertSubscriber<T> create() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> UniAssertSubscriber<T> create(Context context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Context context() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public synchronized void onSubscribe(UniSubscription subscription) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public synchronized void onItem(T item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public synchronized void onFailure(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> awaitItem() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> awaitItem(Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> awaitFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> awaitFailure(Consumer<Throwable> assertion) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> awaitFailure(Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> awaitFailure(Consumer<Throwable> assertion, Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> awaitSubscription() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> awaitSubscription(Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void awaitEvent(CompletableFuture<?> future, Duration duration) throws TimeoutException {
        // Are we already done?
        if (future.isDone()) {
            return;
        }
        try {
            future.get(duration.toMillis(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            // Completed exceptionally, but completed anyway.
        }
    }

    public synchronized UniAssertSubscriber<T> assertCompleted() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public synchronized UniAssertSubscriber<T> assertFailed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public synchronized T getItem() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public synchronized Throwable getFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> assertItem(T expected) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> assertItem(Predicate<? super T> predicate, String description) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> assertItemIsNull() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> inspectItem(Consumer<? super T> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> assertFailedWith(Class<? extends Throwable> expectedTypeOfFailure, String expectedMessage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> assertFailedWith(Class<? extends Throwable> expectedTypeOfFailure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getOnItemThreadName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getOnFailureThreadName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getOnSubscribeThreadName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void cancel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> assertTerminated() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> assertNotTerminated() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> assertSubscribed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> assertNotSubscribed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<UniSignal> getSignals() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public UniAssertSubscriber<T> assertSignalsReceivedInOrder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

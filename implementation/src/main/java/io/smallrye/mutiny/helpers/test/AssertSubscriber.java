package io.smallrye.mutiny.helpers.test;

import static io.smallrye.mutiny.helpers.test.AssertionHelper.*;
import static java.lang.Integer.parseInt;
import static java.time.Duration.ofSeconds;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Predicate;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * A {@link io.smallrye.mutiny.Multi} {@link Subscriber} for testing purposes that comes with useful assertion helpers.
 *
 * @param <T> the type of the items
 */
public class AssertSubscriber<T> implements MultiSubscriber<T>, ContextSupport {

    /**
     * The default timeout used by {@code await} method.
     * <p>
     * This static field is mutable, the authors assume that you know what you are doing if you ever feel like changing
     * its value.
     */
    public static Duration DEFAULT_TIMEOUT;

    /**
     * Name of the environment variable for setting the default await methods timeout (in seconds).
     */
    public static final String DEFAULT_MUTINY_AWAIT_TIMEOUT = "DEFAULT_MUTINY_AWAIT_TIMEOUT";

    static {
        DEFAULT_TIMEOUT = ofSeconds(parseInt(System.getenv().getOrDefault(DEFAULT_MUTINY_AWAIT_TIMEOUT, "10")));
    }

    /**
     * Latch waiting for the completion or failure event.
     */
    private final CountDownLatch terminal = new CountDownLatch(1);

    /**
     * Latch waiting for the subscription event.
     */
    private final CountDownLatch subscribed = new CountDownLatch(1);

    /**
     * The subscription received from upstream.
     */
    private volatile Flow.Subscription subscription = null;

    /**
     * The number of pending requested items.
     */
    private final AtomicLong pendingRequests = new AtomicLong();

    /**
     * The received items.
     */
    private final List<T> items = new CopyOnWriteArrayList<>();

    /**
     * The received failure.
     */
    private volatile Throwable failure = null;

    /**
     * Number of subscription received from upstream.
     * Reactive Streams compliant upstream should only send one subscription.
     */
    private int numberOfSubscription = 0;

    /**
     * Whether or not the subscriber should cancel the subscription as soon as it receives it.
     * In this case, no request will be made.
     */
    private final boolean upfrontCancellation;

    /**
     * The subscription context.
     */
    private final Context context;

    private enum State {

        INIT,
        SUBSCRIBED,
        FAILED,
        CANCELLED,
        COMPLETED
    }

    private volatile State state = State.INIT;

    /**
     * Creates a new {@link AssertSubscriber}.
     *
     * @param context the context
     * @param requested the number of initially requested items
     * @param cancelled {@code true} if the subscription is immediately cancelled, {@code false} otherwise
     */
    public AssertSubscriber(Context context, long requested, boolean cancelled) {
        this.context = context;
        this.pendingRequests.set(requested);
        this.upfrontCancellation = cancelled;
    }

    /**
     * Creates a new {@link AssertSubscriber}.
     *
     * @param requested the number of initially requested items
     * @param cancelled {@code true} if the subscription is immediately cancelled, {@code false} otherwise
     */
    public AssertSubscriber(long requested, boolean cancelled) {
        this(Context.empty(), requested, cancelled);
    }

    /**
     * Creates a new {@link AssertSubscriber} with 0 requested items and no upfront cancellation.
     */
    public AssertSubscriber() {
        this(Context.empty(), 0, false);
    }

    /**
     * Creates a new {@link AssertSubscriber} with no upfront cancellation.
     *
     * @param requested the number of initially requested items
     */
    public AssertSubscriber(long requested) {
        this(Context.empty(), requested, false);
    }

    public static <T> AssertSubscriber<T> create() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> AssertSubscriber<T> create(long requested) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> AssertSubscriber<T> create(Context context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> AssertSubscriber<T> create(Context context, long requested) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Context context() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> assertCompleted() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> assertFailedWith(Class<? extends Throwable> expectedTypeOfFailure,
            String expectedFailureMessage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> assertFailedWith(Class<? extends Throwable> expectedTypeOfFailure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> assertHasNotReceivedAnyItem() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> assertSubscribed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> assertNotSubscribed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> assertTerminated() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> assertNotTerminated() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SafeVarargs
    public final AssertSubscriber<T> assertItems(T... expected) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T getLastItem() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> assertLastItem(T expected) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> assertLastItem(Predicate<? super T> predicate, String description) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> assertItems(Predicate<? super List<T>> predicate, String description) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> inspectItems(Consumer<? super List<T>> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> assertItemCount(int expected) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> awaitNextItem() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> awaitNextItem(Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> awaitNextItems(int number) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> awaitNextItems(int number, int request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> awaitNextItems(int number, Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> awaitNextItems(int number, int request, Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> awaitItems(int number) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> awaitItems(int number, Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // Package-private: waits until at least `number` items have been received (no overshoot error).
    // Used by AssertMulti where unbounded initial demand means items may arrive ahead of validation steps.
    void awaitAtLeastItems(int number, Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> awaitCompletion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> awaitCompletion(Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> awaitFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> awaitFailure(Consumer<Throwable> assertion) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> awaitFailure(Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> awaitFailure(Consumer<Throwable> assertion, Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> awaitSubscription() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> awaitSubscription(Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void awaitEvent(CountDownLatch latch, Duration duration) throws TimeoutException {
        // Are we already done?
        if (latch.getCount() == 0) {
            return;
        }
        try {
            if (!latch.await(duration.toMillis(), TimeUnit.MILLISECONDS)) {
                throw new TimeoutException();
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<EventListener> eventListeners = new CopyOnWriteArrayList<>();

    private void awaitNextItemEvents(int number, int request, Duration duration) {
        NextItemTask<T> task = new NextItemTask<>(number, this);
        CompletableFuture<Void> future = task.future();
        if (request > 0) {
            request(request);
        }
        int size = items.size();
        try {
            future.get(duration.toMillis(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            // Terminal event received
            int received = items.size() - size;
            if (isCancelled()) {
                throw new AssertionError("Expected " + number + " items, but received a cancellation event while waiting. Only "
                        + received + " item(s) have been received.");
            } else if (hasCompleted()) {
                throw new AssertionError("Expected " + number + " items, but received a completion event while waiting. Only "
                        + received + " item(s) have been received.");
            } else {
                throw new AssertionError("Expected " + number + " items, but received a failure event while waiting: "
                        + getFailure() + ". Only " + received + " item(s) have been received.");
            }
        } catch (TimeoutException e) {
            // Timeout
            int received = items.size() - size;
            throw new AssertionError("Expected " + number + " items in " + duration.toMillis() + " ms, but only received "
                    + received + " items.");
        }
    }

    private void awaitItemEvents(int expected, Duration duration) {
        ItemTask<T> task = new ItemTask<>(expected, duration.toMillis(), this);
        try {
            task.future().get(duration.toMillis(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException e) {
            if (items.size() >= expected) {
                return;
            }
            // Terminal event received
            if (isCancelled()) {
                throw new AssertionError(
                        "Expected " + expected + " items, but received a cancellation event while waiting. Only " + items.size()
                                + " items have been received.");
            } else if (hasCompleted()) {
                throw new AssertionError("Expected " + expected + " items, but received a completion event while waiting. Only "
                        + items.size() + " items have been received.");
            } else if (getFailure() != null) {
                throw new AssertionError("Expected " + expected + " items, but received a failure event while waiting: "
                        + getFailure() + ". Only " + items.size() + " items have been received.");
            } else {
                throw new AssertionError(
                        "Expected " + expected + " items.  Only " + items.size() + " items have been received.");
            }
        } catch (TimeoutException e) {
            // Timeout, but verify we didn't get event while timing out.
            if (items.size() >= expected) {
                return;
            }
            throw new AssertionError("Expected " + expected + " items.  Only " + items.size() + " items have been received.");
        }
    }

    public AssertSubscriber<T> cancel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public synchronized AssertSubscriber<T> request(long req) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public synchronized void onSubscribe(Flow.Subscription s) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public synchronized void onItem(T t) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onFailure(Throwable t) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void onCompletion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<T> getItems() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Throwable getFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertSubscriber<T> run(Runnable action) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isCancelled() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean hasCompleted() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void registerListener(EventListener listener) {
        eventListeners.add(listener);
    }

    private void unregisterListener(EventListener listener) {
        eventListeners.remove(listener);
    }

    private interface EventListener extends Consumer<Event> {
    }

    private record Event(Object item, Throwable failure, boolean completion, boolean cancellation) {

        public boolean isItem() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public boolean isFailure() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private record NextItemTask<T>(int expected, AssertSubscriber<T> subscriber) {

        public CompletableFuture<Void> future() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private record ItemTask<T>(int expected, long duration, AssertSubscriber<T> subscriber) {

        public CompletableFuture<Void> future() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

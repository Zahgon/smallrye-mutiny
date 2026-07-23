package io.smallrye.mutiny.helpers.test;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

import io.smallrye.common.annotation.Experimental;
import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;

/**
 * A declarative step verifier for {@link Multi} streams.
 * <p>
 * Build a sequence of expectations, then call {@link #verify()} to subscribe and validate each step:
 *
 * <pre>
 * AssertMulti.create(multi)
 *         .expectNext(1, 2, 3)
 *         .expectNextMatches(i -&gt; i &gt; 3, "greater than 3")
 *         .expectComplete()
 *         .verify();
 * </pre>
 *
 * By default, the subscriber requests {@code Long.MAX_VALUE} items (unbounded demand).
 * Use {@link #withInitialRequest(long) withInitialRequest(0)} for explicit backpressure testing:
 *
 * <pre>
 * AssertMulti.create(multi)
 *         .withInitialRequest(0)
 *         .thenRequest(2)
 *         .expectNext(1, 2)
 *         .thenRequest(1)
 *         .expectNext(3)
 *         .expectComplete()
 *         .verify();
 * </pre>
 *
 * @param <T> the type of items emitted by the Multi
 */
@Experimental("This is an experimental API in Mutiny 3.x")
public final class AssertMulti<T> {

    private final Multi<T> multi;

    private final Context context;

    private final List<Step<T>> steps = new ArrayList<>();

    private boolean frozen = false;

    private long initialRequest = Long.MAX_VALUE;

    private AssertMulti(Multi<T> multi, Context context) {
        this.multi = nonNull(multi, "multi");
        this.context = nonNull(context, "context");
    }

    public static <T> AssertMulti<T> create(Multi<T> multi) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> AssertMulti<T> create(Multi<T> multi, Context context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ---- Configuration ----
    public AssertMulti<T> withInitialRequest(long n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ---- Item expectations ----
    public AssertMulti<T> expectNext(T expected) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SafeVarargs
    public final AssertMulti<T> expectNext(T... expected) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertMulti<T> expectNextMatches(Predicate<? super T> predicate, String description) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertMulti<T> expectNextCount(int count) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ---- Consumer-based inspection ----
    public AssertMulti<T> consumeNext(Consumer<? super T> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertMulti<T> consumeNextItems(int count, Consumer<? super List<T>> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ---- Demand control ----
    public AssertMulti<T> thenRequest(long n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ---- Terminal expectations ----
    public AssertMulti<T> expectComplete() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertMulti<T> expectFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertMulti<T> expectFailure(Class<? extends Throwable> type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertMulti<T> expectFailure(Class<? extends Throwable> type, String messageSubstring) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public AssertMulti<T> expectFailure(Consumer<Throwable> validator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ---- Cancellation ----
    public AssertMulti<T> thenCancel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ---- Execution ----
    public void verify() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void verify(Duration timeout) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ---- Internals ----
    private AssertMulti<T> addStep(Step<T> step) {
        if (frozen) {
            throw new IllegalStateException("Cannot add steps after verify() has been called");
        }
        steps.add(step);
        return this;
    }

    private void freeze() {
        frozen = true;
    }

    private void validate() {
        if (steps.isEmpty()) {
            throw new IllegalStateException("No steps defined");
        }
        Step<T> last = steps.get(steps.size() - 1);
        if (!(last instanceof Step.ExpectComplete) && !(last instanceof Step.ExpectFailure)
                && !(last instanceof Step.ThenCancel)) {
            throw new IllegalStateException(
                    "Last step must be a terminal expectation (expectComplete, expectFailure, or thenCancel)");
        }
    }

    private int executeStep(Step<T> step, AssertSubscriber<T> subscriber, Duration timeout, int itemIndex) {
        if (step instanceof Step.ExpectNext<T> expectNext) {
            List<T> expected = expectNext.expected();
            int targetCount = itemIndex + expected.size();
            subscriber.awaitAtLeastItems(targetCount, timeout);
            List<T> items = subscriber.getItems();
            for (int j = 0; j < expected.size(); j++) {
                T actual = items.get(itemIndex + j);
                T exp = expected.get(j);
                if (!Objects.equals(exp, actual)) {
                    throw new AssertionError(
                            "expected <" + exp + "> but received <" + actual + "> at index " + (itemIndex + j));
                }
            }
            return targetCount;
        } else if (step instanceof Step.ExpectNextMatches<T> expectNextMatches) {
            int targetCount = itemIndex + 1;
            subscriber.awaitAtLeastItems(targetCount, timeout);
            T actual = subscriber.getItems().get(itemIndex);
            if (!expectNextMatches.predicate().test(actual)) {
                throw new AssertionError("received item <" + actual + "> did not match predicate");
            }
            return targetCount;
        } else if (step instanceof Step.ExpectNextCount<T> expectNextCount) {
            int count = expectNextCount.count();
            int targetCount = itemIndex + count;
            subscriber.awaitAtLeastItems(targetCount, timeout);
            return targetCount;
        } else if (step instanceof Step.ConsumeNext<T> consumeNext) {
            int targetCount = itemIndex + 1;
            subscriber.awaitAtLeastItems(targetCount, timeout);
            T actual = subscriber.getItems().get(itemIndex);
            consumeNext.consumer().accept(actual);
            return targetCount;
        } else if (step instanceof Step.ConsumeNextItems<T> consumeNextItems) {
            int count = consumeNextItems.count();
            int targetCount = itemIndex + count;
            subscriber.awaitAtLeastItems(targetCount, timeout);
            List<T> items = subscriber.getItems().subList(itemIndex, itemIndex + count);
            consumeNextItems.consumer().accept(List.copyOf(items));
            return targetCount;
        } else if (step instanceof Step.ThenRequest<T> thenRequest) {
            subscriber.request(thenRequest.n());
            return itemIndex;
        } else if (step instanceof Step.ThenCancel) {
            subscriber.cancel();
            return itemIndex;
        } else if (step instanceof Step.ExpectComplete) {
            subscriber.awaitCompletion(timeout);
            return itemIndex;
        } else if (step instanceof Step.ExpectFailure<T> expectFailure) {
            Consumer<Throwable> validator = expectFailure.validator();
            if (validator != null) {
                subscriber.awaitFailure(validator, timeout);
            } else {
                subscriber.awaitFailure(timeout);
            }
            return itemIndex;
        } else {
            throw new IllegalStateException("Unknown step type: " + step.getClass().getName());
        }
    }

    // ---- Step types ----
    sealed interface Step<T> {

        String description();

        record ExpectNext<T>(List<T> expected) implements Step<T> {

            @Override
            public String description() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }

        record ExpectNextMatches<T>(Predicate<? super T> predicate, String predicateDescription) implements Step<T> {

            @Override
            public String description() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }

        record ExpectNextCount<T>(int count) implements Step<T> {

            @Override
            public String description() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }

        record ConsumeNext<T>(Consumer<? super T> consumer) implements Step<T> {

            @Override
            public String description() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }

        record ConsumeNextItems<T>(int count, Consumer<? super List<T>> consumer) implements Step<T> {

            @Override
            public String description() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }

        record ThenRequest<T>(long n) implements Step<T> {

            @Override
            public String description() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }

        record ThenCancel<T>() implements Step<T> {

            @Override
            public String description() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }

        record ExpectComplete<T>() implements Step<T> {

            @Override
            public String description() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }

        record ExpectFailure<T>(Consumer<Throwable> validator) implements Step<T> {

            @Override
            public String description() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }
}

package io.smallrye.mutiny.helpers;

import java.util.function.Predicate;

/**
 * A utility class that creates a predicate on a throwable.
 * If the tested throwable is a runtime exception that has a cause, it unwraps the cause and checks if it is assignable
 * to the cause class provided on predicate creation.
 * It is a companion to the unchecked utilities which wraps checked exceptions into unchecked Runtime exceptions.
 * If the tested throwable has cause, the assignment check will occur on the throwable itself.
 */
public class Caused {

    public static Predicate<Throwable> by(Class<? extends Throwable> cause) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

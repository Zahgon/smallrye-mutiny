package io.smallrye.mutiny.helpers.test;

import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AssertionHelper {

    static void shouldHaveCompleted(boolean completed, Throwable failure, List<?> items) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void shouldHaveFailed(boolean completed, Throwable failure, Class<?> expectedFailureType, String expectedMessage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void shouldHaveReceivedNoItems(List<?> items) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void shouldBeSubscribed(int numberOfSubscriptions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void shouldNotBeSubscribed(int numberOfSubscriptions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void shouldNotBeTerminated(boolean completed, Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void shouldNotBeTerminatedUni(boolean completed, Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void shouldBeTerminated(boolean completed, Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void shouldHaveReceived(Object item, Object expected) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static void shouldHaveReceivedExactly(List<?> items, Object[] expected) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static void fail(String msg, Object... params) {
        throw new AssertionError(String.format(msg, params));
    }

    private static String getItemList(List<?> items) {
        List<String> strings = items.stream().map(Object::toString).collect(Collectors.toList());
        return String.join(",", strings);
    }

    private static String getItemList(Object[] items) {
        List<String> strings = Arrays.stream(items).map(Object::toString).collect(Collectors.toList());
        return String.join(",", strings);
    }

    private static String getMismatches(Map<Object, Object> mismatches) {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : mismatches.entrySet()) {
            if (!builder.isEmpty()) {
                builder.append("\n");
            }
            if (entry.getValue() == null) {
                builder.append("\t").append("- Missing expected item <").append(entry.getKey()).append(">");
            } else {
                builder.append("\t").append("- Expected <").append(entry.getValue()).append("> to be equal to <")
                        .append(entry.getKey()).append(">");
            }
        }
        return builder.toString();
    }

    private static String getStackTrace(Throwable throwable) {
        StringWriter sw = null;
        PrintWriter pw = null;
        String result;
        try {
            sw = new StringWriter();
            pw = new PrintWriter(sw, true);
            throwable.printStackTrace(pw);
            result = sw.getBuffer().toString();
        } finally {
            closeQuietly(sw);
            closeQuietly(pw);
        }
        return result;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException ignored) {
                // Ignored.
            }
        }
    }

    static <T> void shouldMatchPredicate(T item, Predicate<? super T> predicate, String description) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static <T> void shouldMatchPredicateOnList(java.util.List<T> items, Predicate<? super java.util.List<T>> predicate,
            String description) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

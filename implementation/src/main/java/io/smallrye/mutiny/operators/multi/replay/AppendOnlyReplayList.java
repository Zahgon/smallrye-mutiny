package io.smallrye.mutiny.operators.multi.replay;

/*
 * Replay is being captured using a custom linked list, while consumers can make progress using cursors.
 *
 * The "start" depends on the replay semantics:
 * - zero for unbounded replays,
 * - the last n elements before the tail for bounded replays.
 *
 * From there each cursor (1 per subscriber) can make progress at its own pace.
 *
 * The code assumes reactive streams semantics, especially that there are no concurrent appends because of
 * serial events.
 *
 * Bounded replays shall have earlier cells before the head be eventually garbage collected as there are only forward
 * references.
 */
public class AppendOnlyReplayList {

    public class Cursor {

        private Cell current = SENTINEL_EMPTY;

        private boolean start = true;

        private boolean currentHasBeenRead = false;

        public boolean hasNext() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void moveToNext() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Object read() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public boolean hasReachedCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public boolean willReachCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public boolean willReachFailure() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public boolean hasReachedFailure() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public Throwable readFailure() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void readCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static abstract class Terminal {
    }

    private static final class Completion extends Terminal {
    }

    private static final class Failure extends Terminal {

        final Throwable failure;

        Failure(Throwable failure) {
            this.failure = failure;
        }
    }

    private static class Cell {

        final Object value;

        volatile Cell next;

        Cell(Object value, Cell next) {
            this.value = value;
            this.next = next;
        }
    }

    private static final Cell SENTINEL_END = new Cell(null, null);

    private static final Cell SENTINEL_EMPTY = new Cell(null, SENTINEL_END);

    private final long itemsToReplay;

    private long numberOfItemsRecorded = 0L;

    private volatile Cell head = SENTINEL_EMPTY;

    private volatile Cell tail = SENTINEL_EMPTY;

    public AppendOnlyReplayList(long numberOfItemsToReplay) {
        this(numberOfItemsToReplay, null);
    }

    public AppendOnlyReplayList(long numberOfItemsToReplay, Iterable<?> seed) {
        assert numberOfItemsToReplay > 0;
        this.itemsToReplay = numberOfItemsToReplay;
        if (seed != null) {
            seed.forEach(this::push);
        }
    }

    public void push(Object item) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void pushFailure(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void pushCompletion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Cursor newCursor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

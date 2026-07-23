package io.smallrye.mutiny.groups;

import java.time.Duration;
import java.util.concurrent.ScheduledExecutorService;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;

public class MultiTimePeriod {

    private Duration initialDelay;

    private ScheduledExecutorService executor;

    @CheckReturnValue
    public MultiTimePeriod startingAfter(Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public MultiTimePeriod onExecutor(ScheduledExecutorService executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<Long> every(Duration duration) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

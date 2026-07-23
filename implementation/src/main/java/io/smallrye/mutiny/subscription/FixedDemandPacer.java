package io.smallrye.mutiny.subscription;

import java.time.Duration;

/**
 * A demand pacer with a fixed delay / fixed demand.
 */
public class FixedDemandPacer implements DemandPacer {

    private final Request request;

    public FixedDemandPacer(long demand, Duration delay) {
        request = new Request(demand, delay);
    }

    @Override
    public Request initial() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Request apply(Request previousRequest, long observedItemsCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

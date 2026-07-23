package io.smallrye.mutiny.groups;

import java.util.concurrent.ScheduledExecutorService;

import io.smallrye.common.annotation.CheckReturnValue;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import io.smallrye.mutiny.operators.AbstractMulti;
import io.smallrye.mutiny.subscription.DemandPacer;

public class MultiDemandPacing<T> {

    private final AbstractMulti<T> upstream;

    private ScheduledExecutorService executor = Infrastructure.getDefaultWorkerPool();

    public MultiDemandPacing(AbstractMulti<T> upstream) {
        this.upstream = upstream;
    }

    @CheckReturnValue
    public MultiDemandPacing<T> on(ScheduledExecutorService executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @CheckReturnValue
    public Multi<T> using(DemandPacer pacer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

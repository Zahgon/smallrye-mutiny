package io.smallrye.mutiny.helpers.spies;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.groups.MultiOverflowStrategy;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiOnOverflowSpy<T> extends MultiSpyBase<T> {

    private final List<T> droppedItems;

    private final Function<MultiOverflowStrategy<? extends T>, Multi<? extends T>> strategyMapper;

    public List<T> droppedItems() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    MultiOnOverflowSpy(Multi<? extends T> upstream, boolean trackItems,
            Function<MultiOverflowStrategy<? extends T>, Multi<? extends T>> strategyMapper) {
        super(upstream);
        this.strategyMapper = strategyMapper;
        if (trackItems) {
            droppedItems = new ArrayList<>();
        } else {
            droppedItems = null;
        }
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

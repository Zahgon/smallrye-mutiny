package io.smallrye.mutiny.helpers.spies;

import java.util.ArrayList;
import java.util.List;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiOnItemSpy<T> extends MultiSpyBase<T> {

    private final List<T> items;

    public List<T> items() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void reset() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    MultiOnItemSpy(Multi<? extends T> upstream, boolean trackItems) {
        super(upstream);
        if (trackItems) {
            items = new ArrayList<>();
        } else {
            items = null;
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

package io.smallrye.mutiny.operators.uni;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.ArrayList;
import java.util.List;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.UniOperator;
import io.smallrye.mutiny.subscription.UniSubscriber;

public class UniOrCombination<T> extends UniOperator<Void, T> {

    private final List<Uni<? super T>> challengers;

    public UniOrCombination(Iterable<? extends Uni<? super T>> iterable) {
        super(null);
        this.challengers = new ArrayList<>();
        nonNull(iterable, "iterable").forEach(u -> challengers.add(nonNull(u, "iterable` must not contain a `null` value")));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void subscribe(UniSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.Flow.Subscriber;
import java.util.function.Function;
import java.util.function.Predicate;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.MultiOperator;

public class MultiFlatMapOnFailure<T> extends MultiOperator<T, T> {

    private final Predicate<? super Throwable> predicate;

    private final Function<? super Throwable, Multi<? extends T>> mapper;

    public MultiFlatMapOnFailure(Multi<T> upstream, Predicate<? super Throwable> predicate,
            Function<? super Throwable, Multi<? extends T>> mapper) {
        super(upstream);
        this.predicate = predicate == null ? x -> true : predicate;
        this.mapper = mapper;
    }

    @Override
    public void subscribe(Subscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

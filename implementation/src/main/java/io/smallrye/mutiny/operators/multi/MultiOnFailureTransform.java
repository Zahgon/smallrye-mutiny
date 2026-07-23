package io.smallrye.mutiny.operators.multi;

import java.util.concurrent.Flow;
import java.util.function.Function;
import java.util.function.Predicate;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.MultiOperator;

public class MultiOnFailureTransform<T> extends MultiOperator<T, T> {

    private final Predicate<? super Throwable> predicate;

    private final Function<? super Throwable, ? extends Throwable> mapper;

    public MultiOnFailureTransform(Multi<T> upstream, Predicate<? super Throwable> predicate,
            Function<? super Throwable, ? extends Throwable> mapper) {
        super(upstream);
        this.predicate = predicate == null ? x -> true : predicate;
        this.mapper = mapper;
    }

    @Override
    public void subscribe(Flow.Subscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

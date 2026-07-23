package io.smallrye.mutiny.operators;

import java.util.concurrent.Executor;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.groups.*;
import io.smallrye.mutiny.operators.uni.*;
import io.smallrye.mutiny.subscription.UniSubscriber;

public abstract class AbstractUni<T> implements Uni<T> {

    public abstract void subscribe(UniSubscriber<? super T> subscriber);

    @SuppressWarnings("unchecked")
    public static <T> void subscribe(Uni<? extends T> upstream, UniSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UniSubscribe<T> subscribe() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UniOnItem<T> onItem() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UniIfNoItem<T> ifNoItem() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UniOnFailure<T, Throwable> onFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UniOnFailure<T, Throwable> onFailure(Predicate<? super Throwable> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <E extends Throwable> UniOnFailure<T, E> onFailure(Class<E> typeOfFailure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UniOnSubscribe<T> onSubscription() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UniOnItemOrFailure<T> onItemOrFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UniAwait<T> await() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UniAwait<T> awaitUsing(Context context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Uni<T> emitOn(Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Uni<T> runSubscriptionOn(Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UniMemoize<T> memoize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Uni<T> cache() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UniConvert<T> convert() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Multi<T> toMulti() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UniRepeat<T> repeat() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UniOnTerminate<T> onTermination() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public UniOnCancel<T> onCancellation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Uni<T> log(String identifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Uni<T> log() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <R> Uni<R> withContext(BiFunction<Uni<T>, Context, Uni<R>> builder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

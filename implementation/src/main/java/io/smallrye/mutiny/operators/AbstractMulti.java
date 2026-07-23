package io.smallrye.mutiny.operators;

import java.util.concurrent.Executor;
import java.util.concurrent.Flow;
import java.util.function.BiFunction;
import java.util.function.LongFunction;
import java.util.function.Predicate;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.groups.MultiBroadcast;
import io.smallrye.mutiny.groups.MultiCollect;
import io.smallrye.mutiny.groups.MultiConvert;
import io.smallrye.mutiny.groups.MultiDemandPacing;
import io.smallrye.mutiny.groups.MultiDemandPausing;
import io.smallrye.mutiny.groups.MultiGroup;
import io.smallrye.mutiny.groups.MultiIfNoItem;
import io.smallrye.mutiny.groups.MultiOnCancel;
import io.smallrye.mutiny.groups.MultiOnCompletion;
import io.smallrye.mutiny.groups.MultiOnFailure;
import io.smallrye.mutiny.groups.MultiOnItem;
import io.smallrye.mutiny.groups.MultiOnRequest;
import io.smallrye.mutiny.groups.MultiOnSubscribe;
import io.smallrye.mutiny.groups.MultiOnTerminate;
import io.smallrye.mutiny.groups.MultiOverflow;
import io.smallrye.mutiny.groups.MultiSelect;
import io.smallrye.mutiny.groups.MultiSkip;
import io.smallrye.mutiny.groups.MultiSubscribe;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public abstract class AbstractMulti<T> implements Multi<T> {

    public void subscribe(MultiSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    @SuppressWarnings("unchecked")
    public void subscribe(Flow.Subscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiOnItem<T> onItem() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiSubscribe<T> subscribe() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Uni<T> toUni() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiOnFailure<T> onFailure() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiOnFailure<T> onFailure(Predicate<? super Throwable> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiOnFailure<T> onFailure(Class<? extends Throwable> typeOfFailure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiIfNoItem<T> ifNoItem() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Multi<T> cache() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Multi<T> emitOn(Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Multi<T> emitOn(Executor executor, int bufferSize) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Multi<T> runSubscriptionOn(Executor executor) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiOnCompletion<T> onCompletion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiSelect<T> select() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiSkip<T> skip() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiOverflow<T> onOverflow() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiOnSubscribe<T> onSubscription() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiBroadcast<T> broadcast() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiConvert<T> convert() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiOnTerminate<T> onTermination() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiOnCancel<T> onCancellation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiOnRequest<T> onRequest() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiCollect<T> collect() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiGroup<T> group() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Multi<T> toHotStream() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Multi<T> log(String identifier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Multi<T> log() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <R> Multi<R> withContext(BiFunction<Multi<T>, Context, Multi<R>> builder) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiDemandPacing<T> paceDemand() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiDemandPausing<T> pauseDemand() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public Multi<T> capDemandsUsing(LongFunction<Long> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

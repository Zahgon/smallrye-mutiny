package io.smallrye.mutiny.operators.multi.builders;

import java.util.concurrent.Flow;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.function.LongConsumer;

import io.smallrye.mutiny.Context;
import io.smallrye.mutiny.subscription.ContextSupport;
import io.smallrye.mutiny.subscription.MultiEmitter;
import io.smallrye.mutiny.subscription.MultiSubscriber;

abstract class BaseMultiEmitter<T> implements MultiEmitter<T>, Flow.Subscription, ContextSupport {

    protected final AtomicLong requested = new AtomicLong();

    protected final MultiSubscriber<? super T> downstream;

    private final AtomicBoolean disposed = new AtomicBoolean();

    private volatile Runnable onTermination;

    private volatile Runnable onCancellation;

    private volatile LongConsumer onRequest;

    private static final AtomicReferenceFieldUpdater<BaseMultiEmitter, Runnable> ON_TERMINATION_UPDATER = AtomicReferenceFieldUpdater
            .newUpdater(BaseMultiEmitter.class, Runnable.class, "onTermination");

    private static final AtomicReferenceFieldUpdater<BaseMultiEmitter, Runnable> ON_CANCELLATION_UPDATER = AtomicReferenceFieldUpdater
            .newUpdater(BaseMultiEmitter.class, Runnable.class, "onCancellation");

    private static final Runnable CLEARED = () -> {
    };

    BaseMultiEmitter(MultiSubscriber<? super T> downstream) {
        this.downstream = downstream;
    }

    @Override
    public Context context() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public long requested() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void complete() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void completion() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isCancelled() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void cleanup() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final void fail(Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void failed(Throwable e) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final void cancel() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void onUnsubscribed() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public final void request(long n) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    void onRequested() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiEmitter<T> onTermination(Runnable onTermination) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MultiEmitter<T> serialize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiEmitter<T> onRequest(LongConsumer consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public MultiEmitter<T> onCancellation(Runnable onCancellation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

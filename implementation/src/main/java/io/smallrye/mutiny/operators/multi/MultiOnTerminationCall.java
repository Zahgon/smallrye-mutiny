package io.smallrye.mutiny.operators.multi;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.Cancellable;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class MultiOnTerminationCall<T> extends AbstractMultiOperator<T, T> {

    private final BiFunction<Throwable, Boolean, Uni<?>> mapper;

    public MultiOnTerminationCall(Multi<? extends T> upstream, BiFunction<Throwable, Boolean, Uni<?>> mapper) {
        super(upstream);
        this.mapper = mapper;
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    class MultiOnTerminationCallProcessor extends MultiOperatorProcessor<T, T> {

        private volatile Cancellable cancellable;

        private final AtomicBoolean mapperInvoked = new AtomicBoolean();

        public MultiOnTerminationCallProcessor(MultiSubscriber<? super T> downstream) {
            super(downstream);
        }

        @Override
        public void cancel() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private Uni<?> execute(Throwable err, Boolean cancelled) {
            if (mapperInvoked.compareAndSet(false, true)) {
                try {
                    return Objects.requireNonNull(mapper.apply(err, cancelled), "Uni should not be null");
                } catch (Throwable t) {
                    return Uni.createFrom().failure(t);
                }
            } else {
                return Uni.createFrom().nullItem();
            }
        }
    }
}

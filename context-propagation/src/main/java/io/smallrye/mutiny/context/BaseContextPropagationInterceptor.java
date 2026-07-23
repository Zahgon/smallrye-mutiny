package io.smallrye.mutiny.context;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.function.*;

import io.smallrye.context.SmallRyeThreadContext;
import io.smallrye.context.impl.Contextualized;
import io.smallrye.mutiny.infrastructure.CallbackDecorator;
import io.smallrye.mutiny.tuples.Functions;

public abstract class BaseContextPropagationInterceptor implements CallbackDecorator {

    /**
     * Gets the Context Propagation ThreadContext. External
     * implementations may implement this method.
     *
     * @return the ThreadContext
     */
    protected abstract SmallRyeThreadContext getThreadContext();

    @Override
    public <T> Supplier<T> decorate(Supplier<T> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> Consumer<T> decorate(Consumer<T> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public LongConsumer decorate(LongConsumer consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class ContextualizedLongConsumer implements LongConsumer, Contextualized {

        private final Consumer<Long> contextualized;

        ContextualizedLongConsumer(Consumer<Long> contextualized) {
            this.contextualized = contextualized;
        }

        @Override
        public void accept(long value) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Override
    public Runnable decorate(Runnable runnable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <V> Callable<V> decorate(Callable<V> callable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T1, T2> BiConsumer<T1, T2> decorate(BiConsumer<T1, T2> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <I, O> Function<I, O> decorate(Function<I, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    @Override
    public <I1, I2, I3, O> Functions.Function3<I1, I2, I3, O> decorate(Functions.Function3<I1, I2, I3, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class ContextualizedFunction3<I1, I2, I3, O> implements Functions.Function3<I1, I2, I3, O>, Contextualized {

        private final Function<Object[], O> function;

        ContextualizedFunction3(Function<Object[], O> function) {
            this.function = function;
        }

        @Override
        public O apply(I1 item1, I2 item2, I3 item3) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <I1, I2, I3, I4, O> Functions.Function4<I1, I2, I3, I4, O> decorate(
            Functions.Function4<I1, I2, I3, I4, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class ContextualizedFunction4<I1, I2, I3, I4, O> implements Functions.Function4<I1, I2, I3, I4, O>, Contextualized {

        private final Function<Object[], O> function;

        ContextualizedFunction4(Function<Object[], O> function) {
            this.function = function;
        }

        @Override
        public O apply(I1 item1, I2 item2, I3 item3, I4 item4) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <I1, I2, I3, I4, I5, O> Functions.Function5<I1, I2, I3, I4, I5, O> decorate(
            Functions.Function5<I1, I2, I3, I4, I5, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class ContextualizedFunction5<I1, I2, I3, I4, I5, O>
            implements Functions.Function5<I1, I2, I3, I4, I5, O>, Contextualized {

        private final Function<Object[], O> function;

        ContextualizedFunction5(Function<Object[], O> function) {
            this.function = function;
        }

        @Override
        public O apply(I1 item1, I2 item2, I3 item3, I4 item4, I5 item5) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <I1, I2, I3, I4, I5, I6, O> Functions.Function6<I1, I2, I3, I4, I5, I6, O> decorate(
            Functions.Function6<I1, I2, I3, I4, I5, I6, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class ContextualizedFunction6<I1, I2, I3, I4, I5, I6, O>
            implements Functions.Function6<I1, I2, I3, I4, I5, I6, O>, Contextualized {

        private final Function<Object[], O> function;

        ContextualizedFunction6(Function<Object[], O> function) {
            this.function = function;
        }

        @Override
        public O apply(I1 item1, I2 item2, I3 item3, I4 item4, I5 item5, I6 item6) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <I1, I2, I3, I4, I5, I6, I7, O> Functions.Function7<I1, I2, I3, I4, I5, I6, I7, O> decorate(
            Functions.Function7<I1, I2, I3, I4, I5, I6, I7, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class ContextualizedFunction7<I1, I2, I3, I4, I5, I6, I7, O>
            implements Functions.Function7<I1, I2, I3, I4, I5, I6, I7, O>, Contextualized {

        private final Function<Object[], O> function;

        ContextualizedFunction7(Function<Object[], O> function) {
            this.function = function;
        }

        @Override
        public O apply(I1 item1, I2 item2, I3 item3, I4 item4, I5 item5, I6 item6, I7 item7) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <I1, I2, I3, I4, I5, I6, I7, I8, O> Functions.Function8<I1, I2, I3, I4, I5, I6, I7, I8, O> decorate(
            Functions.Function8<I1, I2, I3, I4, I5, I6, I7, I8, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class ContextualizedFunction8<I1, I2, I3, I4, I5, I6, I7, I8, O>
            implements Functions.Function8<I1, I2, I3, I4, I5, I6, I7, I8, O>, Contextualized {

        private final Function<Object[], O> function;

        ContextualizedFunction8(Function<Object[], O> function) {
            this.function = function;
        }

        @Override
        public O apply(I1 item1, I2 item2, I3 item3, I4 item4, I5 item5, I6 item6, I7 item7, I8 item8) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <I1, I2, I3, I4, I5, I6, I7, I8, I9, O> Functions.Function9<I1, I2, I3, I4, I5, I6, I7, I8, I9, O> decorate(
            Functions.Function9<I1, I2, I3, I4, I5, I6, I7, I8, I9, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class ContextualizedFunction9<I1, I2, I3, I4, I5, I6, I7, I8, I9, O>
            implements Functions.Function9<I1, I2, I3, I4, I5, I6, I7, I8, I9, O>, Contextualized {

        private final Function<Object[], O> function;

        ContextualizedFunction9(Function<Object[], O> function) {
            this.function = function;
        }

        @Override
        public O apply(I1 item1, I2 item2, I3 item3, I4 item4, I5 item5, I6 item6, I7 item7, I8 item8, I9 item9) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Override
    public <I1, I2, O> BiFunction<I1, I2, O> decorate(BiFunction<I1, I2, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public <T> BinaryOperator<T> decorate(BinaryOperator<T> operator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class ContextualizedBinaryOperator<T> implements BinaryOperator<T>, Contextualized {

        private final BiFunction<T, T, T> contextualized;

        ContextualizedBinaryOperator(BiFunction<T, T, T> contextualized) {
            this.contextualized = contextualized;
        }

        @Override
        public T apply(T t, T t2) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Override
    public <T1, T2, T3> Functions.TriConsumer<T1, T2, T3> decorate(Functions.TriConsumer<T1, T2, T3> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class ContextualizedTriConsumer<T1, T2, T3> implements Functions.TriConsumer<T1, T2, T3>, Contextualized {

        private final Executor executor;

        private final Functions.TriConsumer<T1, T2, T3> consumer;

        ContextualizedTriConsumer(Executor executor, Functions.TriConsumer<T1, T2, T3> consumer) {
            this.executor = executor;
            this.consumer = consumer;
        }

        @Override
        public void accept(T1 t1, T2 t2, T3 t3) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Override
    public BooleanSupplier decorate(BooleanSupplier supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class ContextualizedBooleanSupplier implements BooleanSupplier, Contextualized {

        private final Supplier<Boolean> contextualized;

        ContextualizedBooleanSupplier(Supplier<Boolean> contextualized) {
            this.contextualized = contextualized;
        }

        @Override
        public boolean getAsBoolean() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    @Override
    public <T> Predicate<T> decorate(Predicate<T> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class ContextualizedPredicate<T> implements Predicate<T>, Contextualized {

        private final Function<T, Boolean> contextualized;

        ContextualizedPredicate(Function<T, Boolean> contextualized) {
            this.contextualized = contextualized;
        }

        @Override
        public boolean test(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

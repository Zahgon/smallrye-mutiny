package io.smallrye.mutiny.infrastructure;

import static io.smallrye.mutiny.helpers.ParameterValidation.nonNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Flow;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.subscription.UniSubscriber;
import io.smallrye.mutiny.tuples.Functions;

public class Infrastructure {

    private static final String DISABLE_CALLBACK_DECORATORS_PROP_NAME = "mutiny.disableCallBackDecorators";

    private static final boolean DISABLE_CALLBACK_DECORATORS = Boolean.getBoolean(DISABLE_CALLBACK_DECORATORS_PROP_NAME);

    static {
        ServiceLoader<ExecutorConfiguration> executorLoader = ServiceLoader.load(ExecutorConfiguration.class);
        Iterator<ExecutorConfiguration> iterator = executorLoader.iterator();
        if (iterator.hasNext()) {
            ExecutorConfiguration next = iterator.next();
            setDefaultExecutor(nonNull(next.getDefaultWorkerExecutor(), "executor"));
        } else {
            setDefaultExecutor();
        }
        reload();
        resetCanCallerThreadBeBlockedSupplier();
    }

    private static ScheduledExecutorService DEFAULT_SCHEDULER;

    private static Executor DEFAULT_EXECUTOR;

    private static UniInterceptor[] UNI_INTERCEPTORS;

    private static MultiInterceptor[] MULTI_INTERCEPTORS;

    private static CallbackDecorator[] CALLBACK_DECORATORS;

    private static UnaryOperator<CompletableFuture<?>> completableFutureWrapper;

    private static Consumer<Throwable> droppedExceptionHandler = PrintAndDumpThrowableConsumer.INSTANCE;

    private static BooleanSupplier canCallerThreadBeBlockedSupplier;

    private static OperatorLogger operatorLogger = PrintOperatorEventOperatorLogger.INSTANCE;

    private static int multiOverflowDefaultBufferSize = 128;

    private static int bufferSizeXs = 32;

    private static int bufferSizeS = 256;

    public static void reload() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void setDefaultExecutor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void setDefaultExecutor(Executor s) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void setDefaultExecutor(Executor executor, boolean shutdownPrevious) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static ScheduledExecutorService getDefaultWorkerPool() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Executor getDefaultExecutor() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Uni<T> onUniCreation(Uni<T> instance) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Multi<T> onMultiCreation(Multi<T> instance) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> UniSubscriber<? super T> onUniSubscription(Uni<T> instance, UniSubscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Subscriber<? super T> onMultiSubscription(Flow.Publisher<? extends T> instance,
            Subscriber<? super T> subscriber) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Supplier<T> decorate(Supplier<T> supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Consumer<T> decorate(Consumer<T> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static LongConsumer decorate(LongConsumer consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <R> LongFunction<R> decorate(LongFunction<R> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static Runnable decorate(Runnable runnable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <V> Callable<V> decorate(Callable<V> callable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T1, T2> BiConsumer<T1, T2> decorate(BiConsumer<T1, T2> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <I1, I2, I3, O> Functions.Function3<I1, I2, I3, O> decorate(Functions.Function3<I1, I2, I3, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <I1, I2, I3, I4, O> Functions.Function4<I1, I2, I3, I4, O> decorate(
            Functions.Function4<I1, I2, I3, I4, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <I1, I2, I3, I4, I5, O> Functions.Function5<I1, I2, I3, I4, I5, O> decorate(
            Functions.Function5<I1, I2, I3, I4, I5, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <I1, I2, I3, I4, I5, I6, O> Functions.Function6<I1, I2, I3, I4, I5, I6, O> decorate(
            Functions.Function6<I1, I2, I3, I4, I5, I6, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <I1, I2, I3, I4, I5, I6, I7, O> Functions.Function7<I1, I2, I3, I4, I5, I6, I7, O> decorate(
            Functions.Function7<I1, I2, I3, I4, I5, I6, I7, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <I1, I2, I3, I4, I5, I6, I7, I8, O> Functions.Function8<I1, I2, I3, I4, I5, I6, I7, I8, O> decorate(
            Functions.Function8<I1, I2, I3, I4, I5, I6, I7, I8, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <I1, I2, I3, I4, I5, I6, I7, I8, I9, O> Functions.Function9<I1, I2, I3, I4, I5, I6, I7, I8, I9, O> decorate(
            Functions.Function9<I1, I2, I3, I4, I5, I6, I7, I8, I9, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <I, O> Function<I, O> decorate(Function<I, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <I1, I2, O> BiFunction<I1, I2, O> decorate(BiFunction<I1, I2, O> function) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> BinaryOperator<T> decorate(BinaryOperator<T> operator) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T1, T2, T3> Functions.TriConsumer<T1, T2, T3> decorate(Functions.TriConsumer<T1, T2, T3> consumer) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void setCompletableFutureWrapper(UnaryOperator<CompletableFuture<?>> wrapper) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    public static <T> CompletableFuture<T> wrapCompletableFuture(CompletableFuture<T> future) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void handleDroppedException(Throwable throwable) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void setCanCallerThreadBeBlockedSupplier(BooleanSupplier supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static boolean canCallerThreadBeBlocked() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void setDroppedExceptionHandler(Consumer<Throwable> handler) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void reloadUniInterceptors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void reloadMultiInterceptors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void reloadCallbackDecorators() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static <T extends MutinyInterceptor> List<T> toInterceptorList(ServiceLoader<T> loader) {
        List<T> interceptors = new ArrayList<>();
        for (T item : loader) {
            interceptors.add(item);
        }
        interceptors.sort(MutinyInterceptorComparator.INSTANCE);
        return interceptors;
    }

    public static void clearInterceptors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // For testing purpose only
    public static void resetDroppedExceptionHandler() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // For testing purpose only
    public static void resetCanCallerThreadBeBlockedSupplier() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private Infrastructure() {
        // Avoid direct instantiation.
    }

    public static BooleanSupplier decorate(BooleanSupplier supplier) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <T> Predicate<T> decorate(Predicate<T> predicate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void logFromOperator(String identifier, String event, Object value, Throwable failure) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void setOperatorLogger(OperatorLogger operatorLogger) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // For testing purpose only
    public static void resetOperatorLogger() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static int getMultiOverflowDefaultBufferSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void setMultiOverflowDefaultBufferSize(int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static int getBufferSizeXs() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void setBufferSizeXs(int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static int getBufferSizeS() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void setBufferSizeS(int size) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * An operator logger for {@link Multi#log(String)} and {@link Uni#log(String)}.
     */
    @FunctionalInterface
    public interface OperatorLogger {

        /**
         * Actual logging behavior.
         *
         * @param identifier the event identifier
         * @param event the event as a string
         * @param value the value, if any or {@code null}
         * @param failure the failure, if any or {@code null}
         */
        void log(String identifier, String event, Object value, Throwable failure);
    }

    private static class MutinyInterceptorComparator implements Comparator<MutinyInterceptor> {

        private static final MutinyInterceptorComparator INSTANCE = new MutinyInterceptorComparator();

        @Override
        public int compare(MutinyInterceptor o1, MutinyInterceptor o2) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class AlwaysTrueBooleanSupplier implements BooleanSupplier {

        private static final AlwaysTrueBooleanSupplier INSTANCE = new AlwaysTrueBooleanSupplier();

        @Override
        public boolean getAsBoolean() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class PrintAndDumpThrowableConsumer implements Consumer<Throwable> {

        private static final PrintAndDumpThrowableConsumer INSTANCE = new PrintAndDumpThrowableConsumer();

        @Override
        public void accept(Throwable throwable) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    private static class PrintOperatorEventOperatorLogger implements OperatorLogger {

        private static final PrintOperatorEventOperatorLogger INSTANCE = new PrintOperatorEventOperatorLogger();

        @Override
        public void log(String identifier, String event, Object value, Throwable failure) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

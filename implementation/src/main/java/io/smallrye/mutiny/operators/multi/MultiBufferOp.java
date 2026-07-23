/*
 * Copyright (c) 2011-2018 Pivotal Software Inc, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.smallrye.mutiny.operators.multi;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * Buffers a given number of items and emits the <em>groups</em> as a single item downstream.
 * This implementation uses {@link java.util.ArrayList} and so emits {@link List}.
 *
 * @param <T> the type of item from upstream
 */
public class MultiBufferOp<T> extends AbstractMultiOperator<T, List<T>> {

    private final int size;

    private final int skip;

    private final Supplier<List<T>> supplier;

    public MultiBufferOp(Multi<? extends T> upstream, int size, int skip) {
        super(upstream);
        this.size = ParameterValidation.positive(size, "size");
        this.skip = ParameterValidation.positive(skip, "skip");
        this.supplier = () -> new ArrayList<>(size);
    }

    @Override
    public void subscribe(MultiSubscriber<? super List<T>> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class BufferExactProcessor<T> extends MultiOperatorProcessor<T, List<T>> {

        private final Supplier<List<T>> supplier;

        private final int size;

        private List<T> current;

        BufferExactProcessor(MultiSubscriber<? super List<T>> downstream, int size, Supplier<List<T>> supplier) {
            super(downstream);
            this.size = size;
            this.supplier = supplier;
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static final class BufferSkipProcessor<T> extends MultiOperatorProcessor<T, List<T>> {

        private final Supplier<List<T>> supplier;

        private final int size;

        private final int skip;

        private List<T> current;

        private long index;

        private final AtomicInteger wip = new AtomicInteger();

        BufferSkipProcessor(MultiSubscriber<? super List<T>> downstream, int size, int skip, Supplier<List<T>> supplier) {
            super(downstream);
            this.size = size;
            this.skip = skip;
            this.supplier = supplier;
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onFailure(Throwable t) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    static final class BufferOverlappingProcessor<T> extends MultiOperatorProcessor<T, List<T>> {

        private final Supplier<List<T>> supplier;

        private final int size;

        private final int skip;

        long index;

        long produced;

        private final AtomicBoolean firstRequest = new AtomicBoolean();

        private final AtomicLong requested = new AtomicLong();

        private final ArrayDeque<List<T>> queue = new ArrayDeque<>();

        BufferOverlappingProcessor(MultiSubscriber<? super List<T>> downstream, int size, int skip,
                Supplier<List<T>> supplier) {
            super(downstream);
            this.size = size;
            this.skip = skip;
            this.supplier = supplier;
        }

        @Override
        public void request(long n) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onItem(T item) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void onCompletion() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

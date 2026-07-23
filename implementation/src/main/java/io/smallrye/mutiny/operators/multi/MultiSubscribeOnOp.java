/*
 * Copyright (c) 2011-2017 Pivotal Software Inc, All Rights Reserved.
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

import java.util.concurrent.Executor;
import java.util.concurrent.Flow;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.helpers.ParameterValidation;
import io.smallrye.mutiny.subscription.MultiSubscriber;

/**
 * Subscribes to the upstream asynchronously using the given executor, and ensure all
 * {@link Flow.Subscription#request(long)} calls happen from that executor.
 *
 * @param <T> the type of item
 */
public class MultiSubscribeOnOp<T> extends AbstractMultiOperator<T, T> {

    private final Executor executor;

    public MultiSubscribeOnOp(Multi<? extends T> upstream, Executor executor) {
        super(upstream);
        this.executor = ParameterValidation.nonNull(executor, "executor");
    }

    @Override
    public void subscribe(MultiSubscriber<? super T> downstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final class SubscribeOnProcessor<T> extends MultiOperatorProcessor<T, T> {

        private final Executor executor;

        SubscribeOnProcessor(MultiSubscriber<? super T> downstream, Executor executor) {
            super(downstream);
            this.executor = executor;
        }

        public void scheduleSubscription(Multi<? extends T> upstream, MultiSubscriber<? super T> downstream) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public void request(long numberOfItems) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

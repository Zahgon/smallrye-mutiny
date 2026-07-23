///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:3.3.0
package _08_misc;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.multi.AbstractMultiOperator;
import io.smallrye.mutiny.operators.multi.MultiOperatorProcessor;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class _01_Multi_Custom_Operator {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class RandomDrop<T> extends AbstractMultiOperator<T, T> {

        public RandomDrop(Multi<? extends T> upstream) {
            super(upstream);
        }

        @Override
        public void subscribe(MultiSubscriber<? super T> downstream) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private class DropProcessor extends MultiOperatorProcessor<T, T> {

            DropProcessor(MultiSubscriber<? super T> downstream) {
                super(downstream);
            }

            @Override
            public void onItem(T item) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }
}

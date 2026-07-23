///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:3.3.0
package _03_composition_transformation;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.operators.multi.AbstractMultiOperator;
import io.smallrye.mutiny.operators.multi.MultiOperatorProcessor;
import io.smallrye.mutiny.subscription.MultiSubscriber;

public class _22_Multi_Chunks_To_Sentence_Stream_Custom_Operator {

    public static void main(String[] args) throws InterruptedException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class TokenToSentence extends AbstractMultiOperator<String, String> {

        public TokenToSentence(Multi<? extends String> upstream) {
            super(upstream);
        }

        @Override
        public void subscribe(MultiSubscriber<? super String> downstream) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        static private class TokenToSentenceProcessor extends MultiOperatorProcessor<String, String> {

            private final StringBuilder builder = new StringBuilder();

            public TokenToSentenceProcessor(MultiSubscriber<? super String> downstream) {
                super(downstream);
            }

            @Override
            public void onItem(String chunk) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }
    }

    static final ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();

    static Uni<String> sendText(String text) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

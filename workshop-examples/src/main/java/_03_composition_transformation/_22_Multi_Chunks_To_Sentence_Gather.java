/// usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:3.3.0
package _03_composition_transformation;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import io.smallrye.mutiny.Uni;

public class _22_Multi_Chunks_To_Sentence_Gather {

    public static void main(String[] args) throws InterruptedException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final ScheduledExecutorService pool = Executors.newSingleThreadScheduledExecutor();

    static Uni<String> sendText(String text) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

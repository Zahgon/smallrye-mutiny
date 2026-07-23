///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:3.3.0
package _01_basics;

import java.util.concurrent.CompletionStage;

import io.smallrye.mutiny.Uni;

public class _17_Multi_By_Repeating {

    public static void main(String[] args) throws InterruptedException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class Service {

        static long fetchValue() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        static Uni<Long> asyncFetchValue() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        static CompletionStage<Long> queryDb() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

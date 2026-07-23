///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:3.3.0
package _06_threading;

import java.util.concurrent.atomic.AtomicInteger;

import io.smallrye.mutiny.Uni;

public class _01_Threading_Subscription {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static final AtomicInteger counter = new AtomicInteger();

    static Uni<Integer> generate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

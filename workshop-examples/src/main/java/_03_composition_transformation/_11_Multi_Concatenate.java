///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:3.3.0
package _03_composition_transformation;

import java.util.concurrent.atomic.AtomicLong;

import io.smallrye.mutiny.Uni;

public class _11_Multi_Concatenate {

    public static void main(String[] args) throws InterruptedException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class Generator {

        final AtomicLong aLong;

        Generator(long start) {
            aLong = new AtomicLong(start);
        }

        Uni<Long> next() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

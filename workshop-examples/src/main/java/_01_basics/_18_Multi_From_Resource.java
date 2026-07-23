///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:3.3.0
package _01_basics;

import io.smallrye.mutiny.Multi;

public class _18_Multi_From_Resource {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static class MyResource {

        public Multi<Integer> stream() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void close() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

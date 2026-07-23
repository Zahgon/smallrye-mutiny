///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:3.3.0
package _01_basics;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class _19_Multi_From_Generator {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static class MyState {

        Random random = new Random();

        LinkedList<Integer> list = new LinkedList<>();

        List<Integer> produceorNull() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

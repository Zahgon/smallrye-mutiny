///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:3.3.0
package _03_composition_transformation;

import java.util.Arrays;
import java.util.List;

public class _14_Multi_Aggregates {

    public static void main(String[] args) throws InterruptedException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ------------------------------------------------------------------ //
    static Person generate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    static List<String> cities = Arrays.asList("Lyon", "Tassin La Demi Lune", "Clermont-Ferrand", "Nevers");

    // ------------------------------------------------------------------ //
    private static class Person {

        final String identifier;

        final int age;

        final String city;

        Person(String identifier, int age, String city) {
            this.identifier = identifier;
            this.age = age;
            this.city = city;
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

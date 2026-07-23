///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:3.3.0
package _07_advanced_streaming;

import static _07_advanced_streaming._01_Multi_Split.Country.*;

public class _01_Multi_Split {

    static class TemperatureRecord {

        final Country country;

        final String city;

        final long timestamp;

        final double value;

        TemperatureRecord(Country country, String city, long timestamp, double value) {
            this.country = country;
            this.city = city;
            this.timestamp = timestamp;
            this.value = value;
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    enum Country {

        FRANCE,
        UK,
        AUSTRALIA
    }

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

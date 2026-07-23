package io.smallrye.mutiny.math;

/**
 * A state object for collecting statistics such as count, average, min, max, variance, standard deviation, skewness,
 * and kurtosis.
 *
 * <ul>
 * <li>Count: the number of element emitted by the upstream, 0 for empty streams.</li>
 * <li>Average: the average of the element emitted by the upstream, 0.0 for empty streams.</li>
 * <li>Min: the minimum element emitted by the upstream, {@code null} for empty streams.</li>
 * <li>Max: the maximum element emitted by the upstream, {@code null} for empty streams.</li>
 * <li>Variance: squared deviation of a items from the upstreams. It measures how far a set of items is spread out from their
 * average value.</li>
 * <li>Standard Deviation: measure of the dispersion of the set of items. A low standard deviation indicates that
 * the values tend to be close to the current average, while a high standard deviation indicates that the items are spread out
 * over a wider range.</li>
 * <li>Skewness: measure of the asymmetry of the distribution of the emitted items about its average. The skewness value can be
 * positive, zero, negative, or {@code NaN}.</li>
 * <li>Kurtosis: statistical measure that defines how heavily the tails of a item distribution differ from the tails of a normal
 * distribution.</li>
 * </ul>
 * <p>
 * Computation is based on https://www.johndcook.com/blog/skewness_kurtosis/.
 *
 * @param <T> the type of the element (Number and Comparable)
 */
public class Statistic<T> {

    final long n;

    final double m1;

    final double m2;

    final double m3;

    final double m4;

    final T min;

    final T max;

    public Statistic(long n, double m1, double m2, double m3, double m4, T min, T max) {
        this.n = n;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        this.m4 = m4;
        this.min = min;
        this.max = max;
    }

    public double getAverage() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getVariance() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getStandardDeviation() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getSkewness() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public double getKurtosis() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public long getCount() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T getMin() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public T getMax() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

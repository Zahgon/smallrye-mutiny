package io.smallrye.mutiny.subscription;

import io.smallrye.common.annotation.Experimental;

/**
 * A handle to control a pausable stream without holding a direct reference to the stream itself.
 * <p>
 * This handle allows pausing, resuming, and inspecting the state of a pausable stream from anywhere
 * in the application, even after the stream has been transformed or subscribed to.
 * <p>
 * Example usage:
 *
 * <pre>
 * {@code
 * DemandPauser pauser = new DemandPauser();
 *
 * Multi.createFrom().range(0, 100)
 *         .pauseDemand().using(pauser)
 *         .onItem().call(i -> Uni.createFrom().nullItem()
 *                 .onItem().delayIt().by(Duration.ofMillis(10)))
 *         .onItem().transform(i -> i * 2)
 *         .subscribe().with(System.out::println);
 *
 * // Control from anywhere
 * pauser.pause();
 * pauser.resume();
 * System.out.println("Paused: " + pauser.isPaused());
 * }
 * </pre>
 */
@Experimental("This API is still being designed and may change in the future")
public class DemandPauser {

    volatile PausableMulti multi;

    public void bind(PausableMulti multi) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void pause() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void resume() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isPaused() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public int bufferSize() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean clearBuffer() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean isBound() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private void ensureBound() {
        if (multi == null) {
            throw new IllegalStateException("DemandPauser is not bound to a stream. "
                    + "Make sure to use .pauseDemand().using(pauser) in the pausable configuration.");
        }
    }
}

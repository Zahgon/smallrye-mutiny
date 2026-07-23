///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS io.smallrye.reactive:mutiny:3.3.0
package _04_failures;

import io.smallrye.mutiny.Uni;

public class _12_Multi_Failure_Guarded_Recovery {

    public static void main(String[] args) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static Uni<Integer> safeGuardedOperation(Integer i) {
        return Uni.createFrom().item(i).onItem().invoke(n -> {
            if (n == 6) {
                throw new RuntimeException("Bada Boom");
            } else {
                System.out.println(n + " 👍");
            }
        }).onFailure().recoverWithItem(i);
    }
}

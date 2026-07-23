package io.smallrye.mutiny.infrastructure;

public interface MutinyInterceptor {

    /**
     * Default interceptor ordinal ({@code 100}).
     */
    int DEFAULT_ORDINAL = 100;

    default int ordinal() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

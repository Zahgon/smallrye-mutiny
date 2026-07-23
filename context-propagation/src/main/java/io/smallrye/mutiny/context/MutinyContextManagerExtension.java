package io.smallrye.mutiny.context;

import org.eclipse.microprofile.context.spi.ContextManager;
import org.eclipse.microprofile.context.spi.ContextManagerExtension;

public class MutinyContextManagerExtension implements ContextManagerExtension {

    @Override
    public void setup(ContextManager manager) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

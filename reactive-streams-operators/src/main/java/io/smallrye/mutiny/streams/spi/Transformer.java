package io.smallrye.mutiny.streams.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

import io.smallrye.mutiny.Multi;

public class Transformer {

    private final ExecutionModel model;

    private static final Transformer INSTANCE;

    static {
        INSTANCE = new Transformer();
    }

    private Transformer() {
        ServiceLoader<ExecutionModel> loader = ServiceLoader.load(ExecutionModel.class);
        Iterator<ExecutionModel> iterator = loader.iterator();
        if (iterator.hasNext()) {
            model = iterator.next();
        } else {
            model = i -> i;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> Multi<T> apply(Multi<T> upstream) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

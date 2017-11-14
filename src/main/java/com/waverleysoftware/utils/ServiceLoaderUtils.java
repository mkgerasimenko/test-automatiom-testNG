package com.waverleysoftware.utils;

import io.vavr.control.Try;
import one.util.streamex.StreamEx;

import java.util.Collections;
import java.util.List;
import java.util.ServiceLoader;


/**
 * A simple service-provider loading facility.
 */
public final class ServiceLoaderUtils {

    private ServiceLoaderUtils() {
        throw new UnsupportedOperationException();
    }

    public static <T> List<T> load(final Class<T> entityClass, final ClassLoader classLoader) {
        return Try.of(() -> StreamEx.of(ServiceLoader.load(entityClass, classLoader).iterator()).toList())
                .getOrElseGet(ex -> Collections.emptyList());
    }
}

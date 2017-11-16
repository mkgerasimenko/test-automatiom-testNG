package com.waverleysoftware.assertions;

import static com.waverleysoftware.listemers.TestListener.getSoftAssert;

/**
 * A helper class for soft assert processing to any model.
 */
public class ModelSoftAssert {

    public <T, V> V assertThat(final Class<V> assertClass, final Class<T> actualClass, final T actual) {
        return getSoftAssert().proxy(assertClass, actualClass, actual);
    }
}

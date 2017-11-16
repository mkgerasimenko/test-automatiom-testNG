package com.waverleysoftware.basecore;

import static org.joor.Reflect.on;

/**
 * A utility class for initialing page.
 */
public final class PageFactory {

    private PageFactory() {
        throw new UnsupportedOperationException("Illegal access to private constructor.");
    }

    @SuppressWarnings("unchecked")
    public static <T extends Page> T open(final Class<T> pageClass) {
        return (T) at(pageClass).navigateTo();
    }

    public static <T extends Page> T at(final Class<T> pageClass) {
        return on(pageClass).create().get();
    }
}

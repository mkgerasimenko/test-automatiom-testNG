package com.waverleysoftware.assertions;

import com.waverleysoftware.model.Client;
import com.waverleysoftware.model.Panel;
import com.waverleysoftware.model.Search;

/**
 * A simple base class for Assertions.
 */
public final class CustomAssertions {

    private CustomAssertions() {
        throw new UnsupportedOperationException("Illegal access to private constructor.");
    }

    public static PanelAssert assertThat(final Panel panel) {
        return new PanelAssert(panel);
    }

    public static ClientAssert assertThat(final Client client) {
        return new ClientAssert(client);
    }

    public static SearchPageAssert assertThatE(final Search search) {
        return new ModelSoftAssert().assertThat(SearchPageAssert.class, Search.class, search);
    }
}

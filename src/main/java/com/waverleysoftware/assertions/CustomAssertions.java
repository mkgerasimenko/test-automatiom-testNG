package com.waverleysoftware.assertions;

import com.waverleysoftware.model.Client;
import com.waverleysoftware.model.Panel;

/**
 * A simple base class for Assertions.
 */
public final class CustomAssertions {

    private CustomAssertions() {
        throw new UnsupportedOperationException();
    }

    public static PanelAssert assertThat(final Panel panel) {
        return new PanelAssert(panel);
    }

    public static ClientAssert assertThat(final Client client) {
        return new ClientAssert(client);
    }
}

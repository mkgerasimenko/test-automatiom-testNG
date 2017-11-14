package com.waverleysoftware.assertions;

import com.waverleysoftware.model.Panel;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.util.Objects;

/**
 * A simple model class for Panel Assert processing.
 */
public class PanelAssert extends AbstractAssert<PanelAssert, Panel> {

    private static final String ERROR_MESSAGE_TEMPLATE = "\nExpecting <%s> of: \n<%s>\nto be: <%s>\nbut was: <%s>\n";

    public PanelAssert(final Panel panel) {
        super(panel, PanelAssert.class);
    }

    public PanelAssert hasPanelName(final String panelName) {
        isNotNull();

        final String name = actual.getName();

        if (!Objects.areEqual(name, panelName)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Panel name", actual, panelName, name);
        }
        return this;
    }

    public PanelAssert hasMasterCode(final String masterCode) {
        isNotNull();

        final String code = actual.getMasterCode();

        if (!Objects.areEqual(code, masterCode)) {
            failWithMessage(ERROR_MESSAGE_TEMPLATE, "Panel code", actual, masterCode, code);
        }
        return this;
    }
}

package com.waverleysoftware;

import com.waverleysoftware.model.Panel;
import org.testng.annotations.Test;

import java.util.logging.Level;

/**
 * A simple model class for access code testing.
 */
public class AccessCodeTests extends BaseTest {

    @Test(dataProvider = "getPanelData", dataProviderClass = DataSuppliers.class)
    public void accessCodeShouldBeAdded(final Panel panel) {
        final String conditionForType = "home";
        if (conditionForType.equals(panel.getType())
                && panel.hasTouchScreen()
                && LOG.isLoggable(Level.INFO)) {
            LOG.info("For " + panel.getName() + " panel created the following code: " + panel.getMasterCode());
        } else {
            LOG.info("There is no panel with following condition");
        }
    }

    @Test(dataProvider = "getPanelData", dataProviderClass = DataSuppliers.class)
    public void accessCodeShouldBeDeleted(final Panel panel) throws NoSuchFieldException {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.info("From " + panel.getName() + " panel deleted the following code: " + panel.getMasterCode());
        }
    }
}

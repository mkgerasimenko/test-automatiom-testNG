package com.waverleysoftware;

import com.waverleysoftware.model.Panel;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.waverleysoftware.listemers.TestListener.getSoftAssert;
import static java.util.Arrays.asList;

/**
 * A simple model class for access code testing.
 */
@Slf4j
public class AccessCodeTests extends BaseTest {
    @Test(dataProvider = "getPanelData", dataProviderClass = DataSuppliers.class)
    public void accessCodeShouldBeAdded(final Panel... panels) {
        final String conditionForType = "home";
        getSoftAssert().assertThat(panels[0].getType()).as("Panel Name").isEqualTo(conditionForType);
    }

    @Test(dataProvider = "getPanelData", dataProviderClass = DataSuppliers.class)
    public void accessCodeShouldBeCreatedWithSomeDates(final Panel... panels) {
        getSoftAssert().assertThat(asList(panels).get(0).getName()).as("panel name").isEqualTo("lyn");
    }

    @Test(dataProvider = "getPanelData", dataProviderClass = DataSuppliers.class)
    public void accessCodeShouldBeDeleted(final Panel... panels) {
        getSoftAssert().assertThat(asList(panels)).as("List of panels").hasSize(2);
    }
}

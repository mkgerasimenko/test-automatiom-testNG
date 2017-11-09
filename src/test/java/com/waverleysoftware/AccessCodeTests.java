package com.waverleysoftware;

import com.waverleysoftware.model.Panel;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static java.util.Arrays.asList;

/**
 * A simple model class for access code testing.
 */
@Slf4j
public class AccessCodeTests extends BaseTest {

    @Test(dataProvider = "getPanelData", dataProviderClass = DataSuppliers.class)
    public void accessCodeShouldBeAdded(final Panel... panels) {
        final String conditionForType = "home";
        SOFTASSERT.assertThat(panels[0].getType()).as("Panel Name").isEqualTo(conditionForType);
    }

    @Name(name = "example", type = "code")
    public String getName() {
        return "someName";
    }

    @Test(dataProvider = "getPanelData", dataProviderClass = DataSuppliers.class)
    public void accessCodeShouldBeCreatedWithSomeDates(final Panel... panels) {
        SOFTASSERT.assertThat(asList(panels).get(0).getName()).as("panel name").isEqualTo("lyn");
    }

    @Test(dataProvider = "getPanelData", dataProviderClass = DataSuppliers.class)
    public void accessCodeShouldBeDeleted(final Panel... panels) {
        SOFTASSERT.assertThat(asList(panels)).as("List of panels").hasSize(2);
    }
}

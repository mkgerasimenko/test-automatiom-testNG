package com.waverleysoftware;

import com.waverleysoftware.data.DataSuppliers;
import com.waverleysoftware.model.Panel;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.waverleysoftware.listemers.TestListener.getSoftAssert;
import static java.util.Arrays.asList;

/**
 * A simple class for access code testing.
 */
@Slf4j
public class AccessCodeTests extends BaseTest {

    @Test(dataProvider = "getPanelData", dataProviderClass = DataSuppliers.class)
    public void accessCodeShouldBeAdded(final Panel... panels) {
        getSoftAssert().assertThat(panels[0].getType())
                .as("Panel Type").isEqualTo("home");

        getSoftAssert().assertThat(panels[1].getName())
                .as("Panel Name").isEqualTo("adc");
    }

    @Test(dataProvider = "getPanelData", dataProviderClass = DataSuppliers.class)
    public void accessCodeShouldBeCreatedWithSomeDates(final Panel... panels) {
        getSoftAssert().assertThat(asList(panels).get(0).getName())
                .as("panel name").isEqualTo("lyn");

        getSoftAssert().assertThat(asList(panels).get(1).getMasterCode())
                .as("panel master code").isEqualTo("2222");
    }

    @Test(dataProvider = "getPanelData", dataProviderClass = DataSuppliers.class)
    public void accessCodeShouldBeDeleted(final Panel... panels) {
        getSoftAssert().assertThat(asList(panels))
                .as("List of panels").hasSize(2);
    }
}

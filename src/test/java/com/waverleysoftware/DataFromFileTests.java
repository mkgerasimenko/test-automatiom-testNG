package com.waverleysoftware;

import com.waverleysoftware.basecore.BaseTest;
import com.waverleysoftware.data.Data;
import com.waverleysoftware.data.DataSuppliers;
import com.waverleysoftware.model.Client;
import com.waverleysoftware.model.Panel;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.waverleysoftware.assertions.CustomAssertions.assertThat;

/**
 * A simple class for some data testing.
 */
@Slf4j
public class DataFromFileTests extends BaseTest {

    @Data(source = "panel.json", entity = Panel.class)
    @Test(dataProvider = "getData", dataProviderClass = DataSuppliers.class)
    public void singleObjectSingleClass(final Panel panel) {
        assertThat(panel).hasPanelName("adc");
    }

    @Data(source = "panels.json", entity = Panel[].class)
    @Test(dataProvider = "getData", dataProviderClass = DataSuppliers.class)
    public void multiObjectsMultiClasses(final Panel panel) {
        assertThat(panel).hasPanelName("lyn");
    }

    @Data(source = "panel.json", entity = Panel[].class)
    @Test(dataProvider = "getData", dataProviderClass = DataSuppliers.class)
    public void singleObjectMultiClasses(final Panel panel) {
        assertThat(panel).hasMasterCode("2222");
    }

    @Data(source = "panels.json", entity = Panel.class)
    @Test(dataProvider = "getData", dataProviderClass = DataSuppliers.class)
    public void multiObjectsSingleClass(final Panel panel) {
        assertThat(panel).hasMasterCode("1111");
    }

    @Data(source = "client.csv", entity = Client.class)
    @Test(dataProvider = "getData", dataProviderClass = DataSuppliers.class)
    public void clientSingleTest(final Client client) {
        assertThat(client).hasAge(12);
    }

    @Data(source = "clients.csv", entity = Client.class)
    @Test(dataProvider = "getData", dataProviderClass = DataSuppliers.class)
    public void clientMultiTest(final Client client) {
        assertThat(client).hasClientName("Pavel");
    }
}


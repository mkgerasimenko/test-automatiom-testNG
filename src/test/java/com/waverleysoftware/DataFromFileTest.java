package com.waverleysoftware;

import com.waverleysoftware.data.Data;
import com.waverleysoftware.data.DataSuppliers;
import com.waverleysoftware.model.Client;
import com.waverleysoftware.model.Panel;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.waverleysoftware.assertions.CustomAssertions.assertThat;
import static org.joor.Reflect.on;

/**
 * A simple class for some data testing.
 */
@Slf4j
public class DataFromFileTest extends BaseTest {

    @Data(source = "panel.json", dataClass = Panel.class)
    @Test(dataProvider = "getData", dataProviderClass = DataSuppliers.class)
    public void panelShouldBeCreated(final Panel panel) {
        assertThat(panel).hasPanelName("ac");
    }

    @Data(source = "client.xml", dataClass = Client.class)
    @Test(dataProvider = "getData", dataProviderClass = DataSuppliers.class)
    public void clientShouldBeModified(final Client client) {
        assertThat(client).hasJob("Child");
    }

    @Data(source = "client.xml", dataClass = Client.class)
    @Test(dataProvider = "getData", dataProviderClass = DataSuppliers.class)
    public void clientShouldBeDeleted(final Client client) {
        assertThat(client).hasClientName("Pavel");
    }

    @Test
    public void clientShouldBeHasSameName() {
        assertThat((Client) on(Client.class).create().get()).hasClientName("Maks");
    }
}

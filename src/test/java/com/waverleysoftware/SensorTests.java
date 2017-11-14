package com.waverleysoftware;

import com.waverleysoftware.data.DataSuppliers;
import com.waverleysoftware.model.Sensor;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.waverleysoftware.listemers.TestListener.getSoftAssert;
import static com.waverleysoftware.model.Type.EMBEDDED;
import static java.util.Arrays.asList;

/**
 * A simple class for sensor testing.
 */
@Slf4j
public class SensorTests extends BaseTest {

    @Test(dataProvider = "getSensorData", dataProviderClass = DataSuppliers.class)
    public void sensorShouldBeAdded(final Sensor... sensors) {
        getSoftAssert().assertThat(sensors[0].getType())
                .as("Sensor type").isEqualTo(EMBEDDED);

        getSoftAssert().assertThat(sensors[0].getName())
                .as("Sensor name").isEqualTo("Door");
    }

    @Test(dataProvider = "getSensorData", dataProviderClass = DataSuppliers.class)
    public void sensorShouldBeModified(final Sensor... sensors) {
        getSoftAssert().assertThat(sensors[2].getType())
                .as("sensor type").isEqualTo(EMBEDDED);

        getSoftAssert().assertThat(sensors[1].getName())
                .as("sensor name").isEqualTo("Window");
    }

    @Test(dataProvider = "getSensorData", dataProviderClass = DataSuppliers.class)
    public void sensorShouldBeDeleted(final Sensor... sensors) {
        getSoftAssert().assertThat(asList(sensors))
                .as("Sensor List").hasSize(3);
    }
}

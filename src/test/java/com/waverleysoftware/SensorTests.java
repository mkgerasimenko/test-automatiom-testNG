package com.waverleysoftware;

import com.waverleysoftware.model.Sensor;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static java.util.Arrays.asList;

/**
 * A simple model class for sensor testing.
 */
@Slf4j
public class SensorTests extends BaseTest {

    @Test(dataProvider = "getSensorData", dataProviderClass = DataSuppliers.class)
    public void sensorShouldBeAdded(final Sensor... sensors) {
        SOFTASSERT.assertThat(sensors[0].getType().toString().toLowerCase()).as("Sensor type").isEqualTo("embedded");
    }

    @Test(dataProvider = "getSensorData", dataProviderClass = DataSuppliers.class)
    public void sensorShouldBeModified(final Sensor... sensors) {
        SOFTASSERT.assertThat(sensors[2].getName()).as("Sensor name").isEqualTo("Garage");
    }

    @Test(dataProvider = "getSensorData", dataProviderClass = DataSuppliers.class)
    public void sensorShouldBeDeleted(final Sensor... sensors) {
        SOFTASSERT.assertThat(asList(sensors)).as("Sensor List").hasSize(3);
    }
}

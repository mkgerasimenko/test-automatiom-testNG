package com.waverleysoftware;

import com.waverleysoftware.model.Sensor;
import com.waverleysoftware.model.Type;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.waverleysoftware.listemers.TestListener.getSoftAssert;
import static java.util.Arrays.asList;

/**
 * A simple model class for sensor testing.
 */
@Slf4j
public class SensorTests extends BaseTest {
    @Test(dataProvider = "getSensorData", dataProviderClass = DataSuppliers.class)
    public void sensorShouldBeAdded(final Sensor... sensors) {

        getSoftAssert().assertThat(sensors[0].getType())
                .as("Sensor type").isEqualTo(Type.HINGED);

        getSoftAssert().assertThat(sensors[1].getType())
                .as("Sensor type").isEqualTo(Type.EMBEDDED);
    }

    @Test(dataProvider = "getSensorData", dataProviderClass = DataSuppliers.class)
    public void sensorShouldBeModified(final Sensor... sensors) {

        getSoftAssert().assertThat(sensors[2].getName())
                .as("Sensor name").isEqualTo("Garae");
    }

    @Test(dataProvider = "getSensorData", dataProviderClass = DataSuppliers.class)
    public void sensorShouldBeDeleted(final Sensor... sensors) {

        getSoftAssert().assertThat(asList(sensors))
                .as("Sensor List").hasSize(3);
    }
}

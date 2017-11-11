package com.waverleysoftware;

import com.waverleysoftware.model.Sensor;
import org.testng.annotations.Test;

import java.util.logging.Level;

/**
 * A simple model class for sensor testing.
 */
public class SensorTests extends BaseTest {

    @Test(dataProvider = "getSensorData", dataProviderClass = DataSuppliers.class)
    public void sensorShouldBeAdded(final Sensor sensor) {
        final String typeOfSensor = sensor.getType().toString().toLowerCase();
        final String condition = "embedded";
        if (condition.equals(typeOfSensor)
                && LOG.isLoggable(Level.INFO)) {
            LOG.info("Selected sensor with " + typeOfSensor + " type added");
        }
    }

    @Test(dataProvider = "getSensorData", dataProviderClass = DataSuppliers.class)
    public void sensorShouldBeModified(final Sensor sensor) {
        final String nameOfSensor = sensor.getName();
        final String condition = "Door";
        if (condition.equals(nameOfSensor)
                && LOG.isLoggable(Level.INFO)) {
            LOG.info(sensor.getType().toString().toLowerCase() + " sensor type and name " + nameOfSensor + " added");
        }
    }

    @Test(dataProvider = "getSensorData", dataProviderClass = DataSuppliers.class)
    public void sensorShouldBeDeleted(final Sensor sensor) {
        if (LOG.isLoggable(Level.INFO)) {
            LOG.info(sensor.getType().toString().toLowerCase() + " sensor type, name " + sensor.getName() + " deleted");
        }
    }
}

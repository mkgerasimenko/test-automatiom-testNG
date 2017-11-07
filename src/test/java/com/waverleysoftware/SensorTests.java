package com.waverleysoftware;

import org.testng.annotations.Test;

public class SensorTests extends BaseTest {
    @Test(priority = 4)
    public void sensorShouldBeAdded() {
        System.out.println("Sensor added");
    }

    @Test(priority = 5)
    public void sensorShouldBeModified() {
        System.out.println("Sensor modified");
    }

    @Test(priority = 6)
    public void sensorShouldBeDeleted() {
        System.out.println("Sensor deleted");
    }
}

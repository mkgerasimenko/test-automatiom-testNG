package com.waverleysoftware.model;

import lombok.Data;

/**
 * A simple model class for sensor processing.
 */
@Data
public class Sensor {

    private final String name;
    private final Type type;
}

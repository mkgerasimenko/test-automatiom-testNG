package com.waverleysoftware.model;

/**
 * Author mkgerasimenko.
 */
public class Sensor {

    private final String name;
    private final Type type;

    public Sensor(final String name, final Type type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }
}

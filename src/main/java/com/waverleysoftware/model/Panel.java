package com.waverleysoftware.model;

/**
 * A simple model class for user processing.
 */
public class Panel {

    private final String name;
    private final String masterCode;
    private final String type;
    private final boolean hasTouchScreen;

    public Panel(final String name, final String masterCode, final String type, final boolean hasTouchScreen) {
        this.name = name;
        this.masterCode = masterCode;
        this.type = type;
        this.hasTouchScreen = hasTouchScreen;
    }

    public String getName() {
        return name;
    }

    public String getMasterCode() {
        return masterCode;
    }

    public String getType() {
        return type;
    }

    public boolean isHasTouchScreen() {
        return hasTouchScreen;
    }

    @Override
    public String toString() {
        return "Panel{"
                + "name='" + name + '\''
                + ", masterCode='" + masterCode + '\''
                + '}';
    }
}

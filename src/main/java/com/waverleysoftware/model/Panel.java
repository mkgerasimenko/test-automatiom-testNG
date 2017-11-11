package com.waverleysoftware.model;

/**
 * A simple model class for panel processing.
 */
public class Panel {

    private final String name;
    private final String masterCode;
    private final String type;
    private final boolean touchScreen;

    public Panel(final String name, final String masterCode, final String type, final boolean touchScreen) {
        this.name = name;
        this.masterCode = masterCode;
        this.type = type;
        this.touchScreen = touchScreen;
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

    public boolean hasTouchScreen() {
        return touchScreen;
    }

    @Override
    public String toString() {
        return "Panel{"
                + "name='" + name + '\''
                + ", masterCode='" + masterCode + '\''
                + '}';
    }
}

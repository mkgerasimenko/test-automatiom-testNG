package com.waverleysoftware.model;

import lombok.Data;

/**
 * A simple model class for panel processing.
 */
@Data
public class Panel {

    private final String name;
    private final String masterCode;
    private final String type;
    private final boolean touchScreen;
}

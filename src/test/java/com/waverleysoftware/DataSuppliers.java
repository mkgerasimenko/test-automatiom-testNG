package com.waverleysoftware;

import com.waverleysoftware.model.Panel;
import com.waverleysoftware.model.Sensor;
import io.github.sskorol.core.DataSupplier;
import one.util.streamex.StreamEx;

import static com.waverleysoftware.model.Type.EMBEDDED;
import static com.waverleysoftware.model.Type.HINGED;

/**
 * A simple model class for data processing.
 */
public class DataSuppliers {

    @DataSupplier
    public StreamEx getPanelData() {
        return StreamEx.of(
                new Panel("Lyn", "1111", "home", true),
                new Panel("ADC", "2222", "office", false));
    }

    @DataSupplier
    public StreamEx getSensorData() {
        return StreamEx.of(
                new Sensor("Door", EMBEDDED),
                new Sensor("Window", HINGED),
                new Sensor("Garage", EMBEDDED)
        );
    }
}

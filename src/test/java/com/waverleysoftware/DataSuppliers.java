package com.waverleysoftware;

import com.waverleysoftware.model.Panel;
import com.waverleysoftware.model.Sensor;
import io.github.sskorol.core.DataSupplier;
import one.util.streamex.StreamEx;

import static com.waverleysoftware.model.Type.EMBEDDED;
import static com.waverleysoftware.model.Type.HINGED;
import static java.util.Arrays.asList;

/**
 * A simple model class for data processing.
 */
public class DataSuppliers {
    @DataSupplier(transpose = true)
    public StreamEx getPanelData() {
        return StreamEx.of(
                new Panel("lyn", "1111", "home", true),
                new Panel("adc", "2222", "office", false));
    }

    @DataSupplier(transpose = true)
    public StreamEx getSensorData() {
        return StreamEx.of(asList(new Sensor("Door", EMBEDDED),
                new Sensor("Window", HINGED),
                new Sensor("Garage", EMBEDDED)));
    }
}

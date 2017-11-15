package com.waverleysoftware.data;

import com.waverleysoftware.model.Panel;
import com.waverleysoftware.model.Sensor;
import io.github.sskorol.core.DataSupplier;
import one.util.streamex.StreamEx;

import java.lang.reflect.Method;

import static com.waverleysoftware.listemers.SecondTestListener.getImplByDataSource;
import static com.waverleysoftware.model.Type.EMBEDDED;
import static com.waverleysoftware.model.Type.HINGED;
import static java.util.Arrays.asList;
import static java.util.Optional.ofNullable;
import static org.joor.Reflect.on;

/**
 * A simple model class for data processing.
 */
public class DataSuppliers {

    @DataSupplier(transpose = true)
    public StreamEx getPanelData() {
        return StreamEx.of(on(Panel.class).create("lyn", "1111", "home").get(),
                on(Panel.class).create("adc", "2222", "office").get());
    }

    @DataSupplier(transpose = true)
    public StreamEx getSensorData() {
        return StreamEx.of(asList(new Sensor(1, "Door", EMBEDDED),
                new Sensor(2, "Window", HINGED),
                new Sensor(3, "Garage", EMBEDDED)));
    }

    @DataSupplier(flatMap = true)
    public <T> T getData(final Method method) {
        return getTypeByProvidedInfo(method);
    }

    @SuppressWarnings("unchecked")
    private <T> T getTypeByProvidedInfo(final Method method) {
        
        return ofNullable(method.getDeclaredAnnotation(Data.class))
                .map(Data::source)
                .map(source -> getImplByDataSource(source).readFrom(source, (Class<T>) method.getDeclaredAnnotation(Data.class).dataClass()))
                .orElseThrow(() -> new NoClassDefFoundError("No Data class found"));
    }

}

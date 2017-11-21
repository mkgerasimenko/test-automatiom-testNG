package com.waverleysoftware.data.impl;

import com.waverleysoftware.data.api.DataReader;
import io.vavr.control.Try;

import static java.lang.ClassLoader.getSystemResource;
import static java.nio.file.Files.lines;
import static java.nio.file.Paths.get;
import static org.joor.Reflect.on;

/**
 * Please note, you must initialize you reader
 * A simple class for reading Csv files.
 */
public class CsvReader implements DataReader {
    @Override
    public String getEntityType() {
        return "csv";
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] readFrom(final String dataSource, final Class<T> entityClass) {

        return (T[]) Try.of(() -> lines(get(getSystemResource(dataSource).toURI())))
                .mapTry(streamOfStrings -> streamOfStrings
                        .skip(1)
                        .map(line -> line.split(";"))
                        .map(data -> on(entityClass).create((Object[]) data).get()).toArray())
                .getOrElseThrow(e -> new IllegalArgumentException("Unable to readFrom " + dataSource, e));
    }
}

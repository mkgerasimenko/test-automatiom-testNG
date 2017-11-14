package com.waverleysoftware.data.impl;

import com.google.gson.Gson;
import com.waverleysoftware.data.api.DataReader;
import io.vavr.control.Try;

import java.io.FileReader;

import static java.lang.ClassLoader.getSystemResource;

/**
 * Please note, you must initialize you
 * A simple class for reading Json files.
 */
public class JsonReader implements DataReader {

    @Override
    public String getEntityType() {
        return "json";
    }

    @Override
    public <T> T readFrom(final String dataSource, final Class<T> entityClass) {

        return Try.of(() -> new FileReader(getSystemResource(dataSource).getPath()))
                .mapTry(com.google.gson.stream.JsonReader::new)
                .mapTry(reader -> entityClass.cast(new Gson().fromJson(reader, entityClass)))
                .getOrElseThrow(e -> new IllegalArgumentException("Unable to readFrom " + dataSource, e));
    }
}

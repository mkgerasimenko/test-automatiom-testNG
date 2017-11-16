package com.waverleysoftware.data.impl;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.waverleysoftware.data.api.DataReader;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

import static java.lang.ClassLoader.getSystemResource;

/**
 * Please note, you must initialize you reader
 * A simple class for reading Json files.
 */
public class JsonReader implements DataReader {

    @Override
    public String getEntityType() {
        return "json";
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] readFrom(final String dataSource, final Class<T> entityClass) {
        final Gson gson = new Gson();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(getSystemResource(dataSource).getPath()), "UTF-8"));
             com.google.gson.stream.JsonReader reader = new com.google.gson.stream.JsonReader(br)) {
            final JsonElement jsonElement = new JsonParser().parse(reader);
            return jsonElement.isJsonArray()
                    ? gson.fromJson(jsonElement, castToArray(entityClass))
                    : (T[]) new Object[]{gson.fromJson(jsonElement, castToObject(entityClass))};
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to readFrom " + dataSource, e);
        }
    }

    @SuppressWarnings("unchecked")
    private <T> Class<T> castToObject(final Class<T> entityClass) {
        return (Class<T>) (entityClass.isArray() ? entityClass.getComponentType() : entityClass);
    }

    @SuppressWarnings("unchecked")
    private <T> Class<T[]> castToArray(final Class<T> entityClass) {
        return (Class<T[]>) (entityClass.isArray() ? entityClass : Array.newInstance(entityClass, 1).getClass());
    }
}

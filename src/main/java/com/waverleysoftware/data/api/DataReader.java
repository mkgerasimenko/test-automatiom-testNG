package com.waverleysoftware.data.api;

/**
 * Please note, you must initialize the type of reading value
 * A simple interface for readFrom of file processing.
 */
public interface DataReader {

    String getEntityType();

    <T> T readFrom(String dataSource, Class<T> entityClass);
}

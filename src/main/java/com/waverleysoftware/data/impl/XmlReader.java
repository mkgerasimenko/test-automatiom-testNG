package com.waverleysoftware.data.impl;

import com.waverleysoftware.data.api.DataReader;
import io.vavr.control.Try;

import javax.xml.bind.JAXBContext;
import java.io.File;

import static java.lang.ClassLoader.getSystemResource;
import static javax.xml.bind.JAXBContext.newInstance;

/**
 * A simple class for reading Json files.
 */

public class XmlReader implements DataReader {

    @Override
    public String getEntityType() {
        return "xml";
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T readFrom(final String dataSource, final Class<T> entityClass) {
        return Try.of(() -> newInstance(entityClass))
                .mapTry(JAXBContext::createUnmarshaller)
                .mapTry(unmarshaller -> (T) unmarshaller.unmarshal(new File(getSystemResource(dataSource).getPath())))
                .getOrElseThrow(e -> new IllegalArgumentException("Unable to readFrom " + dataSource, e));
    }
}

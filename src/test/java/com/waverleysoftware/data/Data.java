package com.waverleysoftware.data;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Data annotation for marking test method to the source data file.
 */
@Repeatable(value = DataCollection.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Data {

    String source() default "data";

    Class entity() default Object.class;
}

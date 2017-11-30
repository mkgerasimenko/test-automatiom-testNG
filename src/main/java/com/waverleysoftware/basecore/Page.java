package com.waverleysoftware.basecore;

/**
 * A simple interface of obtaining url for test page.
 */
public interface Page {

    Page navigateTo();

    default String url() {
        return "http://localhost";
    }
}

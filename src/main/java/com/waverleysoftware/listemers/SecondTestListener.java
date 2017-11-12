package com.waverleysoftware.listemers;

import lombok.extern.slf4j.Slf4j;
import org.testng.ISuite;
import org.testng.ISuiteListener;

@SuppressWarnings("JavadocType")
@Slf4j
public class SecondTestListener implements ISuiteListener {
    @Override
    public void onStart(final ISuite suite) {
        log.info("Start!!!!");
    }

    @Override
    public void onFinish(final ISuite suite) {
        log.info("Finish!!!!");
    }
}

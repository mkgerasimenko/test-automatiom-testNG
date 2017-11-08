package com.waverleysoftware.listemers;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import java.util.logging.Logger;

@SuppressWarnings("JavadocType")
public class SecondTestListener implements ISuiteListener {

    private static final Logger LOG = Logger.getLogger(TestListener.class.getName());

    @Override
    public void onStart(final ISuite suite) {
        LOG.info("Start!!!!");
    }

    @Override
    public void onFinish(final ISuite suite) {
        LOG.info("Finish!!!!");
    }
}

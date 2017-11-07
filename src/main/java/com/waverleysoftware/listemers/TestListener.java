package com.waverleysoftware.listemers;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import java.util.logging.Logger;

@SuppressWarnings("JavadocType")
public class TestListener implements IInvokedMethodListener {

    private static final Logger LOG = Logger.getLogger(TestListener.class.getName());

    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {
        getParameters();
    }

    @Override
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult) {
        if (method.isTestMethod() && testResult.getStatus() == ITestResult.SUCCESS) {
            takeScreenshot();
        }
    }

    private void takeScreenshot() {
        LOG.info("Taking screenshot");
    }

    private void getParameters() {
        LOG.info("Getting parameters");
    }
}

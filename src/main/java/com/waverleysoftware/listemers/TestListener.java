package com.waverleysoftware.listemers;

import lombok.extern.slf4j.Slf4j;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

@SuppressWarnings("JavadocType")
@Slf4j
public class TestListener implements IInvokedMethodListener {

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
        log.info("Taking screenshot");
    }

    private void getParameters() {
        log.info("Getting parameters");
    }
}

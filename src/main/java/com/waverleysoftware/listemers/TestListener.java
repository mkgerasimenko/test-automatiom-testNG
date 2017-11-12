package com.waverleysoftware.listemers;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

@SuppressWarnings({"JavadocType", "unchecked"})
@Slf4j
public class TestListener implements IInvokedMethodListener {
    private static ThreadLocal thread = new ThreadLocal();

    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {
        final SoftAssertions softAssert = new SoftAssertions();
        thread.set(softAssert);
        getParameters();
    }

    @Override
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult) {
        if (method.getTestMethod().isTest()) {
            try {
                getSoftAssert().assertAll();
            } catch (AssertionError e) {
                testResult.setStatus(TestResult.FAILURE);
                testResult.setThrowable(e);
            }
        }
    }

    private void getParameters() {
        log.info("Getting parameters");
    }

    public static SoftAssertions getSoftAssert() {
        return (SoftAssertions) thread.get();
    }
}

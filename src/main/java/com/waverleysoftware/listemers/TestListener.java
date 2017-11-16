package com.waverleysoftware.listemers;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

import static io.vavr.API.*;
import static java.util.Optional.ofNullable;

@Slf4j
@SuppressWarnings("JavadocType")
public class TestListener implements IInvokedMethodListener {

    private static final ThreadLocal<SoftAssertions> THREAD_LOCAL_CONTAINER_FOR_SOFT_ASSERTIONS = new ThreadLocal<>();
    private static final ThreadLocal<WebDriver> WEB_DRIVER = new ThreadLocal<>();

    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {
        THREAD_LOCAL_CONTAINER_FOR_SOFT_ASSERTIONS.set(new SoftAssertions());

        if (method.isTestMethod()) {
            WEB_DRIVER.set(
                    Match(testResult.getTestContext().getCurrentXmlTest().getParameter("browser")).of(
                            Case($(String::isEmpty), () -> {
                                throw new IllegalStateException("'browser' property is missing!");
                            }),
                            Case($(BrowserType.FIREFOX), () -> {
                                WebDriverManager.getInstance(FirefoxDriver.class).setup();
                                return new FirefoxDriver();
                            }),
                            Case($(BrowserType.CHROME), () -> {
                                WebDriverManager.getInstance(ChromeDriver.class).setup();
                                return new ChromeDriver();
                            }),
                            Case($(), browser -> {
                                throw new IllegalArgumentException(browser + " browser is not supported!");
                            })
                    ));
        }
    }

    @Override
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult) {
        if (method.getTestMethod().isTest() && testResult.getStatus() == ITestResult.SUCCESS) {
            try {
                getSoftAssert().assertAll();
            } catch (AssertionError e) {
                testResult.getTestContext().getPassedTests().removeResult(testResult.getMethod());
                testResult.setStatus(TestResult.FAILURE);
                testResult.setThrowable(e);
            }
        }

        if (method.isTestMethod()) {
            ofNullable(getWebDriver()).ifPresent(driver -> Try.run(driver::quit));
        }
        WEB_DRIVER.remove();
    }

    public static SoftAssertions getSoftAssert() {
        return THREAD_LOCAL_CONTAINER_FOR_SOFT_ASSERTIONS.get();
    }

    public static WebDriver getWebDriver() {
        return WEB_DRIVER.get();
    }
}

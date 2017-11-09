package com.waverleysoftware;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * A simple base class for processing tests.
 */
@Slf4j
public class BaseTest {

    protected static final SoftAssertions SOFTASSERT = new SoftAssertions();

    @BeforeClass
    public void setUp(final ITestContext context) {
        log.info(context.getCurrentXmlTest().getName());
        log.info("Starting process on parent level");
    }

    @BeforeMethod
    public void setUp(final ITestContext context, final Method method) {
        log.info(method.getName());
        log.info(String.valueOf(method.getDeclaredAnnotation(Test.class)));
        log.info(context.getCurrentXmlTest().getParameter("browser"));
    }

    @AfterClass
    public void tearDown() {
        log.info("Ending process on parent level");
        SOFTASSERT.assertAll();
    }
}

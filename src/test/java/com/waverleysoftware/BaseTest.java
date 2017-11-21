package com.waverleysoftware;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.time.LocalDate;

/**
 * A simple base class for processing tests.
 */
@Slf4j
public class BaseTest {

    @BeforeClass
    public void setUp(final ITestContext context) {
        log.info("{} - {}", "Starting process on parent level",
                LocalDate.now(),
                context.getCurrentXmlTest().getName());
    }

    @BeforeMethod
    public void setUp(final ITestContext context, final Method method) {
        log.info("Method {}, with declared annotation {} and with group {}.",
                method.getName(), String.valueOf(method.getDeclaredAnnotation(Test.class)));
    }

    @AfterClass
    public void tearDown() {
        log.info("Ending process on parent level");
    }

}

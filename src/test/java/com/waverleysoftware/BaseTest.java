package com.waverleysoftware;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

/**
 * A simple base class for processing tests.
 */
public class BaseTest {

    protected static final Logger LOG = Logger.getLogger(BaseTest.class.getName());

    @BeforeClass
    public void setUp() {
        LOG.info("Setting up on parent level");
    }

    @AfterClass
    public void tearDown() {
        LOG.info("Ending process on parent level");
    }
}

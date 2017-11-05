package com.waverleysoftware;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @BeforeClass
    public void setUp() {
        System.out.println("Setting up on parent level");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Ending process on parent level");
    }
}

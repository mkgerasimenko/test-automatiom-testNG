package com.waverleysoftware;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AccessCodeTests extends BaseTest {
    @BeforeClass
    public void setUp() {
        System.out.println("Setting up on child level");
    }

    @Test(priority = 1)
    public void accessCodeShouldBeCreated() {
        System.out.println("Access code created");
    }

    @Test(priority = 2)
    public void accessCodeShouldBeModified() {
        System.out.println("Access code modified");
    }

    @Test(priority = 3)
    public void accessCodeShouldBeDeleted() {
        System.out.println("Access code deleted");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Ending process on child level");
    }
}

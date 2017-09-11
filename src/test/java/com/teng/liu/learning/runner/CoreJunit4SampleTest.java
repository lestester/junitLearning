package com.teng.liu.learning.runner;

import org.hamcrest.core.Is;
import org.junit.*;

public class CoreJunit4SampleTest {
    @BeforeClass
    public static void beforeClass() {
        System.out.println("beforeClass method executed");
    }

    @BeforeClass
    public static void beforeClass2() {
        System.out.println("beforeClass2 method executed");
    }

    @AfterClass
    public static void afrerClass() {
        System.out.println("afterClass method executed ");
    }

    @Before
    public void before() {
        System.out.println("before method executed ");
    }

    @After
    public void after() {
        System.out.println("after method executed ");
    }

    @Test
    public void testSucceeded() {
        System.out.println("testSucceeded method executed");
    }

    @Test
    @Ignore
    public void testIgnore() {
        System.out.println("testIgnore method executed");
    }

    @Test
    public void testFailed() {
        System.out.println("testFailed method executed");
        throw new RuntimeException("Throw delibrately.....");
    }

    @Test
    public void testAssumptionFailed() {
        System.out.println("testAssumptionFailed method executed");
        Assume.assumeThat(0, Is.is(1));
    }

    @Test
    public void testFilteredOut() {
        System.out.println("testFilteredOut method executed.");
    }
}

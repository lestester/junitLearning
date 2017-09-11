package com.teng.liu.learning.runner;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class LogRunListener extends RunListener {


    @Override
    public void testRunStarted(Description description) throws Exception {
        System.out.println("==>Junit 4 started  with description: \n" + description);
        System.out.println();
    }

    @Override
    public void testRunFinished(Result result) throws Exception {
        System.out.println("==>Junit 4 finished with result: \n" + describe(result));
    }

    @Override
    public void testStarted(Description description) throws Exception {
        System.out.println("==> Test method started with description: " + description);
        System.out.println();
    }

    @Override
    public void testFinished(Description description) throws Exception {
        System.out.println("==> Test method finished with description: " + description);
        System.out.println();
    }

    @Override
    public void testFailure(Failure failure) throws Exception {
        System.out.println("==>Test method failed with failure: " + failure);
    }

    @Override
    public void testAssumptionFailure(Failure failure) {
        System.out.println("==>Test method assumption failed with failure: " + failure);

    }

    @Override
    public void testIgnored(Description description) throws Exception {
        System.out.println("==>Test method ignored with description:  " + description);
        System.out.println();
    }


    private String describe(Result result) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\tFailureCount: " + result.getFailureCount())
                .append("\n");

        stringBuilder.append("\tIgnoreCount: " + result.getIgnoreCount())
                .append("\n");
        stringBuilder.append("\tRunCount: " + result.getRunCount())
                .append("\n");
        stringBuilder.append("\tRunTime: " + result.getRunTime())
                .append("\n");
        stringBuilder.append("\tFailures: " + result.getFailures())
                .append("\n");
        return stringBuilder.toString();


    }
}

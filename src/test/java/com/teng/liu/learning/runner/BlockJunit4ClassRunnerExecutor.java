package com.teng.liu.learning.runner;

import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.util.Comparator;

public class BlockJunit4ClassRunnerExecutor {
    public static void main(String[] args) {
        RunNotifier notifier = new RunNotifier();
        Result result = new Result();
        notifier.addFirstListener(result.createListener());
        notifier.addListener(new LogRunListener());

        Runner runner = null;

        try {
            runner = new BlockJUnit4ClassRunner(CoreJunit4SampleTest.class);

            try {
                ((BlockJUnit4ClassRunner) runner).filter(new MethodNameFilter("testFilteredOut"));
            } catch (NoTestsRemainException e) {
                System.out.println("All methods are been filtered out");
                return;
            }

            ((BlockJUnit4ClassRunner) runner).sort(new Sorter(new Comparator<Description>() {
                public int compare(Description o1, Description o2) {
                    return o1.getMethodName().compareTo(o2.getMethodName());
                }
            }));

        } catch (Throwable throwable) {
            runner = new ErrorReportingRunner(CoreJunit4SampleTest.class, throwable);
        }

        notifier.fireTestRunStarted(runner.getDescription());
        runner.run(notifier);
        notifier.fireTestRunFinished(result);
    }
}

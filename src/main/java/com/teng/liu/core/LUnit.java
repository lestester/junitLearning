package com.teng.liu.core;

import com.google.common.base.Preconditions;
import com.teng.liu.services.ServicesFactory;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;

import java.util.List;

public class LUnit extends ParentRunner {
    /**
     * Constructs a new {@code ParentRunner} that will run {@code @TestClass}
     *
     * @param testClass
     */

    private LUnitOptions options;

    protected LUnit(Class testClass) throws InitializationError {
        super(testClass);
        this.options = new LUnitOptions(testClass);
        List<String> files = options.testCases();
        Preconditions.checkArgument(files.size() > 0 ,"case文件不存在请检查 case文件配置！");
        List<String> services = options.services();
        ServicesFactory.init(services);





    }

    protected List getChildren() {
        return null;
    }

    protected Description describeChild(Object child) {
        return null;
    }

    protected void runChild(Object child, RunNotifier notifier) {

    }
}



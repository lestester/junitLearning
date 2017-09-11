package com.teng.liu.learning.runner;

import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;

import java.util.HashSet;
import java.util.Set;

public class MethodNameFilter extends Filter {

    private final Set<String> excludedMethodNames = new HashSet<String>();
    public MethodNameFilter(String... excludedMethods){
        for (String excludedMethodName:
             excludedMethods) {
            this.excludedMethodNames.add(excludedMethodName);
        }
    }
    @Override
    public boolean shouldRun(Description description) {
        String methodName = description.getMethodName();
        if(excludedMethodNames.contains(methodName)){
            return false;
        }
        return true;
    }

    @Override
    public String describe() {
        return this.getClass().getSimpleName() + " - excluded methods " + excludedMethodNames;
    }
}

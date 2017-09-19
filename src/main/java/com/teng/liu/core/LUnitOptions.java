package com.teng.liu.core;

import com.google.common.collect.Lists;

import java.util.List;

public class LUnitOptions {

    private Options options;
    private Class<?> testClass;

    public LUnitOptions(java.lang.Class<?> aClass) {
        this.testClass = aClass;
        this.options = testClass.getAnnotation(Options.class);
    }

    public List<String> testCases() {
        return getCaseFiles(options.files());
    }

    private List<String> getCaseFiles(String[] files) {
        // 根据配置传入的名字找到符合条件的所有文件的绝对路径返回
        List<String> filesWithPath = Lists.newArrayList();
        return filesWithPath;
    }

    public List<String> services() {
        return getCaseFiles(options.services());
    }
}

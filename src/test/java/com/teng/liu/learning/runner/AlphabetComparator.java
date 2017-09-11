package com.teng.liu.learning.runner;

import org.junit.runner.Description;

import java.util.Comparator;

public class AlphabetComparator implements Comparator<Description> {
    public int compare(Description o1, Description o2) {
        return o1.getMethodName().compareTo(o2.getMethodName());
    }
}

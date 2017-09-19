package com.teng.liu.Lunit;

import com.teng.liu.core.TestCaseFileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author teng.liu
 * @create 2017/9/15
 */

public class TestCaseFileUtilsTest {


    @Test
    public void getFileOneTest(){
        String[] files = {"cases/*"};
        List<String> testCaseFile = TestCaseFileUtils.getTestCaseFile(files);
        System.out.println(testCaseFile);
        Assert.assertEquals(4,testCaseFile.size());
    }

    @Test
    public void getFileTwoTest(){
        String[] files = {"cases/*","heihei.xml"};
        List<String> testCaseFile = TestCaseFileUtils.getTestCaseFile(files);
        System.out.println(testCaseFile);
        Assert.assertEquals(5,testCaseFile.size());
    }

    @Test
    public void getFileThreeTest(){
        String[] files = {"cases/*.xml"};
        List<String> testCaseFile = TestCaseFileUtils.getTestCaseFile(files);
        System.out.println(testCaseFile);
        Assert.assertEquals(4,testCaseFile.size());
    }
}

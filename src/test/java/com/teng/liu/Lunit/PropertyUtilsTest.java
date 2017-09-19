package com.teng.liu.Lunit;

import com.teng.liu.utils.PropertyUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author teng.liu
 * @create 2017/9/18
 */

public class PropertyUtilsTest {

    @Test
    public void test(){
        String host = PropertyUtils.getValue("host");
        Assert.assertEquals("https://www.google.com",host);
    }
}

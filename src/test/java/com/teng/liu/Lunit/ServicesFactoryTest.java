package com.teng.liu.Lunit;

import com.google.common.collect.Lists;
import com.teng.liu.services.ServicesConfig;
import com.teng.liu.services.ServicesFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author teng.liu
 * @create 2017/9/19
 */

public class ServicesFactoryTest {


    @Test
    public void initTest(){
        List<String> list = Lists.newArrayList();
        list.add("/Users/teng.liu/githup/junitLearning/src/test/resources/services/services.xml");
        ServicesFactory.init(list);
        Assert.assertEquals(1,ServicesFactory.getChachedCmd().size());
    }
}

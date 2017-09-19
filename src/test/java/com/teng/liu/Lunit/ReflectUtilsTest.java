package com.teng.liu.Lunit;

import com.teng.liu.Lunit.bean.Person;
import com.teng.liu.services.impl.HttpServiceConfig;
import com.teng.liu.utils.ReflectUtils;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author teng.liu
 * @create 2017/9/19
 */

public class ReflectUtilsTest {


    @Test
    public void getFieldsTest(){
        List<Field> allFields = ReflectUtils.getAllFields(HttpServiceConfig.class);
        allFields.forEach(field -> System.out.println(field));
    }

    @Test
    public void initFieldsValueTest() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Field field = Person.class.getField("name");
        Person person = Person.class.newInstance();
        ReflectUtils.initFieldValue(person,field,"李磊");
        Assert.assertEquals("李磊",person.name);
    }
}

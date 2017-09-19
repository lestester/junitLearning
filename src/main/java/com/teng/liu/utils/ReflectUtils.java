package com.teng.liu.utils;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;

/**
 * @author teng.liu
 * @create 2017/9/19
 */

public class ReflectUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectUtils.class);


    public static <T> T newInstance(Class<? extends T> clazz) {

        try {
            return clazz.newInstance();
        } catch (Exception e) {
            LOGGER.error("初始化失败", e);
            throw new RuntimeException(clazz.getName() + " create error!", e.getCause());
        }
    }

    public static <T> List<Field> getAllFields(Class<? extends T> clazz) {

        if (clazz.equals(Object.class)) {
            return Collections.emptyList();

        }
        List<Field> fields = Lists.newArrayList();
        fields.addAll(Lists.newArrayList(clazz.getDeclaredFields())); //加入本类的所有领域 成员变量 属性 方法
        fields.addAll(getAllFields(clazz.getSuperclass()));  //递归加入父类的 Field

        return fields;
    }

    public static boolean isConstant(Field field) {
        return Modifier.isFinal(field.getModifiers());
    }

    public static void initFieldValue(Object newInstance, Field field, Object value) {
        //找到类的setter方法
        Method setter = getSetter(field);
        try {
            if (setter == null) {
                field.setAccessible(true);
                field.set(newInstance, value);
            } else {
                setter.invoke(newInstance, value);
            }
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            throw new RuntimeException(String.format("initialize %s failed！", field.getName()));

        }

    }

    private static Method getSetter(Field field) {
        Class<?> fieldDeclaringClass = field.getDeclaringClass();
        return getMethod(fieldDeclaringClass, field);
    }

    private static Method getMethod(Class<?> fieldDeclaringClass, Field field) {
        Class<?> fieldType = field.getType();
        String methodName = String.format("set%s", StringUtils.capitalize(field.getName()));
        try {
            return fieldDeclaringClass.getMethod(methodName, fieldType);
        } catch (NoSuchMethodException e) {
            LOGGER.error("not such method {} find", methodName, e);
            return null;
        }
    }
}

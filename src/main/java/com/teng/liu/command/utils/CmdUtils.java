package com.teng.liu.command.utils;

import com.teng.liu.utils.ReflectUtils;
import org.dom4j.Element;

import java.lang.reflect.Field;
import java.util.List;

import static com.teng.liu.utils.PropertyUtils.replaceConfigVariable;

/**
 * @author teng.liu
 * @create 2017/9/19
 * 产生 command 工具类
 */

public class CmdUtils {
    //泛型使用学习
    public static <T> T init(Class<? extends T> clazz, Element element) {
        T newInstance = ReflectUtils.newInstance(clazz);
        setServiceName(newInstance, element.getName());
        List<Field> allFields = ReflectUtils.getAllFields(clazz);
        for (Field field : allFields) {
            if (ReflectUtils.isConstant(field)) {
                continue;
            }
            initField(newInstance, field, element);
        }

        return newInstance;
    }

    private static <T> void initField(T newInstance, Field field, Element element) {
        String value = getValueByName(field, element);
        ReflectUtils.initFieldValue(newInstance, field, value);
    }

    /**
     * 当前节点不存在 可能在子节点 同时支持以下两种形式
     * <a key="value"/>
     *
     * <a>
     *  <key>value</key>
     * </a>
     *
     * @param field
     * @param element
     * @return
     */
    private static String getValueByName(Field field, Element element) {
        String name = field.getName();
        String attributeValue = null;
        attributeValue = element.attributeValue(name);

        //从子节点获取
        if (null == attributeValue) {
            Element chirldElement = element.element(name);
            if(chirldElement != null) {
                attributeValue = chirldElement.getText();
            }
        }
        return replaceConfigVariable(attributeValue);
    }


    private static <T> void setServiceName(T newInstance, String name) {
        //todo 待补充完善
    }
}

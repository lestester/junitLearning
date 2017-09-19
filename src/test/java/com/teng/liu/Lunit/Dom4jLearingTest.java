package com.teng.liu.Lunit;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.util.List;

/**
 * @author teng.liu
 * @create 2017/9/18
 */

public class Dom4jLearingTest {


    @Test
    public void test(){
        SAXReader saxReader = new SAXReader();
        try {
            Document read = saxReader.read(new File("/Users/teng.liu/githup/junitLearning/src/test/resources/services/services.xml"));
            Element rootElement = read.getRootElement();
            List<Element> elements = rootElement.elements();
            for(Element element:elements){
                element.getName();
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}

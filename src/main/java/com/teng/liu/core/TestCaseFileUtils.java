package com.teng.liu.core;


import com.google.common.collect.Lists;

import java.io.File;
import java.util.List;

public class TestCaseFileUtils {
    /**
     * 根据传入的文件名返回符合条件的所有测试文件的绝对目录
     * 文件名可能为 cases/casea.xml  caseb.xml  cases/* cases/*.xml
     */
    public static List<String> getTestCaseFile(String[] files){

        List<String> filesWithPath = Lists.newArrayList();
        for(String file : files ){
            int lastIndex = file.lastIndexOf("/");

            String subPath = "";
            String fileName = file;
            //如果lastIndex为 -1
            if(lastIndex != -1 ){
                subPath = file.substring(0,lastIndex);
                fileName = file.substring(lastIndex+1);
            }
            //如果为* 则寻找subPath目录下全部的xml
            if(fileName.equals("*") || fileName.equals("*.xml")){
                //todo 如果封装成jar包 此处读取文件可能会存在问题
                String resourcePath = TestCaseFileUtils.class.getClassLoader().getResource(subPath).getPath();
                getAbsolutePathWithXing(resourcePath,filesWithPath);
            } else {
                String filesPath = TestCaseFileUtils.class.getClassLoader().getResource(fileName).getPath();
                filesWithPath.add(filesPath);
            }

        }
        return filesWithPath;

    }

    private static void getAbsolutePathWithXing(String path, List<String> resultList){
        File[] listFiles = new File(path).listFiles();
        for(File filed : listFiles) {
            if(filed.isDirectory()){
                getAbsolutePathWithXing(filed.getAbsolutePath(),resultList);
                continue;
            }
            resultList.add(filed.getAbsolutePath());
        }
    }

}

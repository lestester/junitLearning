package com.teng.liu.services;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.teng.liu.command.scmd.ExecuteCommand;
import com.teng.liu.command.utils.CmdUtils;
import com.teng.liu.services.impl.HttpServiceConfig;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author teng.liu
 * @create 2017/9/18
 */

public class ServicesFactory {
    private final static Logger LOGGER = LoggerFactory.getLogger(ServicesConfig.class);

    private  final static  Map<String ,Class< ? extends  ServicesConfig > > CONFIG = Maps.newHashMap();

    private static Map<String ,ExecuteCommand > CHACHED_CMD = Maps.newHashMap();


    static{
        //TODO 目前仅支持HTTP
        CONFIG.put(HttpServiceConfig.name,HttpServiceConfig.class);

    }


    public static void init(List<String> files){
        for (String file : files){
            init(file);
        }
    }

    private static void init(String file){
        try {
            Document document = loadFile(file);
            initCommand(document);
        } catch (DocumentException e) {
            LOGGER.error("services文件: " + file + " 不是标准的xml文件");
        }

    }

    private static void initCommand(Document document) {
        Element rootElement = document.getRootElement();
        List<Element> elements = rootElement.elements();
        for(Element element :elements){
            ExecuteCommand cmd = getCmd(element);
            if(CHACHED_CMD.containsKey(cmd.getId())){
               throw new RuntimeException("services 存在重复的 id");
            }
            CHACHED_CMD.put(cmd.getId(),cmd);
            //todo 加载 services的过程装载进入 repoter

        }
    }

    private static ExecuteCommand getCmd(Element element) {
        String servicesName = element.getQName().getName();
        Class<? extends ServicesConfig> servicesConfig = CONFIG.get(servicesName);

        Preconditions.checkNotNull(servicesConfig,"不支持的请求类型:" + servicesName);

        //知道类 知道每个成员变量的值 利用反射的机制 创建类并给其中的成员变量赋值
        ServicesConfig service = CmdUtils.init(servicesConfig, element);
        ExecuteCommand executeCommand = service.creatCommand();

        return executeCommand;
    }

    private static Document loadFile(String file) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        return saxReader.read(new File(file));
    }

    public static Map<String, Class<? extends ServicesConfig>> getCONFIG() {
        return CONFIG;
    }

    public static Map<String, ExecuteCommand> getChachedCmd() {
        return CHACHED_CMD;
    }
}

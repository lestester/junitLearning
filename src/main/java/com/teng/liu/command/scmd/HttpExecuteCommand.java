package com.teng.liu.command.scmd;

import com.teng.liu.response.Responses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author teng.liu
 * @create 2017/9/18
 */

public class HttpExecuteCommand extends ExecuteCommand {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpExecuteCommand.class);

    private String url;
    private String method;
    private Object params;  //todo param的类型待封装


    public HttpExecuteCommand(String id, String desc, String url , String method) {
        super(id, desc);
        this.url = url;
        this.method = method;
    }

    @Override
    public Responses execut(Object params) {
        //todo 执行过程需要补充
        return null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}

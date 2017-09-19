package com.teng.liu.services.impl;

import com.teng.liu.command.scmd.ExecuteCommand;
import com.teng.liu.command.scmd.HttpExecuteCommand;
import com.teng.liu.services.ServicesConfig;

/**
 * @author teng.liu
 * @create 2017/9/18
 */

public class HttpServiceConfig extends ServicesConfig {

    public final static String name = "http";

    protected String url;

    protected String method;

    @Override
    public ExecuteCommand creatCommand() {
        return new HttpExecuteCommand(id,desc,url,method);
    }


}

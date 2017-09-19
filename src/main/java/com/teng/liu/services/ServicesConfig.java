package com.teng.liu.services;

import com.teng.liu.command.scmd.ExecuteCommand;

/**
 * @author teng.liu
 * @create 2017/9/18
 */

public abstract class ServicesConfig {


    protected String id;

    protected String desc;

    public abstract ExecuteCommand creatCommand();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

package com.teng.liu.command.scmd;

import com.teng.liu.response.Responses;

/**
 * @author teng.liu
 * @create 2017/9/18
 */

public abstract class ExecuteCommand {

    protected String id;
    protected String desc;

    public ExecuteCommand() {
    }

    public ExecuteCommand(String id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    //todo  传入参数 类型需要确认
    public abstract Responses execut( Object params );

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

package com.cvnchina.xingwanban.base;

/**
 * Created by hecuncun on 2019/12/15
 */
public class BaseNoDataBean {
    private String msg;
    private String msgCondition;
    private Object data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public String getMsgCondition() {
        return msgCondition;
    }

    public void setMsgCondition(String msgCondition) {
        this.msgCondition = msgCondition;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

package com.cvnchina.xingwanban.bean;

/**
 * Created by hecuncun on 2020-5-10
 */
public class MsgCountBean {

    /**
     * msg : 1
     * msgCondition : 获取成功
     * count : 12
     */

    private String msg;
    private String msgCondition;
    private int count;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

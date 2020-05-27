package com.cvnchina.xingwanban.bean;

/**
 * Created by hecuncun on 2020-5-17
 */
public class BindPhoneBean {

    /**
     * msg : 1
     * msgCondition : 获取成功
     * token : 88888****8
     */

    private String msg;
    private String msgCondition;
    private String token;

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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

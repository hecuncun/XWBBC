package com.cvnchina.xingwanban.bean;

/**
 * Created by hecuncun on 2020-5-10
 */
public class TokenBean {

    /**
     * token : sdajl2djioqweqw
     */

    private String token;
    /**
     * msg : 1
     * msgCondition : 登陆成功
     */

    private String msg;
    private String msgCondition;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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
}

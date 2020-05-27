package com.cvnchina.xingwanban.bean;

/**
 * Created by hecuncun on 2020-5-22
 */
public class ScanLoginBean {

    /**
     * msg : 1
     * msgCondition : 登录成功
     * tvToken :
     */

    private String msg;
    private String msgCondition;
    private String tvToken;

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

    public String getTvToken() {
        return tvToken;
    }

    public void setTvToken(String tvToken) {
        this.tvToken = tvToken;
    }
}

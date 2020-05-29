package com.cvnchina.xingwanban.bean;

/**
 * Created by hecuncun on 2020-5-29
 */
public class ShareBean {

    /**
     * msg : 1
     * msgCondition : 分享成功
     * url : 跳转地址
     */

    private String msg;
    private String msgCondition;
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

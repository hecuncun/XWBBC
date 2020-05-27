package com.cvnchina.xingwanban.base;

/**
 * Created by hecuncun on 2020-5-17
 */
public class OtherLoginBean {

    /**
     * msg : 1
     * msgCondition : 获取成功
     * token : *************
     * isBindPhone : 0
     */

    private String msg;
    private String msgCondition;
    private String token;
    private int isBindPhone;

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

    public int getIsBindPhone() {
        return isBindPhone;
    }

    public void setIsBindPhone(int isBindPhone) {
        this.isBindPhone = isBindPhone;
    }
}

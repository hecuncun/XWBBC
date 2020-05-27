package com.cvnchina.xingwanban.base;


import com.cvnchina.xingwanban.constants.Constant;

/**
 * Created by hecuncun on 2019/5/13
 */
public class BaseBean<T> {

    private static final String SUCCESSED_CODE= Constant.SUCCESSED_CODE;//请求成功 code=10001;

    private String msg;
    private String msgCondition;
    private T data;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 判断请求是否成功
     *
     */
    public boolean isSuccessed(){
        return SUCCESSED_CODE.equals(msg);
    }
}

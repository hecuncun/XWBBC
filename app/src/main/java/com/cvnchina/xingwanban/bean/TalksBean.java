package com.cvnchina.xingwanban.bean;

import java.util.List;

/**
 * Created by hecuncun on 2020-5-14
 */
public class TalksBean {

    /**
     * msg : 1
     * msgCondition : 获取成功
     * data : [{"name":"标签名称","hot":"参与人数"}]
     */

    private String msg;
    private String msgCondition;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : 标签名称
         * hot : 参与人数
         */

        private String name;
        private String hot;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHot() {
            return hot;
        }

        public void setHot(String hot) {
            this.hot = hot;
        }
    }
}

package com.cvnchina.xingwanban.bean;

import java.util.List;

/**
 * Created by hecuncun on 2020-5-13
 */
public class CityCodeBean {

    /**
     * msg : 1
     * msgCondition : 获取成功
     * data : [{"code":"110000","name":"北京","pcode":"0","childArea":[{"code":"110100","name":"北京市","pcode":"110000","childArea":null}]}]
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
         * code : 110000
         * name : 北京
         * pcode : 0
         * childArea : [{"code":"110100","name":"北京市","pcode":"110000","childArea":null}]
         */

        private String code;
        private String name;
        private String pcode;
        private List<ChildAreaBean> childArea;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPcode() {
            return pcode;
        }

        public void setPcode(String pcode) {
            this.pcode = pcode;
        }

        public List<ChildAreaBean> getChildArea() {
            return childArea;
        }

        public void setChildArea(List<ChildAreaBean> childArea) {
            this.childArea = childArea;
        }

        public static class ChildAreaBean {
            /**
             * code : 110100
             * name : 北京市
             * pcode : 110000
             * childArea : null
             */

            private String code;
            private String name;
            private String pcode;
            private Object childArea;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPcode() {
                return pcode;
            }

            public void setPcode(String pcode) {
                this.pcode = pcode;
            }

            public Object getChildArea() {
                return childArea;
            }

            public void setChildArea(Object childArea) {
                this.childArea = childArea;
            }
        }
    }
}

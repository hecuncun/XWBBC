package com.cvnchina.xingwanban.bean;

import java.util.List;

/**
 * Created by hecuncun on 2020-5-14
 */
public class ContentSortBean {

    /**
     * msg : 1
     * data : [{"colId":1,"colName":"短视频","children":[{"colId":271,"colName":"萌宠","children":[{"colId":272,"colName":"日常","children":[]},{"colId":273,"colName":"搞笑","children":[]}]},{"colId":274,"colName":"公益","children":[]}]}]
     * msgCondition : 获取成功
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
         * colId : 1
         * colName : 短视频
         * children : [{"colId":271,"colName":"萌宠","children":[{"colId":272,"colName":"日常","children":[]},{"colId":273,"colName":"搞笑","children":[]}]},{"colId":274,"colName":"公益","children":[]}]
         */

        private int colId;
        private String colName;
        private List<ChildrenBeanX> children;

        public int getColId() {
            return colId;
        }

        public void setColId(int colId) {
            this.colId = colId;
        }

        public String getColName() {
            return colName;
        }

        public void setColName(String colName) {
            this.colName = colName;
        }

        public List<ChildrenBeanX> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBeanX> children) {
            this.children = children;
        }

        public static class ChildrenBeanX {
            /**
             * colId : 271
             * colName : 萌宠
             * children : [{"colId":272,"colName":"日常","children":[]},{"colId":273,"colName":"搞笑","children":[]}]
             */

            private int colId;
            private String colName;
            private List<ChildrenBean> children;

            public int getColId() {
                return colId;
            }

            public void setColId(int colId) {
                this.colId = colId;
            }

            public String getColName() {
                return colName;
            }

            public void setColName(String colName) {
                this.colName = colName;
            }

            public List<ChildrenBean> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBean> children) {
                this.children = children;
            }

            public static class ChildrenBean {
                /**
                 * colId : 272
                 * colName : 日常
                 * children : []
                 */

                private int colId;
                private String colName;
                private List<?> children;

                public int getColId() {
                    return colId;
                }

                public void setColId(int colId) {
                    this.colId = colId;
                }

                public String getColName() {
                    return colName;
                }

                public void setColName(String colName) {
                    this.colName = colName;
                }

                public List<?> getChildren() {
                    return children;
                }

                public void setChildren(List<?> children) {
                    this.children = children;
                }
            }
        }
    }
}

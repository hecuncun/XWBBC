package com.cvnchina.xingwanban.bean;

import java.util.List;

/**
 * Created by hecuncun on 2020-6-2
 */
public class ReplyListBean {

    /**
     * msg : 1
     * data : {"items":[{"id":41666,"userHeadPic":null,"userNickName":"测试账号","content":"66666","createDate":"2020-06-02 10:01:55","childCommentCount":0,"childComment":null},{"id":41665,"userHeadPic":null,"userNickName":"测试账号","content":"第三天","createDate":"2020-06-02 09:57:15","childCommentCount":0,"childComment":null},{"id":41615,"userHeadPic":null,"userNickName":"测试账号","content":"厉害了","createDate":"2020-05-27 23:26:35","childCommentCount":0,"childComment":null},{"id":41614,"userHeadPic":null,"userNickName":"测试账号","content":"测试评论一下","createDate":"2020-05-27 23:13:28","childCommentCount":0,"childComment":null}],"total":4}
     * msgCondition : 获取成功
     */

    private String msg;
    private DataBean data;
    private String msgCondition;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsgCondition() {
        return msgCondition;
    }

    public void setMsgCondition(String msgCondition) {
        this.msgCondition = msgCondition;
    }

    public static class DataBean {
        /**
         * items : [{"id":41666,"userHeadPic":null,"userNickName":"测试账号","content":"66666","createDate":"2020-06-02 10:01:55","childCommentCount":0,"childComment":null},{"id":41665,"userHeadPic":null,"userNickName":"测试账号","content":"第三天","createDate":"2020-06-02 09:57:15","childCommentCount":0,"childComment":null},{"id":41615,"userHeadPic":null,"userNickName":"测试账号","content":"厉害了","createDate":"2020-05-27 23:26:35","childCommentCount":0,"childComment":null},{"id":41614,"userHeadPic":null,"userNickName":"测试账号","content":"测试评论一下","createDate":"2020-05-27 23:13:28","childCommentCount":0,"childComment":null}]
         * total : 4
         */

        private int total;
        private List<ItemsBean> items;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * id : 41666
             * userHeadPic : null
             * userNickName : 测试账号
             * content : 66666
             * createDate : 2020-06-02 10:01:55
             * childCommentCount : 0
             * childComment : null
             */

            private int id;
            private Object userHeadPic;
            private String userNickName;
            private String content;
            private String createDate;
            private int childCommentCount;
            private Object childComment;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getUserHeadPic() {
                return userHeadPic;
            }

            public void setUserHeadPic(Object userHeadPic) {
                this.userHeadPic = userHeadPic;
            }

            public String getUserNickName() {
                return userNickName;
            }

            public void setUserNickName(String userNickName) {
                this.userNickName = userNickName;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public int getChildCommentCount() {
                return childCommentCount;
            }

            public void setChildCommentCount(int childCommentCount) {
                this.childCommentCount = childCommentCount;
            }

            public Object getChildComment() {
                return childComment;
            }

            public void setChildComment(Object childComment) {
                this.childComment = childComment;
            }
        }
    }
}

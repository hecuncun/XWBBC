package com.cvnchina.xingwanban.bean;

/**
 * Created by hecuncun on 2020-6-11
 */
public class DefaultHeadPhoto {

    /**
     * headPic : {"id":1,"url":"http://www.xingwanban.com/xing//account/headImage/15915781735051257.png","path":"/account/headImage/15915781735051257.png","createTime":"2020-06-08T09:02:53","type":0,"picSize":null,"status":0,"updateTime":"2020-06-08T09:02:53"}
     */

    private HeadPicBean headPic;

    public HeadPicBean getHeadPic() {
        return headPic;
    }

    public void setHeadPic(HeadPicBean headPic) {
        this.headPic = headPic;
    }

    public static class HeadPicBean {
        /**
         * id : 1
         * url : http://www.xingwanban.com/xing//account/headImage/15915781735051257.png
         * path : /account/headImage/15915781735051257.png
         * createTime : 2020-06-08T09:02:53
         * type : 0
         * picSize : null
         * status : 0
         * updateTime : 2020-06-08T09:02:53
         */

        private int id;
        private String url;
        private String path;
        private String createTime;
        private int type;
        private Object picSize;
        private int status;
        private String updateTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public Object getPicSize() {
            return picSize;
        }

        public void setPicSize(Object picSize) {
            this.picSize = picSize;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }
}

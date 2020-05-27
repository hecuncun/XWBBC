package com.cvnchina.xingwanban.bean;

import java.util.List;

/**
 * Created by hecuncun on 2020-5-13
 */
public class MsgBean {

    /**
     * records : [{"id":4,"content":"内容不合格","type":4,"videoId":215883,"accountId":"cvna1588752974000001","fromAccountId":"0","createTime":"2020-05-08T20:09:39","isDelete":0,"status":1,"platform":0,"headPic":"","nickName":"系统通知","videoPic":"http://10.1.17.75:8018/vms//videoImage/15889092426370135.jpg"},{"id":3,"content":"审核通过","type":3,"videoId":215883,"accountId":"cvna1588752974000001","fromAccountId":"0","createTime":"2020-05-08T20:09:08","isDelete":0,"status":1,"platform":0,"headPic":"","nickName":"系统通知","videoPic":"http://10.1.17.75:8018/vms//videoImage/15889092426370135.jpg"},{"id":2,"content":"测试评论","type":2,"videoId":215883,"accountId":"cvna1588752974000001","fromAccountId":"cvna1584945702000002","createTime":"2020-05-08T20:07:58","isDelete":0,"status":1,"platform":0,"headPic":"http://10.1.17.75:8018/vms//headImage/15892877193573568.jpg","nickName":"测试账号","videoPic":"http://10.1.17.75:8018/vms//videoImage/15889092426370135.jpg"},{"id":1,"content":"","type":1,"videoId":215883,"accountId":"cvna1588752974000001","fromAccountId":"cvna1584945702000002","createTime":"2020-05-08T20:05:40","isDelete":0,"status":1,"platform":0,"headPic":"http://10.1.17.75:8018/vms//headImage/15892877193573568.jpg","nickName":"测试账号","videoPic":"http://10.1.17.75:8018/vms//videoImage/15889092426370135.jpg"}]
     * total : 4
     * size : 10
     * current : 1
     * searchCount : true
     * pages : 1
     */

    private int total;
    private int size;
    private int current;
    private boolean searchCount;
    private int pages;
    private List<RecordsBean> records;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public boolean isSearchCount() {
        return searchCount;
    }

    public void setSearchCount(boolean searchCount) {
        this.searchCount = searchCount;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<RecordsBean> getRecords() {
        return records;
    }

    public void setRecords(List<RecordsBean> records) {
        this.records = records;
    }

    public static class RecordsBean {
        /**
         * id : 4
         * content : 内容不合格
         * type : 4
         * videoId : 215883
         * accountId : cvna1588752974000001
         * fromAccountId : 0
         * createTime : 2020-05-08T20:09:39
         * isDelete : 0
         * status : 1
         * platform : 0
         * headPic :
         * nickName : 系统通知
         * videoPic : http://10.1.17.75:8018/vms//videoImage/15889092426370135.jpg
         */

        private int id;
        private String content;
        private int type;
        private int videoId;
        private String accountId;
        private String fromAccountId;
        private String createTime;
        private int isDelete;
        private int status;
        private int platform;
        private String headPic;
        private String nickName;
        private String videoPic;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getVideoId() {
            return videoId;
        }

        public void setVideoId(int videoId) {
            this.videoId = videoId;
        }

        public String getAccountId() {
            return accountId;
        }

        public void setAccountId(String accountId) {
            this.accountId = accountId;
        }

        public String getFromAccountId() {
            return fromAccountId;
        }

        public void setFromAccountId(String fromAccountId) {
            this.fromAccountId = fromAccountId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getPlatform() {
            return platform;
        }

        public void setPlatform(int platform) {
            this.platform = platform;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getVideoPic() {
            return videoPic;
        }

        public void setVideoPic(String videoPic) {
            this.videoPic = videoPic;
        }
    }
}

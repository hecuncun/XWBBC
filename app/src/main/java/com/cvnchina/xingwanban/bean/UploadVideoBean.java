package com.cvnchina.xingwanban.bean;

import java.util.List;

/**
 * Created by hecuncun on 2020-5-14
 */
public class UploadVideoBean {

    /**
     * msg : 1
     * picList : ["http://10.1.17.75:8018/vms//videoImage/15895026614762349.jpg","http://10.1.17.75:8018/vms//videoImage/15895026616720158.jpg","http://10.1.17.75:8018/vms//videoImage/15895026618000137.jpg"]
     * videoId : 215938
     * msgCondition : 上传成功
     */

    private String msg;
    private int videoId;
    private String msgCondition;
    private List<String> picList;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getMsgCondition() {
        return msgCondition;
    }

    public void setMsgCondition(String msgCondition) {
        this.msgCondition = msgCondition;
    }

    public List<String> getPicList() {
        return picList;
    }

    public void setPicList(List<String> picList) {
        this.picList = picList;
    }
}

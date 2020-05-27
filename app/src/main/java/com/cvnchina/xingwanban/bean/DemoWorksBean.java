package com.cvnchina.xingwanban.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hecuncun on 2020-5-16
 */
public class DemoWorksBean {


    /**
     * msg : 1
     * msgCondition : 获取成功
     * data : [{"contId":"视频id","contSubTitle":"视频标题","contTags":[{"tagId":"标签ID","tagName":"标签"}],"ischeck":"审核状态n：不通过；y：通过","commentnums":"评论数","haszannums":"点赞数","overimageurl":"封面图URL","showType":"1竖屏2横屏","contDownUrl":"视频链接","createtime":"上传时间","hotComment":[{"userHeadPic":"用户头像url","userNickName":"用户昵称","content":"评论内容"}]}]
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

    public static class DataBean implements Parcelable {

        /**
         * contId : 视频id
         * contSubTitle : 视频标题
         * contTags : [{"tagId":"标签ID","tagName":"标签"}]
         * ischeck : 审核状态n：不通过；y：通过
         * commentnums : 评论数
         * haszannums : 点赞数
         * overimageurl : 封面图URL
         * showType : 1竖屏2横屏
         * contDownUrl : 视频链接
         * createtime : 上传时间
         * hotComment : [{"userHeadPic":"用户头像url","userNickName":"用户昵称","content":"评论内容"}]
         */

        private String contId;
        private String contSubTitle;
        private String ischeck;
        private String commentnums;
        private String haszannums;
        private String overimageurl;
        private String showType;
        private String contDownUrl;
        private String createtime;
        private List<ContTagsBean> contTags;
        private List<HotCommentBean> hotComment;

        public String getContId() {
            return contId;
        }

        public void setContId(String contId) {
            this.contId = contId;
        }

        public String getContSubTitle() {
            return contSubTitle;
        }

        public void setContSubTitle(String contSubTitle) {
            this.contSubTitle = contSubTitle;
        }

        public String getIscheck() {
            return ischeck;
        }

        public void setIscheck(String ischeck) {
            this.ischeck = ischeck;
        }

        public String getCommentnums() {
            return commentnums;
        }

        public void setCommentnums(String commentnums) {
            this.commentnums = commentnums;
        }

        public String getHaszannums() {
            return haszannums;
        }

        public void setHaszannums(String haszannums) {
            this.haszannums = haszannums;
        }

        public String getOverimageurl() {
            return overimageurl;
        }

        public void setOverimageurl(String overimageurl) {
            this.overimageurl = overimageurl;
        }

        public String getShowType() {
            return showType;
        }

        public void setShowType(String showType) {
            this.showType = showType;
        }

        public String getContDownUrl() {
            return contDownUrl;
        }

        public void setContDownUrl(String contDownUrl) {
            this.contDownUrl = contDownUrl;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public List<ContTagsBean> getContTags() {
            return contTags;
        }

        public void setContTags(List<ContTagsBean> contTags) {
            this.contTags = contTags;
        }

        public List<HotCommentBean> getHotComment() {
            return hotComment;
        }

        public void setHotComment(List<HotCommentBean> hotComment) {
            this.hotComment = hotComment;
        }

        public static class ContTagsBean {
            /**
             * tagId : 标签ID
             * tagName : 标签
             */

            private String tagId;
            private String tagName;

            public String getTagId() {
                return tagId;
            }

            public void setTagId(String tagId) {
                this.tagId = tagId;
            }

            public String getTagName() {
                return tagName;
            }

            public void setTagName(String tagName) {
                this.tagName = tagName;
            }
        }

        public static class HotCommentBean {
            /**
             * userHeadPic : 用户头像url
             * userNickName : 用户昵称
             * content : 评论内容
             */

            private String userHeadPic;
            private String userNickName;
            private String content;

            public String getUserHeadPic() {
                return userHeadPic;
            }

            public void setUserHeadPic(String userHeadPic) {
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
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.contId);
            dest.writeString(this.contSubTitle);
            dest.writeString(this.ischeck);
            dest.writeString(this.commentnums);
            dest.writeString(this.haszannums);
            dest.writeString(this.overimageurl);
            dest.writeString(this.showType);
            dest.writeString(this.contDownUrl);
            dest.writeString(this.createtime);
            dest.writeList(this.contTags);
            dest.writeList(this.hotComment);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.contId = in.readString();
            this.contSubTitle = in.readString();
            this.ischeck = in.readString();
            this.commentnums = in.readString();
            this.haszannums = in.readString();
            this.overimageurl = in.readString();
            this.showType = in.readString();
            this.contDownUrl = in.readString();
            this.createtime = in.readString();
            this.contTags = new ArrayList<ContTagsBean>();
            in.readList(this.contTags, ContTagsBean.class.getClassLoader());
            this.hotComment = new ArrayList<HotCommentBean>();
            in.readList(this.hotComment, HotCommentBean.class.getClassLoader());
        }

        public static final Parcelable.Creator<DataBean> CREATOR = new Parcelable.Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }
}

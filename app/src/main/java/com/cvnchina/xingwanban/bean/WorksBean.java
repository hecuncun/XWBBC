package com.cvnchina.xingwanban.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hecuncun on 2020-5-14
 */
public class WorksBean implements Parcelable {


    /**
     * list : [{"contId":"视频id","contSubTitle":"视频标题","contTags":[{"tagId":"标签ID","tagName":"标签"}],"ischeck":"n","commentnums":"评论数","haszannums":"点赞数","overimageurl":"封面图URL","showType":"1竖屏2横屏","contDownUrl":"视频链接","createtime":"上传时间","hotComment":[{"userHeadPic":"用户头像url","userNickName":"用户昵称","content":"评论内容"}]}]
     * total : 100
     * pageNum : 1
     * pages : 2
     * pageSize : 10
     */

    private int total;
    private int pageNum;
    private int pages;
    private int pageSize;
    private List<ListBean> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Parcelable {

        public boolean isCanDelete() {
            return canDelete;
        }

        /**
         * contId : 视频id
         * contSubTitle : 视频标题
         * contTags : [{"tagId":"标签ID","tagName":"标签"}]
         * ischeck : n
         * commentnums : 评论数
         * haszannums : 点赞数
         * overimageurl : 封面图URL
         * showType : 1竖屏2横屏
         * contDownUrl : 视频链接
         * createtime : 上传时间
         * hotComment : [{"userHeadPic":"用户头像url","userNickName":"用户昵称","content":"评论内容"}]
         */
        public boolean canDelete=false;
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

        public static class ContTagsBean implements Parcelable {
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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.tagId);
                dest.writeString(this.tagName);
            }

            public ContTagsBean() {
            }

            protected ContTagsBean(Parcel in) {
                this.tagId = in.readString();
                this.tagName = in.readString();
            }

            public static final Creator<ContTagsBean> CREATOR = new Creator<ContTagsBean>() {
                @Override
                public ContTagsBean createFromParcel(Parcel source) {
                    return new ContTagsBean(source);
                }

                @Override
                public ContTagsBean[] newArray(int size) {
                    return new ContTagsBean[size];
                }
            };
        }

        public static class HotCommentBean implements Parcelable {

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

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.userHeadPic);
                dest.writeString(this.userNickName);
                dest.writeString(this.content);
            }

            public HotCommentBean() {
            }

            protected HotCommentBean(Parcel in) {
                this.userHeadPic = in.readString();
                this.userNickName = in.readString();
                this.content = in.readString();
            }

            public static final Creator<HotCommentBean> CREATOR = new Creator<HotCommentBean>() {
                @Override
                public HotCommentBean createFromParcel(Parcel source) {
                    return new HotCommentBean(source);
                }

                @Override
                public HotCommentBean[] newArray(int size) {
                    return new HotCommentBean[size];
                }
            };
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

        public ListBean() {
        }

        protected ListBean(Parcel in) {
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

        public static final Parcelable.Creator<ListBean> CREATOR = new Parcelable.Creator<ListBean>() {
            @Override
            public ListBean createFromParcel(Parcel source) {
                return new ListBean(source);
            }

            @Override
            public ListBean[] newArray(int size) {
                return new ListBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.total);
        dest.writeInt(this.pageNum);
        dest.writeInt(this.pages);
        dest.writeInt(this.pageSize);
        dest.writeTypedList(this.list);
    }

    public WorksBean() {
    }

    protected WorksBean(Parcel in) {
        this.total = in.readInt();
        this.pageNum = in.readInt();
        this.pages = in.readInt();
        this.pageSize = in.readInt();
        this.list = in.createTypedArrayList(ListBean.CREATOR);
    }

    public static final Parcelable.Creator<WorksBean> CREATOR = new Parcelable.Creator<WorksBean>() {
        @Override
        public WorksBean createFromParcel(Parcel source) {
            return new WorksBean(source);
        }

        @Override
        public WorksBean[] newArray(int size) {
            return new WorksBean[size];
        }
    };
}

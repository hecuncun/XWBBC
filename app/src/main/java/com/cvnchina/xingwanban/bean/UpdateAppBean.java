package com.cvnchina.xingwanban.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hecuncun on 2020-5-13
 */
public class UpdateAppBean implements Parcelable {

    /**
     * androidPic1 : http://***********init.jpg
     * androidPic2 : http://***********init.jpg
     * androidPic3 : http://***********init.jpg
     * iosPic1 : http://***********init.jpg
     * iosPic2 : http://***********init.jpg
     * iosPic3 : http://***********init.jpg
     * iosPic4 : http://***********init.jpg
     * iosPic5 : http://***********init.jpg
     * iosPic6 : http://***********init.jpg
     * appVersion : app版本（app本地存储一个版本号，如果和最新版本不一致，提醒更新，第一次获取版本不更新）
     * isForcedUpdate : 是否强制更新 0不强制1强制
     * downloadUrl : 下载链接
     * updateDesc : 更新说明
     */

    private String androidPic1;
    private String androidPic2;
    private String androidPic3;
    private String iosPic1;
    private String iosPic2;
    private String iosPic3;
    private String iosPic4;
    private String iosPic5;
    private String iosPic6;
    private String appVersion;
    private String isForcedUpdate;
    private String downloadUrl;
    private String updateDesc;

    public String getAndroidPic1() {
        return androidPic1;
    }

    public void setAndroidPic1(String androidPic1) {
        this.androidPic1 = androidPic1;
    }

    public String getAndroidPic2() {
        return androidPic2;
    }

    public void setAndroidPic2(String androidPic2) {
        this.androidPic2 = androidPic2;
    }

    public String getAndroidPic3() {
        return androidPic3;
    }

    public void setAndroidPic3(String androidPic3) {
        this.androidPic3 = androidPic3;
    }

    public String getIosPic1() {
        return iosPic1;
    }

    public void setIosPic1(String iosPic1) {
        this.iosPic1 = iosPic1;
    }

    public String getIosPic2() {
        return iosPic2;
    }

    public void setIosPic2(String iosPic2) {
        this.iosPic2 = iosPic2;
    }

    public String getIosPic3() {
        return iosPic3;
    }

    public void setIosPic3(String iosPic3) {
        this.iosPic3 = iosPic3;
    }

    public String getIosPic4() {
        return iosPic4;
    }

    public void setIosPic4(String iosPic4) {
        this.iosPic4 = iosPic4;
    }

    public String getIosPic5() {
        return iosPic5;
    }

    public void setIosPic5(String iosPic5) {
        this.iosPic5 = iosPic5;
    }

    public String getIosPic6() {
        return iosPic6;
    }

    public void setIosPic6(String iosPic6) {
        this.iosPic6 = iosPic6;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getIsForcedUpdate() {
        return isForcedUpdate;
    }

    public void setIsForcedUpdate(String isForcedUpdate) {
        this.isForcedUpdate = isForcedUpdate;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public String getUpdateDesc() {
        return updateDesc;
    }

    public void setUpdateDesc(String updateDesc) {
        this.updateDesc = updateDesc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.androidPic1);
        dest.writeString(this.androidPic2);
        dest.writeString(this.androidPic3);
        dest.writeString(this.iosPic1);
        dest.writeString(this.iosPic2);
        dest.writeString(this.iosPic3);
        dest.writeString(this.iosPic4);
        dest.writeString(this.iosPic5);
        dest.writeString(this.iosPic6);
        dest.writeString(this.appVersion);
        dest.writeString(this.isForcedUpdate);
        dest.writeString(this.downloadUrl);
        dest.writeString(this.updateDesc);
    }

    public UpdateAppBean() {
    }

    protected UpdateAppBean(Parcel in) {
        this.androidPic1 = in.readString();
        this.androidPic2 = in.readString();
        this.androidPic3 = in.readString();
        this.iosPic1 = in.readString();
        this.iosPic2 = in.readString();
        this.iosPic3 = in.readString();
        this.iosPic4 = in.readString();
        this.iosPic5 = in.readString();
        this.iosPic6 = in.readString();
        this.appVersion = in.readString();
        this.isForcedUpdate = in.readString();
        this.downloadUrl = in.readString();
        this.updateDesc = in.readString();
    }

    public static final Parcelable.Creator<UpdateAppBean> CREATOR = new Parcelable.Creator<UpdateAppBean>() {
        @Override
        public UpdateAppBean createFromParcel(Parcel source) {
            return new UpdateAppBean(source);
        }

        @Override
        public UpdateAppBean[] newArray(int size) {
            return new UpdateAppBean[size];
        }
    };
}

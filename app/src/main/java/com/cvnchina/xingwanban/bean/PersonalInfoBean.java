package com.cvnchina.xingwanban.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hecuncun on 2020-5-10
 */
public class PersonalInfoBean implements Parcelable {

    private String id;
    private String headPic;
    private String age;
    private String constellation;
    private String nickName;
    private String sex;
    private String signature;
    private String location;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.headPic);
        dest.writeString(this.age);
        dest.writeString(this.constellation);
        dest.writeString(this.nickName);
        dest.writeString(this.sex);
        dest.writeString(this.signature);
        dest.writeString(this.location);
    }

    public PersonalInfoBean() {
    }

    protected PersonalInfoBean(Parcel in) {
        this.id = in.readString();
        this.headPic = in.readString();
        this.age = in.readString();
        this.constellation = in.readString();
        this.nickName = in.readString();
        this.sex = in.readString();
        this.signature = in.readString();
        this.location = in.readString();
    }

    public static final Parcelable.Creator<PersonalInfoBean> CREATOR = new Parcelable.Creator<PersonalInfoBean>() {
        @Override
        public PersonalInfoBean createFromParcel(Parcel source) {
            return new PersonalInfoBean(source);
        }

        @Override
        public PersonalInfoBean[] newArray(int size) {
            return new PersonalInfoBean[size];
        }
    };
}

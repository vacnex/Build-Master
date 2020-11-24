package io.vacnex.buildmaster.model;

import java.io.Serializable;

public class Fan implements Serializable {
    String mName,mSize,mType,mRPM,mDB,mPWM,mRGB,mDes,mPrice;

    public Fan(String mName, String mSize, String mType, String mRPM, String mDB, String mPWM, String mRGB, String mDes, String mPrice) {
        this.mName = mName;
        this.mSize = mSize;
        this.mType = mType;
        this.mRPM = mRPM;
        this.mDB = mDB;
        this.mPWM = mPWM;
        this.mRGB = mRGB;
        this.mDes = mDes;
        this.mPrice = mPrice;
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(mName);
        str.append("\n");
        str.append(mPrice);
        str.append("\n");
        return str.toString();
    }
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSize() {
        return mSize;
    }

    public void setmSize(String mSize) {
        this.mSize = mSize;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getmRPM() {
        return mRPM;
    }

    public void setmRPM(String mRPM) {
        this.mRPM = mRPM;
    }

    public String getmDB() {
        return mDB;
    }

    public void setmDB(String mDB) {
        this.mDB = mDB;
    }

    public String getmPWM() {
        return mPWM;
    }

    public void setmPWM(String mPWM) {
        this.mPWM = mPWM;
    }

    public String getmRGB() {
        return mRGB;
    }

    public void setmRGB(String mRGB) {
        this.mRGB = mRGB;
    }

    public String getmDes() {
        return mDes;
    }

    public void setmDes(String mDes) {
        this.mDes = mDes;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }
}

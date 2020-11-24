package io.vacnex.buildmaster.model;

import java.io.Serializable;

public class Ram implements Serializable {
    String mName,mType,mSize,mBuss,mDelay,mCooling,mDes,mPrice;

    public Ram(String mName, String mType, String mSize, String mBuss, String mDelay, String mCooling, String mDes, String mPrice) {
        this.mName = mName;
        this.mType = mType;
        this.mSize = mSize;
        this.mBuss = mBuss;
        this.mDelay = mDelay;
        this.mCooling = mCooling;
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

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getmSize() {
        return mSize;
    }

    public void setmSize(String mSize) {
        this.mSize = mSize;
    }

    public String getmBuss() {
        return mBuss;
    }

    public void setmBuss(String mBuss) {
        this.mBuss = mBuss;
    }

    public String getmDelay() {
        return mDelay;
    }

    public void setmDelay(String mDelay) {
        this.mDelay = mDelay;
    }

    public String getmCooling() {
        return mCooling;
    }

    public void setmCooling(String mCooling) {
        this.mCooling = mCooling;
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

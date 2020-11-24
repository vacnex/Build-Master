package io.vacnex.buildmaster.model;

import java.io.Serializable;

public class Case implements Serializable {
    String mName,mType,mSize,mColor,mMainSP,mPort,mGlass,mFan,mExtenport,mRadSP,mDes,mPrice;

    public Case(String mName, String mType, String mSize, String mColor, String mMainSP, String mPort, String mGlass, String mFan, String mExtenport, String mRadSP, String mDes, String mPrice) {
        this.mName = mName;
        this.mType = mType;
        this.mSize = mSize;
        this.mColor = mColor;
        this.mMainSP = mMainSP;
        this.mPort = mPort;
        this.mGlass = mGlass;
        this.mFan = mFan;
        this.mExtenport = mExtenport;
        this.mRadSP = mRadSP;
        this.mDes = mDes;
        this.mPrice = mPrice;
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

    public String getmColor() {
        return mColor;
    }

    public void setmColor(String mColor) {
        this.mColor = mColor;
    }

    public String getmMainSP() {
        return mMainSP;
    }

    public void setmMainSP(String mMainSP) {
        this.mMainSP = mMainSP;
    }

    public String getmPort() {
        return mPort;
    }

    public void setmPort(String mPort) {
        this.mPort = mPort;
    }

    public String getmGlass() {
        return mGlass;
    }

    public void setmGlass(String mGlass) {
        this.mGlass = mGlass;
    }

    public String getmFan() {
        return mFan;
    }

    public void setmFan(String mFan) {
        this.mFan = mFan;
    }

    public String getmExtenport() {
        return mExtenport;
    }

    public void setmExtenport(String mExtenport) {
        this.mExtenport = mExtenport;
    }

    public String getmRadSP() {
        return mRadSP;
    }

    public void setmRadSP(String mRadSP) {
        this.mRadSP = mRadSP;
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

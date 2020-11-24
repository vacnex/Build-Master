package io.vacnex.buildmaster.model;

import java.io.Serializable;

public class HDD implements Serializable {
    String mName,mType,mRes,mSize,mWrite,mRead,mTBW,mRPM,mCache,mDes,Mprice;

    public HDD(String mName, String mType, String mRes, String mSize, String mWrite, String mRead, String mTBW, String mRPM, String mCache, String mDes, String mprice) {
        this.mName = mName;
        this.mType = mType;
        this.mRes = mRes;
        this.mSize = mSize;
        this.mWrite = mWrite;
        this.mRead = mRead;
        this.mTBW = mTBW;
        this.mRPM = mRPM;
        this.mCache = mCache;
        this.mDes = mDes;
        Mprice = mprice;
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append(mName);
        str.append("\n");
        str.append(Mprice);
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

    public String getmRes() {
        return mRes;
    }

    public void setmRes(String mRes) {
        this.mRes = mRes;
    }

    public String getmSize() {
        return mSize;
    }

    public void setmSize(String mSize) {
        this.mSize = mSize;
    }

    public String getmWrite() {
        return mWrite;
    }

    public void setmWrite(String mWrite) {
        this.mWrite = mWrite;
    }

    public String getmRead() {
        return mRead;
    }

    public void setmRead(String mRead) {
        this.mRead = mRead;
    }

    public String getmTBW() {
        return mTBW;
    }

    public void setmTBW(String mTBW) {
        this.mTBW = mTBW;
    }

    public String getmRPM() {
        return mRPM;
    }

    public void setmRPM(String mRPM) {
        this.mRPM = mRPM;
    }

    public String getmCache() {
        return mCache;
    }

    public void setmCache(String mCache) {
        this.mCache = mCache;
    }

    public String getmDes() {
        return mDes;
    }

    public void setmDes(String mDes) {
        this.mDes = mDes;
    }

    public String getMprice() {
        return Mprice;
    }

    public void setMprice(String mprice) {
        Mprice = mprice;
    }
}

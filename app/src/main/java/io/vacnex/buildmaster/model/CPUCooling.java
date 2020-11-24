package io.vacnex.buildmaster.model;

import java.io.Serializable;

public class CPUCooling implements Serializable {
    String mName,mMatBlock,mMatRad,mFanNumSize,mSocketSP,mRPM,mRadSize,mDes,mPrice;

    public CPUCooling(String mName, String mMatBlock, String mMatRad, String mFanNumSize, String mSocketSP, String mRPM, String mRadSize, String mDes, String mPrice) {
        this.mName = mName;
        this.mMatBlock = mMatBlock;
        this.mMatRad = mMatRad;
        this.mFanNumSize = mFanNumSize;
        this.mSocketSP = mSocketSP;
        this.mRPM = mRPM;
        this.mRadSize = mRadSize;
        this.mDes = mDes;
        this.mPrice = mPrice;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmMatBlock() {
        return mMatBlock;
    }

    public void setmMatBlock(String mMatBlock) {
        this.mMatBlock = mMatBlock;
    }

    public String getmMatRad() {
        return mMatRad;
    }

    public void setmMatRad(String mMatRad) {
        this.mMatRad = mMatRad;
    }

    public String getmFanNumSize() {
        return mFanNumSize;
    }

    public void setmFanNumSize(String mFanNumSize) {
        this.mFanNumSize = mFanNumSize;
    }

    public String getmSocketSP() {
        return mSocketSP;
    }

    public void setmSocketSP(String mSocketSP) {
        this.mSocketSP = mSocketSP;
    }

    public String getmRPM() {
        return mRPM;
    }

    public void setmRPM(String mRPM) {
        this.mRPM = mRPM;
    }

    public String getmRadSize() {
        return mRadSize;
    }

    public void setmRadSize(String mRadSize) {
        this.mRadSize = mRadSize;
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

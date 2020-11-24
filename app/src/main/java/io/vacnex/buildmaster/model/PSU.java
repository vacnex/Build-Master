package io.vacnex.buildmaster.model;

import java.io.Serializable;

public class PSU implements Serializable {
    String mName,mIn,mOut,mMax, mStandard,mNumSlot,mFormFactor,mDes,mPrice;

    public PSU(String mName, String mIn, String mOut, String mMax, String mStandart, String mNumSlot, String mFormFactor, String mDes, String mPrice) {
        this.mName = mName;
        this.mIn = mIn;
        this.mOut = mOut;
        this.mMax = mMax;
        this.mStandard = mStandart;
        this.mNumSlot = mNumSlot;
        this.mFormFactor = mFormFactor;
        this.mDes = mDes;
        this.mPrice = mPrice;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmIn() {
        return mIn;
    }

    public void setmIn(String mIn) {
        this.mIn = mIn;
    }

    public String getmOut() {
        return mOut;
    }

    public void setmOut(String mOut) {
        this.mOut = mOut;
    }

    public String getmMax() {
        return mMax;
    }

    public void setmMax(String mMax) {
        this.mMax = mMax;
    }

    public String getmStandard() {
        return mStandard;
    }

    public void setmStandard(String mStandard) {
        this.mStandard = mStandard;
    }

    public String getmNumSlot() {
        return mNumSlot;
    }

    public void setmNumSlot(String mNumSlot) {
        this.mNumSlot = mNumSlot;
    }

    public String getmFormFactor() {
        return mFormFactor;
    }

    public void setmFormFactor(String mFormFactor) {
        this.mFormFactor = mFormFactor;
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

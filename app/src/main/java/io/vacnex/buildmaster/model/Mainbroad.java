package io.vacnex.buildmaster.model;

import java.io.Serializable;

public class Mainbroad implements Serializable {
    String mName,mMan,mSocketm,mFormFactor,mChipset,mRamProtocol,mRamSpeed,mMaxChanelSlot,mSlots,mCrossSli,mStorage,mDes,mPrice;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmMan() {
        return mMan;
    }

    public void setmMan(String mMan) {
        this.mMan = mMan;
    }

    public String getmSocketm() {
        return mSocketm;
    }

    public void setmSocketm(String mSocketm) {
        this.mSocketm = mSocketm;
    }

    public String getmFormFactor() {
        return mFormFactor;
    }

    public void setmFormFactor(String mFormFactor) {
        this.mFormFactor = mFormFactor;
    }

    public String getmChipset() {
        return mChipset;
    }

    public void setmChipset(String mChipset) {
        this.mChipset = mChipset;
    }

    public String getmRamProtocol() {
        return mRamProtocol;
    }

    public void setmRamProtocol(String mRamProtocol) {
        this.mRamProtocol = mRamProtocol;
    }

    public String getmRamSpeed() {
        return mRamSpeed;
    }

    public void setmRamSpeed(String mRamSpeed) {
        this.mRamSpeed = mRamSpeed;
    }

    public String getmMaxChanelSlot() {
        return mMaxChanelSlot;
    }

    public void setmMaxChanelSlot(String mMaxChanel) {
        this.mMaxChanelSlot = mMaxChanel;
    }

    public String getmSlots() {
        return mSlots;
    }

    public void setmSlots(String mSlots) {
        this.mSlots = mSlots;
    }

    public String getmCrossSli() {
        return mCrossSli;
    }

    public void setmCrossSli(String mCrossSli) {
        this.mCrossSli = mCrossSli;
    }

    public String getmStorage() {
        return mStorage;
    }

    public void setmStorage(String mStorage) {
        this.mStorage = mStorage;
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

    public Mainbroad(String mName, String mMan, String mSocketm, String mFormFactor, String mChipset, String mRamProtocol, String mRamSpeed, String mMaxChanelSlot, String mSlots, String mCrossSli, String mStorage, String mDes, String mPrice) {
        this.mName = mName;
        this.mMan = mMan;
        this.mSocketm = mSocketm;
        this.mFormFactor = mFormFactor;
        this.mChipset = mChipset;
        this.mRamProtocol = mRamProtocol;
        this.mRamSpeed = mRamSpeed;
        this.mMaxChanelSlot = mMaxChanelSlot;
        this.mSlots = mSlots;
        this.mCrossSli = mCrossSli;
        this.mStorage = mStorage;
        this.mDes = mDes;
        this.mPrice = mPrice;
    }
}

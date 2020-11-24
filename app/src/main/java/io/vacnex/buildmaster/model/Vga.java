package io.vacnex.buildmaster.model;

import java.io.Serializable;

public class Vga implements Serializable {
    String mName,mArch,mCudaSP,mBase,mBoost,mVram,mVramType,mRamIntfW,mPcie,mTDP,mPowerRecom,mPortout,mDes,mPrice;
    public Vga() {}
    public Vga(String mName, String mArch, String mCudaSP, String mBase, String mBoost, String mVram, String mVramType, String mRamIntfW, String mPcie, String mTDP, String mPowerRecom, String mPortout, String mDes, String mPrice) {
        this.mName = mName;
        this.mArch = mArch;
        this.mCudaSP = mCudaSP;
        this.mBase = mBase;
        this.mBoost = mBoost;
        this.mVram = mVram;
        this.mVramType = mVramType;
        this.mRamIntfW = mRamIntfW;
        this.mPcie = mPcie;
        this.mTDP = mTDP;
        this.mPowerRecom = mPowerRecom;
        this.mPortout = mPortout;
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

    public String getmArch() {
        return mArch;
    }

    public void setmArch(String mArch) {
        this.mArch = mArch;
    }

    public String getmCudaSP() {
        return mCudaSP;
    }

    public void setmCudaSP(String mCudaSP) {
        this.mCudaSP = mCudaSP;
    }

    public String getmBase() {
        return mBase;
    }

    public void setmBase(String mBase) {
        this.mBase = mBase;
    }

    public String getmBoost() {
        return mBoost;
    }

    public void setmBoost(String mBoost) {
        this.mBoost = mBoost;
    }

    public String getmVram() {
        return mVram;
    }

    public void setmVram(String mVram) {
        this.mVram = mVram;
    }

    public String getmVramType() {
        return mVramType;
    }

    public void setmVramType(String mVramType) {
        this.mVramType = mVramType;
    }

    public String getmRamIntfW() {
        return mRamIntfW;
    }

    public void setmRamIntfW(String mRamIntfW) {
        this.mRamIntfW = mRamIntfW;
    }

    public String getmPcie() {
        return mPcie;
    }

    public void setmPcie(String mPcie) {
        this.mPcie = mPcie;
    }

    public String getmTDP() {
        return mTDP;
    }

    public void setmTDP(String mTDP) {
        this.mTDP = mTDP;
    }

    public String getmPowerRecom() {
        return mPowerRecom;
    }

    public void setmPowerRecom(String mPowerRecom) {
        this.mPowerRecom = mPowerRecom;
    }

    public String getmPortout() {
        return mPortout;
    }

    public void setmPortout(String mPortout) {
        this.mPortout = mPortout;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }

    public String getmDes() {
        return mDes;
    }

    public void setmDes(String mDes) {
        this.mDes = mDes;
    }

}



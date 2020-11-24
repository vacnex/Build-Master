package io.vacnex.buildmaster.model;

import java.io.Serializable;

public class Monitor implements Serializable {
    String mName,mPanel,mRatio,mRes,mHz,mWat,mPort,mCurved,mSoundPort,mSpeaker,mDes,mPrice;

    public Monitor(String mName, String mPanel, String mRatio, String mRes, String mHz, String mWat, String mPort, String mCurved, String mSoundPort, String mSpeaker, String mDes, String mPrice) {
        this.mName = mName;
        this.mPanel = mPanel;
        this.mRatio = mRatio;
        this.mRes = mRes;
        this.mHz = mHz;
        this.mWat = mWat;
        this.mPort = mPort;
        this.mCurved = mCurved;
        this.mSoundPort = mSoundPort;
        this.mSpeaker = mSpeaker;
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

    public String getmPanel() {
        return mPanel;
    }

    public void setmPanel(String mPanel) {
        this.mPanel = mPanel;
    }

    public String getmRatio() {
        return mRatio;
    }

    public void setmRatio(String mRatio) {
        this.mRatio = mRatio;
    }

    public String getmRes() {
        return mRes;
    }

    public void setmRes(String mRes) {
        this.mRes = mRes;
    }

    public String getmHz() {
        return mHz;
    }

    public void setmHz(String mHz) {
        this.mHz = mHz;
    }

    public String getmWat() {
        return mWat;
    }

    public void setmWat(String mWat) {
        this.mWat = mWat;
    }

    public String getmPort() {
        return mPort;
    }

    public void setmPort(String mPort) {
        this.mPort = mPort;
    }

    public String getmCurved() {
        return mCurved;
    }

    public void setmCurved(String mCurved) {
        this.mCurved = mCurved;
    }

    public String getmSoundPort() {
        return mSoundPort;
    }

    public void setmSoundPort(String mSoundPort) {
        this.mSoundPort = mSoundPort;
    }

    public String getmSpeaker() {
        return mSpeaker;
    }

    public void setmSpeaker(String mSpeaker) {
        this.mSpeaker = mSpeaker;
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

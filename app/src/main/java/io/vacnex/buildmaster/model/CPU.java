package io.vacnex.buildmaster.model;

import java.io.Serializable;

public class CPU implements Serializable {
    String mName;
    String mCodeName;
    String mLittho;
    String mNumCores;
    String mNumThreads;
    String mBaseF;
    String mTurboF;
    String mCache;
    String mTdp;
    String mMaxMem;
    String mMemType;
    String mGraphic;
    String mSocket;
    String mOtherTech;
    String mPrice;
    public CPU(){}
    public CPU(String name, String codename, String littho, String numcores, String numthreads, String basef, String turbof, String cache,String tdp,String maxmem,String memtype,String graphic,String socket,String othertech, String price){
        this.mName = name;
        this.mCodeName = codename;
        this.mLittho =littho;
        this.mNumCores =numcores;
        this.mNumThreads =numthreads;
        this.mBaseF =basef;
        this.mTurboF =turbof;
        this.mCache =cache;
        this.mTdp =tdp;
        this.mMaxMem =maxmem;
        this.mMemType =memtype;
        this.mGraphic =graphic;
        this.mSocket =socket;
        this.mOtherTech =othertech;
        this.mPrice = price;

    }
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmCodeName() {
        return mCodeName;
    }

    public void setmCodeName(String mCodeName) {
        this.mCodeName = mCodeName;
    }

    public String getmLittho() {
        return mLittho;
    }

    public void setmLittho(String mLittho) {
        this.mLittho = mLittho;
    }

    public String getmNumCores() {
        return mNumCores;
    }

    public void setmNumCores(String mNumCores) {
        this.mNumCores = mNumCores;
    }

    public String getmNumThreads() {
        return mNumThreads;
    }

    public void setmNumThreads(String mNumThreads) {
        this.mNumThreads = mNumThreads;
    }

    public String getmBaseF() {
        return mBaseF;
    }

    public void setmBaseF(String mBaseF) {
        this.mBaseF = mBaseF;
    }

    public String getmTurboF() {
        return mTurboF;
    }

    public void setmTurboF(String mTurboF) {
        this.mTurboF = mTurboF;
    }

    public String getmCache() {
        return mCache;
    }

    public void setmCache(String mCache) {
        this.mCache = mCache;
    }

    public String getmTdp() {
        return mTdp;
    }

    public void setmTdp(String mTdp) {
        this.mTdp = mTdp;
    }

    public String getmMaxMem() {
        return mMaxMem;
    }

    public void setmMaxMem(String mMaxMem) {
        this.mMaxMem = mMaxMem;
    }

    public String getmMemType() {
        return mMemType;
    }

    public void setmMemType(String mMemType) {
        this.mMemType = mMemType;
    }

    public String getmGraphic() {
        return mGraphic;
    }

    public void setmGraphic(String mGraphic) {
        this.mGraphic = mGraphic;
    }

    public String getmSocket() {
        return mSocket;
    }

    public void setmSocket(String mSocket) {
        this.mSocket = mSocket;
    }

    public String getmOtherTech() {
        return mOtherTech;
    }

    public void setmOtherTech(String mOtherTech) {
        this.mOtherTech = mOtherTech;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }


}

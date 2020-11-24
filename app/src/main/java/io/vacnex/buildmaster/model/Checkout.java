package io.vacnex.buildmaster.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Checkout implements Serializable {
    List<CPU> mCpu;
    List<Vga> mVga;
    List<Mainbroad> mMainbroad;
    List<Ram> mRam;
    List<SSD> mSsd;
    List<HDD> mHdd;
    List<PSU> mPsu;
    List<CPUCooling> mCpuCool;
    List<Case> mCase;
    List<Fan> mFan;
    List<Monitor> mMonitor;

    public Checkout(List<CPU> mCpu, List<Vga> mVga, List<Mainbroad> mMainbroad, List<Ram> mRam, List<SSD> mSsd, List<HDD> mHdd, List<PSU> mPsu, List<CPUCooling> mCpuCool, List<Case> mCase, List<Fan> mFan, List<Monitor> mMonitor) {
        this.mCpu = mCpu;
        this.mVga = mVga;
        this.mMainbroad = mMainbroad;
        this.mRam = mRam;
        this.mSsd = mSsd;
        this.mHdd = mHdd;
        this.mPsu = mPsu;
        this.mCpuCool = mCpuCool;
        this.mCase = mCase;
        this.mFan = mFan;
        this.mMonitor = mMonitor;
    }

    public List<CPU> getmCpu() {
        return mCpu;
    }

    public void setmCpu(List<CPU> mCpu) {
        this.mCpu = mCpu;
    }

    public List<Vga> getmVga() {
        return mVga;
    }

    public void setmVga(List<Vga> mVga) {
        this.mVga = mVga;
    }

    public List<Mainbroad> getmMainbroad() {
        return mMainbroad;
    }

    public void setmMainbroad(List<Mainbroad> mMainbroad) {
        this.mMainbroad = mMainbroad;
    }

    public List<Ram> getmRam() {
        return mRam;
    }

    public void setmRam(List<Ram> mRam) {
        this.mRam = mRam;
    }

    public List<SSD> getmSsd() {
        return mSsd;
    }

    public void setmSsd(List<SSD> mSsd) {
        this.mSsd = mSsd;
    }

    public List<HDD> getmHdd() {
        return mHdd;
    }

    public void setmHdd(List<HDD> mHdd) {
        this.mHdd = mHdd;
    }

    public List<PSU> getmPsu() {
        return mPsu;
    }

    public void setmPsu(List<PSU> mPsu) {
        this.mPsu = mPsu;
    }

    public List<CPUCooling> getmCpuCool() {
        return mCpuCool;
    }

    public void setmCpuCool(List<CPUCooling> mCpuCool) {
        this.mCpuCool = mCpuCool;
    }

    public List<Case> getmCase() {
        return mCase;
    }

    public void setmCase(List<Case> mCase) {
        this.mCase = mCase;
    }

    public List<Fan> getmFan() {
        return mFan;
    }

    public void setmFan(List<Fan> mFan) {
        this.mFan = mFan;
    }

    public List<Monitor> getmMonitor() {
        return mMonitor;
    }

    public void setmMonitor(List<Monitor> mMonitor) {
        this.mMonitor = mMonitor;
    }
}
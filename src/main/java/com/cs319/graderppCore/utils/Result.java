package com.cs319.graderppCore.utils;

import java.util.ArrayList;

/**
 * Created by reink on 12/8/15.
 */
public class Result {
    private boolean compileSuccess;
    private String  compileLog;
    private int[] grade_log;
    private int[] memory;
    private int[] time;

    public Result() {
    }

    public boolean isCompileSuccess() {
        return compileSuccess;
    }

    public void setCompileSuccess(boolean compileSuccess) {
        this.compileSuccess = compileSuccess;
    }

    public String getCompileLog() {
        return compileLog;
    }

    public void setCompileLog(String compileLog) {
        this.compileLog = compileLog;
    }

    public int[] getGrade_log() {
        return grade_log;
    }

    public void setGrade_log(int[] grade_log) {
        this.grade_log = grade_log;
    }

    public int[] getMemory() {
        return memory;
    }

    public void setMemory(int[] memory) {
        this.memory = memory;
    }

    public int[] getTime() {
        return time;
    }

    public void setTime(int[] time) {
        this.time = time;
    }
}

package com.cs319.graderppCore.utils;

/**
 * Created by reink on 12/8/15.
 */
public class IsolateOptions {
    private int memorySize;
    private double timeLimit;
    private int processNum;
    private int stackSize;

    public IsolateOptions(int memorySize, double timeLimit, int processNum, int stackSize) {
        this.memorySize = memorySize;
        this.timeLimit = timeLimit;
        this.processNum = processNum;

        this.stackSize = stackSize;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public double getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(double timeLimit) {
        this.timeLimit = timeLimit;
    }

    public int getProcessNum() {
        return processNum;
    }

    public void setProcessNum(int processNum) {
        this.processNum = processNum;
    }

    public int getStackSize() {
        return stackSize;
    }

    public void setStackSize(int stackSize) {
        this.stackSize = stackSize;
    }

    public String toPythonArgs() {
        return " ";
    }
}

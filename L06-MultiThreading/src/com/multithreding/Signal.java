package com.multithreding;

public class Signal {
    //private volatile boolean stop;
    private boolean stop;

    public synchronized   boolean  isStop() {
        return stop;
    }

    public synchronized void setStop(boolean stop) {
        this.stop = stop;
    }
}

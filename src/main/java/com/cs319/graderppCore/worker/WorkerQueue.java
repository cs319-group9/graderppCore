package com.cs319.graderppCore.worker;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Lock;

/**
 * Created by reink on 12/8/15.
 */
public class WorkerQueue implements Runnable{
    public static final String THREAD_NAME = "WORKER_QUEUE";
    private Queue<Worker> workers;
    private Lock lock;

    private static WorkerQueue instance = null;

    public static WorkerQueue getInstance() {
        if(instance == null) {
            instance = new WorkerQueue();
            Thread t = new Thread(instance, THREAD_NAME);
            t.start();
        }
        return instance;
    }

    private WorkerQueue() {
        workers = new LinkedList<Worker>();
    }

    public void AddWorker(String submissionID, String taskID) {
        Worker w = new Worker(submissionID, taskID);
        lock.lock();
        workers.add(w);
        lock.unlock();
    }

    @Override
    public void run() {
        while(true) {
            if(!workers.isEmpty()) {
                lock.lock();
                Worker w = workers.remove();
                lock.unlock();
                w.run();
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

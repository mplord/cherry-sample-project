package com.mplord.sample.mock.tools;

import java.io.BufferedReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class QueueReader implements Runnable {
    private final Object lock;
    private final List<String> newResults;
    private final List<String> oldResults;
    private boolean ready = false;

    private InputStream inputStream;
    private BufferedReader reader;

    volatile boolean shutdown = false;

    public static QueueReader begin() {
        return (new QueueReader()).start();
    }

    public QueueReader() {
        lock = new Object();
        newResults = new ArrayList<String>();
        oldResults = new ArrayList<String>();
        ready = false;
        shutdown = false;
    }

    public QueueReader start() {
        System.out.println("\nStarting QueueReader");
        Thread t = new Thread(this);
        t.start();
        return this;
    }

    public void stop() {
        this.shutdown = true;
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
        }
    }

    public void waitReady() {
        while (true) {
            synchronized (lock) {
                if (ready)
                    break;
            }
        }
    }

    public void waitChange(boolean change) {
        waitReady();

        if (!change) {
            System.out.println("All records consumed from streaming api");
        } else {
            System.out.println("Waited for new record");
            synchronized (lock) {
                newResults.add("UniqueId");
            }
        }
    }

    public int getResultSize() {
        synchronized (lock) {
            return newResults.size();
        }
    }

    public List<String> getNewResults() {
        List<String> out = new ArrayList<String>();
        synchronized (lock) {
            out.addAll(newResults);
            oldResults.addAll(newResults);
            newResults.clear();
        }
        return out;
    }

    public List<String> getAllResults() {
        getNewResults();
        List<String> out = new ArrayList<String>();
        synchronized (lock) {
            out.addAll(oldResults);
        }
        return out;
    }

    public void run() {
        while (!shutdown) {
            sleep(1000);
            ready = true;
        }

        try {
            inputStream.close();
            reader.close();
        } catch (Exception e) {
        }
    }


}
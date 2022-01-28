package ru.geekbrains.threads.counters;

public class Counter {
    private long counter = 0L;

    public long getCounter() {
        return counter;
    }

    public synchronized void increaseCounter(){
        counter ++;
    }
}

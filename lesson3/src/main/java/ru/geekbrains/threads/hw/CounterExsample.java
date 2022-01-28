package ru.geekbrains.threads.hw;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterExsample {
    private int count;
    Lock lock = new ReentrantLock();

    public int getCount() {
        return count;
    }

    void increase(){
        lock.lock();
        count ++;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        CounterExsample counter = new CounterExsample();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> counter.increase()).start();
        }
        Thread.sleep(1000);
        System.out.println("Counter is " + counter.getCount());
    }
}

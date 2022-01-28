package ru.geekbrains.threads.counters;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    AtomicInteger counter;

    public AtomicCounter() {
        this.counter = new AtomicInteger();
    }

    void   increase(){
        counter.incrementAndGet();
    }
}

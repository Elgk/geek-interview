package ru.geekbrains.threads.counters;

public class AtomicTester {
    public static void main(String[] args) throws InterruptedException {
        AtomicCounter count = new AtomicCounter();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> count.increase()).start();
        }

        Thread.sleep(2000);
        System.out.println("Counter is " + count.counter.get());
    }
}

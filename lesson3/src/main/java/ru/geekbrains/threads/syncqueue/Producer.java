package ru.geekbrains.threads.syncqueue;


public class Producer implements Runnable{
    private SyncQueue sq;

    public Producer(SyncQueue sq) {
        this.sq = sq;
        new Thread(() -> run()).start();
    }

    public void run(){
        for (int i = 1; i < 5; i++) {
            sq.put(i);
        }
    }
}

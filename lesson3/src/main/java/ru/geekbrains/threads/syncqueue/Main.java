package ru.geekbrains.threads.syncqueue;

public class Main {
    public static void main(String[] args) {
        SyncQueue sq = new SyncQueue();
        new Producer(sq);
        new Consumer(sq);
    }
}

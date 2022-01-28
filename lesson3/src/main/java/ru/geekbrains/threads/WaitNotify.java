package ru.geekbrains.threads;

public class WaitNotify {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();

        new Thread(() -> {
            System.out.println("Start thread " + Thread.currentThread().getName());
            synchronized (o){
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Waiting is over in " + Thread.currentThread().getName());
            }
        }).start();

        Thread thr2 = new Thread(() -> {
            System.out.println("Start thread " + Thread.currentThread().getName());
            synchronized (o){
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Waiting is over in " + Thread.currentThread().getName());
            }
        });
        thr2.setDaemon(true);
        thr2.start();

        Thread thr3 = new Thread(() -> {
            System.out.println("Start thread " + Thread.currentThread().getName());
            synchronized (o){
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Waiting is over in " + Thread.currentThread().getName());
            }
        });
        thr3.setDaemon(true);
        thr3.start();

        Thread.sleep(3000);
        synchronized (o){
            o.notify(); // разбудит только какой-нибудь один поток, остальные повиснут
            //   o.notifyAll();// или установкой остальных как демон-потоков
        }
        System.out.println("Main thread is over");
    }
}

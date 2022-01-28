package ru.geekbrains.threads.syncqueue;

public class SyncQueue {
    int n;
    boolean flag;

  /*  public SyncQueue() {
        this.n = 0;
        this.flag = false;
    }*/

     synchronized int get(){
        while (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Object " + n + " is recieved");
        flag = false;
        this.notifyAll();
        return n;
    }

     synchronized void put(int n){
        while (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.n = n;
        System.out.println("Object " + n + " is delievered");
        flag = true;
        this.notifyAll();
    }
}

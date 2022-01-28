package ru.geekbrains.threads.hw;

public class PingPongExample {
    private  String data = "";

    public synchronized void putPing(){
        for (int i = 0; i < 4; i++) {
            while (data.equals("ping")){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data = "ping";
            System.out.println(data);
            this.notifyAll();
        }

    }

    public synchronized void putPong(){
        for (int i = 0; i < 4; i++) {
            while (data.equals("pong")){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            data = "pong";
            System.out.println(data);
            this.notifyAll();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        PingPongExample pp = new PingPongExample();

        Thread thr1 = new Thread(() -> pp.putPing());
        Thread thr2 = new Thread(() -> pp.putPong());
        thr1.start();
        thr2.start();
    }

}

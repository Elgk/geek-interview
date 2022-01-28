package ru.geekbrains.threads.linkedqueue;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueExample {
    private Queue<String> queue; // = null;

    private volatile boolean cycle = true;

    public ConcurrentLinkedQueueExample() {
        this.queue = new ConcurrentLinkedQueue<>(); //<String>();
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());
        producer.start();
        consumer.start();

        while (consumer.isAlive()){ // поток еще действует
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.exit(0);
    }

    class Producer implements  Runnable{
        @Override
        public void run(){
            System.out.println("Producer started");
            try {
                for (int i = 0; i < 10; i++) {
                    String str = "String " + i;
                    queue.add(str);
                    System.out.println("Producer added " + str);
                    Thread.sleep(200);
                }
                cycle = false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Consumer implements Runnable{
        @Override
        public void run() {
            System.out.println("Consumer started");
            String str;
            // cycle = false, - сигнал что больше добавлений в список не будет
            while (cycle || queue.size() > 0){
                if ((str = queue.poll()) != null){
                    System.out.println("Consumer removed " + str);
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new ConcurrentLinkedQueueExample();
    }
}

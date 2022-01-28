package ru.geekbrains.threads;

public class Main {
/*
    public synchronized void synced1(){
        // объект синхронизации - экземпляр класса Main - this
    }

    public static synchronized void  synced2(){
        // объект синхронизации -  класс Main
        // тоже самое объявление
//        synchronized (Main.class){
//
//        }
    }

*/
    public static void main(String[] args) {
        Object sync = new Object();
        /*
        явная синхронизация по монитору объекта sync
        метод synchronized (sync) может выполняться только одним потоком в одно и то же временя
         */
        new Thread(() ->{
            System.out.println("Starting inner thread");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (sync){
                System.out.println("I am inner thread");
            }
        }).start();

        synchronized (sync){
            System.out.println("Starting main thread");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am main thread");
        }
    }
}

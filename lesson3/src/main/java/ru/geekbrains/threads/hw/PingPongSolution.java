package ru.geekbrains.threads.hw;

public class PingPongSolution implements Runnable{
    private static String status = "ping"; // общее поле на весь класс
    private final String word;

    public PingPongSolution(String word) {
        this.word = word;
    }

    @Override
    public void run() {
        while (!Thread.interrupted()){
            synchronized (PingPongSolution.class){
                while (word.equals(status)){
                    try {
                        PingPongSolution.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                System.out.println(word);
                status = word;
                try {
                    Thread.sleep(1000);
                    PingPongSolution.class.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new PingPongSolution("ping")).start();
        new Thread(new PingPongSolution("pong")).start();
    }
}

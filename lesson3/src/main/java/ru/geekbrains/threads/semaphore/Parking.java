package ru.geekbrains.threads.semaphore;

import java.util.concurrent.Semaphore;

public class Parking {
    //Парковочное место занято - true, свободно - false
    private static final boolean[] PARKING_PLACES = new boolean[5];
    //Устанавливаем флаг "справедливый", в таком случае метод
    //aсquire() будет раздавать разрешения в порядке очереди
    private static final Semaphore SEMAPHORE = new Semaphore(5, true);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 1; i < 8; i++) {
            new Thread( new Car(i)).start();
            Thread.sleep(400);
        }
    }

    private static class Car implements Runnable{
        private int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            System.out.println("The car number " + carNumber + " arrived for parking");
            try {
                //acquire() запрашивает доступ к следующему за вызовом этого метода блоку кода,
                //если доступ не разрешен, поток вызвавший этот метод блокируется до тех пор,
                //пока семафор не разрешит доступ
                SEMAPHORE.acquire();
                int parkingNumber = -1;
                synchronized (PARKING_PLACES){
                    for (int i = 0; i < 5; i++) {
                        if (!PARKING_PLACES[i]){
                            PARKING_PLACES[i] = true;
                            parkingNumber = i;
                            System.out.printf("the car number %d  is on the place number %d", carNumber, parkingNumber);
                            break;
                        }
                    }
                }
                Thread.sleep(5000); // иммитация нахождения на стоянке
                synchronized (PARKING_PLACES){
                    PARKING_PLACES[parkingNumber] = false;//Освобождаем место
                }
                SEMAPHORE.release();//release(), освобождает ресурс
                System.out.println("the car number " + carNumber + " has gone");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

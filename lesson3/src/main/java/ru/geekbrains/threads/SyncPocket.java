package ru.geekbrains.threads;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SyncPocket {
    private String data;

    public synchronized void put(String data) {
        while (this.data != null || Thread.interrupted()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.data = data;
        this.notifyAll();
    }

    public synchronized String get() {
        while (this.data == null || Thread.interrupted()){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String dataTmp = data;
        this.data = null;
        this.notifyAll();
        return dataTmp;
    }

    public static void main(String[] args) throws InterruptedException {
        SyncPocket sp = new SyncPocket();

        new Thread(() ->  System.out.println(sp.get()) ).start();
        new Thread(() ->  System.out.println(sp.get()) ).start();
        new Thread(() ->  System.out.println(sp.get()) ).start();

        Thread.sleep(1000);

        sp.put("First");
        sp.put("Second");
        sp.put("Third");

        // иногда бывают ситуации, когда монитора и synchronized методов недостаточно
        // существует интерфейс Lock для явных блокировок
        // параметр fair - справедливых true или нет false (это по умолчанию) блокировок
        // если true, то доступ получит тот поток. который дольше всех ждет
     /*   Lock lock = new ReentrantLock(true);
        lock.lock();
        //  необходимые действия
        //
        lock.unlock();
*/
        // другая разновидность явной блокировки
     /*  ReadWriteLock lock1 = new ReentrantReadWriteLock();
        lock1.readLock(); // блокировка на чтение
        lock1.writeLock(); // блокировка на запись*/

        //сихронизированные коллекции,
        // не рекомендуется применять, влияют на производительность, блокируют объект целиком, частые deadlock
        //Map<Integer, String> map = new Collections.synchronizedMap(new HashMap<>());

        // блокируется только определенные backet(ы) мапы, т.е. те которые, изменяются разными потоками, deadlock(ов) меньше
        //  Map<Integer, String> map1 = new ConcurrentHashMap<>();

        //для списков
      //  List<String> list = new CopyOnWriteArrayList<>(); // из минусов - потребляет много памяти
    }
}

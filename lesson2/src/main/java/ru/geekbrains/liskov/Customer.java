package ru.geekbrains.liskov;

public class Customer {
    protected int account;

    public void putMoney(int value){
        if (value < 1){
            throw new IllegalArgumentException("Нельзя положить менее 1");
        }
        account += value;
    }
}

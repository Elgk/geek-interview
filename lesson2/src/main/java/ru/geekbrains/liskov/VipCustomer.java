package ru.geekbrains.liskov;

public class VipCustomer extends Customer{
// полностью заместили метод род. класса
    @Override
    public void putMoney(int value) {
        account += value * 1.1;
    }
}

package ru.geekbrains.liskov;

public class MicroCustomer extends Customer{
    // усилили условие родительского класса
    @Override
    public void putMoney(int value) {
        if (value > 100){
            throw new IllegalArgumentException("нельзя положить больше, чем 100");
        }
        super.putMoney(value);
    }
}

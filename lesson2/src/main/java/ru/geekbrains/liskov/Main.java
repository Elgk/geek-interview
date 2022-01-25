package ru.geekbrains.liskov;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer());
        customers.add(new Customer());
        customers.add(new MicroCustomer());
        customers.add(new VipCustomer());

      /*   нарушение SOLID принципа подстановки Барборы Лисков
        дочернй класс переопределяет метод и расширяет предусловие родительского класса
        или полностью его переопределяет
        нарушается совместимость версий

        исправление - логику валидации вывести из метода putMoney в отдельный метод
        или делать класс, метод final
        */
        for (Customer customer : customers) {
            customer.putMoney(150);
        }

    }
}

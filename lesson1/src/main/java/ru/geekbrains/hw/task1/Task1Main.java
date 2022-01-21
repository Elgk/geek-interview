package ru.geekbrains.hw.task1;

public class Task1Main {
    public static void main(String[] args) {
        Person person = new Person.Builder().firstName("John").lastName("Isner").gender("man").age(26).country("USA").build();
        System.out.println(person.toString());
    }
}

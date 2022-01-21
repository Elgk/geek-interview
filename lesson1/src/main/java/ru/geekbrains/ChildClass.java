package ru.geekbrains;

public class ChildClass extends AbstractClass{

    @Override
    public void method() {
        System.out.println("переопределяемый метод");
    }

    @Override
    public void run() {
        System.out.println("реализуемый метод");
    }
}

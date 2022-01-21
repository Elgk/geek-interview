package ru.geekbrains.hw.task2;

 class LightWeightCar extends Car {
// объявление интерфейса Moveable может быть перенесено в родительский класс, т.к. используется во всех наследниках

    @Override
    public void open() { // без модификатора, т.е. с default метод доступег только внутри данного пакета
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}

package ru.geekbrains.hw.task2;

 class Lorry extends Car implements  Stopable{
     // множественное наследование недопускается, для интерфейсов указывается implements
     // объявление интерфейса Moveable может быть перенесено в родительский класс, т.к. используется во всех наследниках
    public void move(){
        System.out.println("Car is moving");
    }
    public void stop(){
        System.out.println("Car is stop");
    }
    //необходимо определить метод родительского класса
     @Override
     public void open() {
         System.out.println("car is open");
     }
 }


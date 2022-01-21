package ru.geekbrains.hw.task3;

public class Task3Main {
    public static void main(String[] args) {

        Figure[] figures = {new Circle(5),
                            new Square(255),
                            new Triangle(32, 15)
                            };
        System.out.println("Площадь фигур:");
        for (Figure figure : figures) {
            figure.areaCalculete();
            System.out.println(figure);
        }
    }
}

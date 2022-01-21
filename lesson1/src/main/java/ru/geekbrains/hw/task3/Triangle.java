package ru.geekbrains.hw.task3;

public class Triangle extends Figure{
    private int base;
    private int height;

    public Triangle(int base, int height) {
        super("треугольник");
        this.base = base;
        this.height = height;
    }

    @Override
    public double areaCalculete() {
        figureSquare = base * height / 2;
        return figureSquare;
    }


}

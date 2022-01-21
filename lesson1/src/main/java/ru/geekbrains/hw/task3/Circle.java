package ru.geekbrains.hw.task3;

public class Circle extends Figure{
    private int radius;

    public Circle(int radius){
        super("круг");
        this.radius = radius;
    }

    @Override
    public double areaCalculete() {
        figureSquare = 3.14f * radius * radius;
        return figureSquare;
    }


}

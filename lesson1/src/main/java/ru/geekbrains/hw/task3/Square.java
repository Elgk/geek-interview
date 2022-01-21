package ru.geekbrains.hw.task3;

public class Square extends Figure{
    private int side;

    public Square(int side) {
        super("квадрат");
        this.side = side;
    }

    @Override
    public double areaCalculete() {
        figureSquare = side * side;
        return figureSquare;
    }


}

package ru.geekbrains.hw.task3;

public abstract class Figure  {
    protected double figureSquare;
    protected String name;

    public Figure(String name) {
        this.name = name;
    }

    public abstract double areaCalculete();

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": ").append(figureSquare);
        return sb.toString();
    }
}

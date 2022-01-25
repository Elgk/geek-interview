package ru.geekbrains.hw.task3;

public abstract class Figure  {
    protected double figureSquare;
    protected String name;

    public Figure(String name) {
        this.name = name;
    }

    public abstract double areaCalculete();

    public String toString() {
        // для простых конструкций StringBuilder применять не рекомендуется
//        StringBuilder sb = new StringBuilder();
//        sb.append(name).append(": ").append(figureSquare);
//        sb.toString();
        return name + ": " + figureSquare;
    }
}

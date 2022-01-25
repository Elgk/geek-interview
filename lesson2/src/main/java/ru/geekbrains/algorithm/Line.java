package ru.geekbrains.algorithm;

import java.util.Objects;

public class Line {
    private int x;
    private int y;

    public Line(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return x == line.x && y == line.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

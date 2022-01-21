package ru.geekbrains.hw.task2;

public abstract class Car implements Moveable{
    // если задача требует обязательной реализации интерфейса всеми наследниками, то лучше объявить его в родительском классе
    protected Engine engine; // поле должно быть доступно только через геттеры и сеттеры
    protected String name; // поле должно быть доступно наследникам
    protected String color;

    public void start(){
        System.out.println("car starting");
    }
    public abstract void open();

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

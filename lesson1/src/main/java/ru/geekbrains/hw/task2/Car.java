package ru.geekbrains.hw.task2;

 abstract class Car {

    public Engine engine;
    private String name;
    private String color;

    protected void start(){
        System.out.println("car starting");
    }
    abstract void open();

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

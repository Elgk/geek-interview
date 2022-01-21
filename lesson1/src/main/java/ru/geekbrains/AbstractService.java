package ru.geekbrains;

public abstract class AbstractService {
//  здесь абстрактный класс является контейнером, скрывающим свою реализацию через внутренние классы
    public static AbstractService createServiceOne(){
        return new ServiceOne();
    }

    public static AbstractService createServiceTwo(){
        return new ServiceTwo();
    }


    private static  class  ServiceOne extends AbstractService{

    }

    private static  class  ServiceTwo extends AbstractService{

    }
}

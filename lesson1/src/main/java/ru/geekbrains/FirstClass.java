package ru.geekbrains;

public class FirstClass {
    private String str;


    // полиморфизм
    // 1 - перекрытие методов
    public void method(){
        str = "Hello";
    }

    public void method(String str){
        this.str = str;
    }

    public void method(String str1, String str2){
        str = str1 + str2;
    }
    /*
 нельзя объявивить, т.к. разный возвращаемый тип
    public String method(){
        return "111";
    }
 2 - обобщенные типы - дженерики
 использование параметров для класса  - <T>

 // абстрактный класс описывает сущность. интерфейс - действие
    класс может наследовать только один класс, а интерфесов реализовывать- много
    нельзя создать экземпляр абстрактного класса

    переопределяемые методы:
    нельзя при ключевом слове - final

    static
    статические методы можно перекрывать (overload), но нельзя переопределять, т.к. они принадлежат к классу, а не к экземпляру

    виртуальные методы - те, которые можно переопределить, т.е. кроме статических и с ключевым словом final

    ИНКАПСУЛЯЦИЯ
    модификаторы доступа: public, protected, package private, private
    еще один уровень никапсуляции - внутренние классы

*/
}

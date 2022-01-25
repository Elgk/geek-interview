package ru.geekbrains.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        /*
        при переопределении метода  сравнения двух объектов equals должны быть выполнены след. условия
        a.equals(a) => true
        a.equals(b) => b.equals(a)  симметричность
        a.equals(b) && b.equals(c) => a.equals(c) транзитивность

        1. Если объекты одинаковые, хеш-коды у них равны;
        2. Если хеш-коды равны, объекты не всегда одинаковые;
        3. Если хеш-коды разные, объекты различны
         */

        // пример реализации для класса интерфейса Iterable<> для использования конструкции foreach
        for (int num: new IterableExsample.RandomIterable(10)){
            System.out.println(num);
        }

        //примеры инициализации массивов через литералы
        int[] arr = {1,2,3,4};

        List<Integer> list = List.of(1,2,3,4,5,6); // неизменяемый массив

        // преобразование в изменяемый массив
        List<Integer> integerList = new ArrayList<>(List.of(1,5,8,3));

        // тоже для множества

        Set<Integer> set = Set.of(2,4,6,8);
        Set<Integer> integerSet = new HashSet<>(Set.of(2,4,6,8));

        // сравнивание объектов
        // два интерфейса Comparable и Comparator, в последнем надо самостоятельно прописать сравнение экземпляров объектов


    /*
        конструкция Map - словарь, ключ - значение

        конструкцияя TreeMap - эффективность зависит от порядка добавления элементов, может выродиться в односвязный список
        пример, бинарное дерево, интерфейс красно-черного дерева - с конкретным способом балансировки для равномерного распределения элементов
        таким, что высота дерева равна логарифму от N, где N - кол-во элементов в дереве
        конкретная балансировка
     */
    }
}

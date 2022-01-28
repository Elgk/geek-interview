package ru.geekbrains.hw;

public class Main {
    public static void main(String[] args) {

        System.out.println("*** Task 1 *******");
        MyLinkedList<Integer> list = new MyLinkedList<>();
        System.out.println(list);
        list.addFirst(30);
        list.addLast(70);
        list.addLast(20);
        list.add(100);
//        System.out.println(list);
//        list.remove(100);
//        System.out.println(list);
//        list.remove(20);
//        list.add(100);
//        list.add(1, 200);
//        System.out.println(list);
//        list.set(1, 34);
//        System.out.println(list);
//        list.addFirst(50);
//        System.out.println(list);
//        list.removeLast();
//        System.out.println(list);
//        list.remove(200);
        System.out.println(list);

/*
        System.out.println("*** Task 2 *******");

        MyArraylist<Integer> intList = new MyArraylist<>();
        intList.add(100);
        intList.add(50);
        intList.add(101);
        if (!intList.isEmpty()){
            System.out.println(intList);
        }

        System.out.println(intList.get(1));
        System.out.println(intList.size());
        if (intList.remove(99)){
            System.out.println(intList);
        }

        MyArraylist<Integer> intlist2 = new MyArraylist<>();
        for (int i = 0; i < 16; i++) {
            intlist2.add(i);
        }
        System.out.println(intlist2);
*/

   /*     MyArraylist<String> strList = new MyArraylist<>();
        strList.add("aa");
        strList.add("bb");
        strList.add("cc");
        System.out.println(strList);
        System.out.println(strList.get(1));
        System.out.println(strList.size());
        strList.remove("bb");
        System.out.println(strList);*/


    }
}

package ru.geekbrains.hw;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArraylist<T> {
    private int count;
    private T[] arr;

    private final int DEFAULT_CAPACITY = 10;

    public MyArraylist(int capaciity) {
        if (capaciity < 0){
            throw new IllegalArgumentException("Размер массива не может быть отрицательным");
        }
        this.arr = (T[]) new Object[capaciity];
    }

    public MyArraylist() {
        this.arr = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public int size(){
        return count;
    }

    public T get(int index){
        if (index > count || index < 0){
            throw  new IllegalArgumentException("Неверный индекс");
        }
        return arr[index];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public void add(T value){
        if (arr.length < (count + 1)){
            int newLength = count + count / 2 + 1;
            T[] newArr = Arrays.copyOf(arr, newLength);
            arr = newArr;
        }
        arr[count] = value;
        count ++;
    }

    public boolean remove(T value){
        if (isEmpty()){
          return  false;
        }
        for (int i = 0; i < count; i++) {
            if (arr[i].equals(value)){
                for (int j = i; j <= count; j++) {
                    arr[j] = arr[j+1];
                }
                arr[count] = null;
                count --;
                return true;
            }
        }
        return false;

    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(arr, count));
    }
}

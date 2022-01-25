package ru.geekbrains.hw;


import java.util.NoSuchElementException;

public class MyLinkedList<E>  {

    private class Node{
        private Node prev;
        private Node next;
        private E value;

        public Node(E value, Node next) {
            this.next = next;
            this.value = value;
        }

        public Node(E value, Node prev, Node next ) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }

        public Node getPrev() {
            return prev;
        }
        public Node getNext() {
            return next;
        }
        public E getValue() {
            return value;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public void setValue(E value) {
            this.value = value;
        }
    }

    private Node firstNode;
    private Node lastNode;
    private int count;


    public MyLinkedList(){
    }

    public int size() {
        return count;
    }

    public boolean isEmpty(){
        return firstNode == null;
    }

    public E get(int index) {
        if (index < 0 || index > count){
            throw  new IllegalArgumentException("Неверный индекс");
        }
        Node current = firstNode;
        for (int i = 0; i < index-1; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public  void addFirst(E item){
        Node newNode = new Node(item, firstNode);
        if (isEmpty()){
            lastNode = newNode;
        }else {
            firstNode.setPrev(newNode);
        }
        firstNode = newNode;
        count ++;
    }

    public void addLast(E item){
        Node newNode = new Node(item, lastNode, null);
        if (isEmpty()){
            firstNode = newNode;
        }else{
            lastNode.setNext(newNode);
        }
        lastNode = newNode;
        count ++;
    }

    public void add(E item){
        addLast(item);
    }

    public boolean add(int index, E item){
        if (index < 0 ){
            throw  new IllegalArgumentException("Неверный индекс");
        }
        Node current = firstNode;
        for (int i = 0; i < index-1; i++) {
            current = current.getNext();
        }
        Node newNode = new Node(item, current, current.getNext());
        current.setNext(newNode);
        newNode.getNext().getPrev().setPrev(newNode);
        count ++;
        return true;
    }

    public boolean set(int index, E item) {
        if (index < 0 || index > count) {
            throw new IllegalArgumentException("Неверный индекс");
        }
        Node current = firstNode;
        for (int i = 0; i < index-1; i++) {
            current = current.getNext();
        }
        current.setValue(item);
        return  true;
    }

    public E getLast(){
        if (isEmpty()){
            throw new NoSuchElementException("Список пустой");
        }
        return lastNode.getValue();
    }
    public E getFirst(){
        if (isEmpty()){
            throw new NoSuchElementException("Список пустой");
        }
        return firstNode.getValue();
    }

    public E removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException("Список пустой");
        }
        E value = firstNode.getValue();
        if (firstNode.getNext() != null){
            firstNode = firstNode.getNext();
            firstNode.setPrev(null);
        }else{
            firstNode = null;
        }
        count --;
        return value;
    }

    public E removeLast(){
        if (isEmpty()){
            return null;
        }
        E value = lastNode.getValue();
        if (lastNode.getPrev() == null){// это также первый элемент
            firstNode = null;
        }else {
            lastNode = lastNode.getPrev();
            lastNode.setNext(null);
        }
        count --;
        return  value;
    }

    public E remove(E item){
        Node current = firstNode;
        if (current.getValue().equals(item)){
            return removeFirst();

        }
        while (!current.getValue().equals(item) && current != lastNode){
                current = current.getNext();
        }

        if (current == lastNode && !current.getValue().equals(item)) {
            return  null;
        }
        if (current == lastNode && current.getValue().equals(item)) {
            return removeLast();

        }
        E value = current.getValue();
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        count--;
        return value;
    }

    @Override
    public String toString() {
        if (isEmpty()){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        Node current = firstNode;
        while (current != lastNode){
            sb.append(current.getValue()).append(", ");
            current = current.getNext();
        }
        sb.append(lastNode.getValue());
        return sb.toString();
    }
}

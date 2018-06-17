package com.company.hw.model;

import java.util.Iterator;

public class MyLinkedListImpl<T> implements MyLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void addFirst(T data) {

        Node<T> node = new Node<T>(data);
        if (head == null) {
            tail = node;
        } else {
            node.setNext(head);
            head.setPrev(node);
        }
        head = node;
        size++;
    }

    public void addLast(T data) {

        Node<T> node = new Node<T>(data);
        if (tail == null) {
            head = node;
        } else {
            node.setPrev(tail);
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    public void add(int index, T data) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        if (index == 0) addFirst(data);
        if (index == size) addLast(data);

        Node<T> right = getNodeByIndex(index);
        Node<T> left = right.getPrev();
        Node<T> node = new Node<T>(data);

        node.setNext(right);
        node.setPrev(left);
        left.setNext(node);
        right.setPrev(node);

        size++;
    }

    public void add(T data) {
        addLast(data);
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> node = getNodeByIndex(index);
        return node.getData();
    }

    public void set(int index, T data) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> node = getNodeByIndex(index);
        node.setData(data);
    }

    public T removeFirst() {
        T res = null;

        if (head == tail) {
            if (head == null) return null;

            res = head.getData();
            head = null;
            tail = null;
        } else {
            res = head.getData();
            Node<T> node = head.getNext();
            node.setPrev(null);
            head = node;
        }
        size--;
        return res;
    }

    private Node<T> getNodeByIndex(int index) {
        int counter = 0;
        Node<T> current = head;
        while (counter < index) {
            current = current.getNext();
            counter++;
        }
        return current;
    }

    public int size() {
        return size;
    }

    @Override
    public void removeLast() {
        if (tail != null) {
            tail = tail.getPrev();
            tail.setNext(null);
            size--;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        if (head == null) {
            return "[]";
        }
        stringBuilder.append(head.getData());
        Node currentNode = head.getNext();
        while (currentNode != null) {

            stringBuilder.append(", ");
            stringBuilder.append(currentNode.getData());
            currentNode = currentNode.getNext();
        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void remove(T data) {
        if (head != null) {
            Node<T> node = head;
            if (node.getData().equals(data)) {
                if (node.getNext() != null) {
                    head = node.getNext();
                    size--;
                } else {
                    head = null;
                }
            }
        }
    }
}

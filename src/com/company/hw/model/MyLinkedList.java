package com.company.hw.model;

public interface MyLinkedList<T> {
    void addFirst(T data);
    void addLast(T data);
    void add(int index, T data);
    void add(T data);
    T get(int index);
    void set(int index, T data);
    T removeFirst();
    int size();
    void removeLast();
    void remove(T data);
}

package com.faculdade.structures;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue<T> {
    private LinkedList<T> lista = new LinkedList<>();

    public void enqueue(T value) {
        lista.addLast(value);
    }

    public T dequeue() {
        if (lista.isEmpty()) throw new NoSuchElementException();
        return lista.removeFirst();
    }

    public boolean isEmpty() {
        return lista.isEmpty();
    }

    public int size() {
        return lista.size();
    }

    public void clear() {
        lista.clear();
    }

    public T peek() {
        if (lista.isEmpty()) throw new NoSuchElementException();
        return lista.getFirst();
    }

    public java.util.List<T> toList() {
        return new java.util.ArrayList<>(lista);
    }
}                                                                       

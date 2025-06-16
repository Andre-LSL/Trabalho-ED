package com.faculdade.structures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class OrderedList<T> {

    private List<T> interna = new ArrayList<>();

    public void add(T item) {
        interna.add(item);
    }

    // Ordena usando QuickSort (mantém o Comparator)
    public void sort(Comparator<T> comparador) {
        quickSort(0, interna.size() - 1, comparador);
    }

    // Função auxiliar para QuickSort recursivo
    private void quickSort(int esquerda, int direita, Comparator<T> comparador) {
        if (esquerda < direita) {
            int indicePivo = partition(esquerda, direita, comparador);
            quickSort(esquerda, indicePivo - 1, comparador);
            quickSort(indicePivo + 1, direita, comparador);
        }
    }

    // Particiona e retorna o índice do pivô
    private int partition(int esquerda, int direita, Comparator<T> comparador) {
        T pivo = interna.get(direita);
        int i = esquerda - 1;
        for (int j = esquerda; j < direita; j++) {
            if (comparador.compare(interna.get(j), pivo) > 0) { // Decrescente
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, direita);
        return i + 1;
    }

    // Troca dois elementos na lista
    private void swap(int i, int j) {
        T temp = interna.get(i);
        interna.set(i, interna.get(j));
        interna.set(j, temp);
    }

    public List<T> toList() {
        return interna;
    }

    public int size() {
        return interna.size();
    }
}

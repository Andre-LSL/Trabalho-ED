package com.faculdade.structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Lista encadeada genérica com variáveis em português
public class LinkedList<T> implements Iterable<T> {

    private No<T> inicio; // Início da lista
    private int tamanho = 0; // Tamanho da lista

    // Nó interno da lista
    private static class No<T> {
        T valor;        // Valor armazenado
        No<T> proximo;  // Próximo nó
        No(T valor) { this.valor = valor; }
    }

    // Adiciona um elemento ao final da lista
    public void add(T valor) {
        No<T> novo = new No<>(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            No<T> atual = inicio;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = novo;
        }
        tamanho++;
    }

    // Remove todos os elementos que satisfazem o predicate
    public boolean removeIf(java.util.function.Predicate<T> predicate) {
        boolean removido = false;
        No<T> atual = inicio, anterior = null;
        while (atual != null) {
            if (predicate.test(atual.valor)) {
                if (anterior == null) {
                    inicio = atual.proximo;
                } else {
                    anterior.proximo = atual.proximo;
                }
                removido = true;
                tamanho--;
            } else {
                anterior = atual;
            }
            atual = atual.proximo;
        }
        return removido;
    }

    // Limpa a lista
    public void clear() {
        inicio = null;
        tamanho = 0;
    }

    // Retorna o tamanho da lista
    public int size() {
        return tamanho;
    }

    // Permite o uso de for-each (Iterable)
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            No<T> atual = inicio;
            public boolean hasNext() { return atual != null; }
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                T valor = atual.valor;
                atual = atual.proximo;
                return valor;
            }
        };
    }
}

package com.faculdade.structures;

import java.util.LinkedList;

// Tabela hash genérica simples para chave (K) e valor (V)
public class HashTable<K, V> {

    // Par chave-valor
    private static class Entry<K, V> {
        K chave;
        V valor;
        Entry(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

    // Array de listas (cada posição é um "balde")
    private LinkedList<Entry<K, V>>[] baldes;
    private int capacidade;

    // Cria a tabela com quantidade de baldes desejada
    @SuppressWarnings("unchecked")
    public HashTable(int capacidade) {
        this.capacidade = capacidade;
        baldes = new LinkedList[capacidade];
        for (int i = 0; i < capacidade; i++)
            baldes[i] = new LinkedList<>();
    }

    // Calcula índice do balde usando hashCode da chave
    private int hash(K chave) {
        return Math.abs(chave.hashCode()) % capacidade;
    }

    // Insere ou atualiza um valor para a chave
    public void put(K chave, V valor) {
        int indice = hash(chave);
        for (Entry<K, V> entry : baldes[indice]) {
            if (entry.chave.equals(chave)) {
                entry.valor = valor; // Se já existe, só atualiza
                return;
            }
        }
        baldes[indice].add(new Entry<>(chave, valor)); // Se não existe, adiciona
    }

    // Busca o valor pela chave
    public V get(K chave) {
        int indice = hash(chave);
        for (Entry<K, V> entry : baldes[indice]) {
            if (entry.chave.equals(chave)) return entry.valor;
        }
        return null; // Não achou
    }

    // Verifica se a chave está na tabela
    public boolean containsKey(K chave) {
        int indice = hash(chave);
        for (Entry<K, V> entry : baldes[indice]) {
            if (entry.chave.equals(chave)) return true;
        }
        return false;
    }

    // Remove uma chave da tabela
    public void remove(K chave) {
        int indice = hash(chave);
        baldes[indice].removeIf(entry -> entry.chave.equals(chave));
    }

    // Limpa toda a tabela
    public void clear() {
        for (LinkedList<Entry<K, V>> balde : baldes)
            balde.clear();
    }
}

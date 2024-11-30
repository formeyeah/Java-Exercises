package com.freeland.oop.session12generic.withgenericsadvanced1;

public class Pair<K, V> {
    // Attributes to hold the key and value
    private K key;
    private V value;

    // Constructor to initialize the pair
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Method to get the key
    public K getKey() {
        return key;
    }

    // Method to get the value
    public V getValue() {
        return value;
    }

    // Method to set the key
    public void setKey(K key) {
        this.key = key;
    }

    // Method to set the value
    public void setValue(V value) {
        this.value = value;
    }
}
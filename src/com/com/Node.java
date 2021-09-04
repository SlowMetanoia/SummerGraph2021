package com.com;

public class Node<T> implements NodeProx<T>{
    private final T value;
    public Node(T value) {
        this.value = value;
    }
    @Override
    public T GetValue() {
        return null;
    }
}

package com.com;

public class Edge<T> {

    final protected T value;
    final protected Node first;
    final protected Node second;

    public Edge(T value, Node first, Node second) {
        this.value = value;
        this.first = first;
        this.second = second;
    }
    public boolean isConnected(Node node) {
        return (node == first) || (node == second);
    }

    public T getValue() {
        return value;
    }

    public Node getFirst() {
        return first;
    }

    public Node getSecond() {
        return second;
    }
}

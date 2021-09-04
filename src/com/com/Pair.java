package com.com;

public class Pair<T1,T2>{
    final private T1 value1;
    final private T2 value2;

    public Pair(T1 value1, T2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
    public T1 getValue1() {
        return value1;
    }

    public T2 getValue2() {
        return value2;
    }
}

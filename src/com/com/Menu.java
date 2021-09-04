package com.com;

import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;

//абстрация всех консольных меню
public class Menu<T> {
    protected HashMap<String, Pair<Consumer<T>, String>> menuMap;
    protected T context;

    public T getContext() {
        return context;
    }

    public void setContext(T context) {
        this.context = context;
    }

    public Menu(T context) {
        this.context = context;
        menuMap = new HashMap<>();
    }

    void Read() {
        Scanner input = new Scanner(System.in);
        menuMap.get(input.nextLine()).getValue1().accept(context);
    }
    void AddOption(String str,String description,Consumer<T> consumer) {
        menuMap.put(str, new Pair<>(consumer, description));
    }
    public String getContent() {
        String result = new String();
        for (String str:menuMap.keySet()) {
            result = result + str + "\t" + menuMap.get(str).getValue2() + "\n";
        }
        return "\n"+result;
    }
}

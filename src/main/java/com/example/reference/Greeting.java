package com.example.reference;

public class Greeting {
    String name;

    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String hello(String name) {
        return "hello" + name;
    }

    public static String hi(String name) {
        return "hi "+ name;
    }
}

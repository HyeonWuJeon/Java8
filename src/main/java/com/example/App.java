package com.example;

import com.example.deinterface.DefaultFoo;
import com.example.deinterface.Foo;

public class App {

    public static void main(String[] args) {
        Foo foo = new DefaultFoo("Hyunwooo");
        foo.printName();
        foo.printNameUpperCase();
        Foo.printAnything();
    }
}

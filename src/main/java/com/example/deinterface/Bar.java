package com.example.deinterface;

public interface Bar {
    //bar에서는 foo가 제공하는 디폴트 메소드를 받고싶지 않다.

    //다시 추상메소드로 선언해 주면 된다.
//    void printNameUpperCase();


    default void printNameUpperCase(){
        System.out.println("Bar");
    }

    String getName();

}

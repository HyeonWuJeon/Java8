package com.example.lambda;

@FunctionalInterface //추상메서드가 하나만존재할경우
public interface RunSomething {

    int doIt(int num); // 추상 메서드가 하나만 있으면 함수형 인터페이스가 된다. SAM

    //    // static method 에 public 키워드 생략이 가능하다
    static void printName(){
        System.out.println("Hyunwoo"); // 인터페이스 안에다 정의가 가능하다
    }
    default void printSAge() { // default 가능하다
        System.out.println("Default");
    }
}
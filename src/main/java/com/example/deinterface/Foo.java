package com.example.deinterface;

public interface Foo {
    void printName();

    /**
     * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase(){
        System.out.println(getName().toUpperCase());
    }

//    default String toString(){ default 메소드는 object것들을 재정의 할 수 없다.
//
//    }
    static void printAnything(){
        System.out.println("Foo");
    }
    String toString(); //선언 하는것은 괜찮다.
    String getName();

}

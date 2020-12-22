package com.example.deinterface;



public class DefaultFoo implements Foo, Bar{ // 다이아몬드 문제


    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(name);
    }

    @Override
    public void printNameUpperCase() {

    }

    @Override
    public String getName() {
        return null;
    }

    //충돌하는 디폴트 메소드가 있는 경우 직접 오버라이드 해야한다.
//    @Override
//    public void printNameUpperCase() {
//        System.out.println(getName().toUpperCase());
//    }

//    @Override
//    public String getName() {
//        return name;
//    }

}

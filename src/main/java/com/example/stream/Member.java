package com.example.stream;

public class Member {
    static int MALE = 0;
    static int FEMALE = 1;
    String name;
    int sex;
    int age;

    public Member(String name, int sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public int getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }
}

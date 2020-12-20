package com.example.java8to11;

import java.util.function.Function;

public class Plus10 implements Function<Integer, Integer> { //입력타입, 리턴타입

    // 기존의 익명내부 클래스
    @Override
    public Integer apply(Integer integer) {
        return integer + 10;
    }
}
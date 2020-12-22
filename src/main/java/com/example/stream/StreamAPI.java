package com.example.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("hyunwoo");
        names.add("test");
        names.add("junit5");
        names.add("mockito");

        Stream<String> stringStream = names.stream().map(String::toUpperCase);

        System.out.println("스트림은 원본데이터를 변환시키지 않는다");
        names.forEach(System.out::println);
        System.out.println("=================================");
        stringStream.forEach(System.out::println);

//            System.out.println("스트림은 무제한 데이터일 수 있다. ShortCircuit메소드를 사용해서 무제한을 제한할 수 있다.");
        System.out.println("스트림의 중개 오퍼레이션은 LAZY한 속성을 갖는다.");
        names.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        }).collect(Collectors.toList());


        System.out.println("=======================");
        names.forEach(System.out::println);

        List<String> collect = names.parallelStream().map((s)->{
            System.out.println(s+ " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());

    }

}

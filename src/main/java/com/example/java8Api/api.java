package com.example.java8Api;

import org.springframework.util.StopWatch;

import java.util.*;

public class api {
    public static void main(String[] args) {
        //시간 측정
        StopWatch stopWatch = new StopWatch();

        //iterable
        //collection
        //comparator

        List<String> name = new ArrayList<>();
        name.add("hyunwoo");
        name.add("test");
        name.add("junit5");
        name.add("mockito");

        System.out.println("for 문");
        for (String s : name) {
            System.out.println(s);
        }
        System.out.println("----------------");

        //2
        System.out.println("foreach 문");
        name.forEach(System.out::println); // Function interface Consumer가 들어간다.
        System.out.println("----------------");

        //3


        //4 객체를 가져오는 과정때문에 속도가 느림.
        Iterator<String> iter = name.iterator(); // 알고리즘에서는 size를 받아서 처리하는 for문이 속도가더 빠르다.
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

        //중요 쪼갤수있는 기능을 가지고있는 iterator , stream
        Spliterator<String> spliterator = name.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("==============");
        while(spliterator1.tryAdvance(System.out::println));

        name.removeIf(s->s.startsWith("h")); //h로 시작하는 것을 제외해라.
        name.forEach(System.out::println);

        System.out.println("====================");
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed().thenComparing(Comparator.reverseOrder()));
    }
}

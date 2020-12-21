package com.example.java8Api;


import org.springframework.util.StopWatch;

import java.lang.reflect.Array;
import java.util.*;

public class api {
    private static List<String> RESULT = new LinkedList<String>();
    public static ArrayList<String> test_data = InputTestData();

    public static void main(String[] args) {

        //iterable
        //collection
        //comparator

        List<String> name = new ArrayList<>();
        name.add("hyunwoo");
        name.add("test");
        name.add("junit5");
        name.add("mockito");


        //1
        timeChecker("일반 반복문 :: ",()->{
        for (int i = 0; i < test_data.size(); i++) {
            int k = Integer.parseInt(test_data.get(i));
            }
        });

        //2 객체를 가져오는 시간때문에 속도가 느리다.
        timeChecker("Iterator while:: ",()->{
            Iterator<String> iter = test_data.iterator();
            while (iter.hasNext()){
                int arg = Integer.parseInt(iter.next());
            }
        });

        //3
        timeChecker("stream :: ",()->{
            test_data.stream().forEach(x -> {int k = Integer.parseInt(x);});
        });

        //4
        timeChecker("spliterator :: ",()->{
            Spliterator<String> spliterator = test_data.spliterator();
            Spliterator<String> spliterator1 = spliterator.trySplit();
//            while(spliterator.tryAdvance(x -> { int k = Integer.parseInt(x); }));
            while(spliterator1.tryAdvance(x -> { int k = Integer.parseInt(x); }));
        });

        RESULT.forEach(System.out::println);

        // 병럴처리에서 유용하게 쓰인다.
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
        name.sort(compareToIgnoreCase.reversed());
        name.forEach(System.out::println);
        name.sort(String::compareToIgnoreCase);
    }

    // 실행 시간 측정을 위헤 데이터를 담는 함수.
    public static ArrayList<String> InputTestData() {
        ArrayList<String> arr = new ArrayList<String>();
        for (int i = 0; i < 15000000; i++) {
            arr.add(""+i);
        }
        return arr;
    }


    //시간 기록용 메소드
    public static void timeChecker(String name, Todo todo){
        long beforeTime = System.currentTimeMillis();
        todo.todo();
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        RESULT.add(name + " 시간차이(m) : "+secDiffTime);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) { e.printStackTrace(); }
    }


    //콜백용 인터페이스
    public interface Todo{
        void todo();
    }
}

package com.example.stream;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OnlineMain {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2,"spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api developemnt", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code mainpulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", true));

        List<List<OnlineClass>> hyunwooEvents = new ArrayList<>();
        hyunwooEvents.add(springClasses);
        hyunwooEvents.add(javaClasses);


        System.out.println("spirng 으로 시작하는 수업");
        //TODO

        springClasses.stream()
                .filter(x -> x.getTitle().startsWith("spring"))
                .forEach(x-> System.out.println(x.getTitle()));

        System.out.println("close 되지 않은 수업");
        //TODO
        springClasses.stream()
                      .filter(oc -> !oc.isColsed())
                      .forEach(oc-> System.out.println(oc.getId()));
        springClasses.stream()
                      .filter(Predicate.not(OnlineClass::isColsed))
                      .forEach(oc-> System.out.println(oc.getId()));
        hyunwooEvents.stream().flatMap(Collection::stream)
                .filter(Predicate.not(OnlineClass::isColsed))
                .forEach(x-> System.out.println(x.getTitle()));

        System.out.println("스프링 클래스의 수업 이름만 모아서 스트림 만들기");
        //TODO
        springClasses.stream()
                .map(OnlineClass::getTitle) // 문자로 나열한다.
                .forEach(System.out::println);

        System.out.println("두 수업 목록에 들어있는 모든 수업이름 출력");
        //TODO
        hyunwooEvents.stream()
                .flatMap(Collection::stream) // 두 클래스를 나열한다.
                .forEach(oc-> System.out.println(oc.getTitle()));
        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        //TODO
        Stream.iterate(10, i-> i+1) // 중개형 오퍼레이터.
                .skip(10) //처음에 10개는 스킵하고
                .limit(10) //최대 10개만 가져온다.
                .forEach(System.out::println);


        System.out.println("자바 수업 중에 Test가 들어있는 수없이 있는지 확인");
        //TODO
        boolean Test = javaClasses.stream()
                .anyMatch(oc->oc.getTitle().contains("Test"));
        System.out.println(Test); //true

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List만들기");
        //TODO
        List<String> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        spring.forEach(System.out::println);

        System.out.println("스프링 수업 이름순으로 정렬하게");
        //TODO
        List<String> stringList = springClasses.stream()
                                                .map(OnlineClass::getTitle)
                                                .sorted(Comparator.reverseOrder()) // natureOrder :: 기본비교 , reverseOrder :: 역비교
                                                .collect(Collectors.toList());
        stringList.forEach(System.out::println);
    }
}

package com.example.stream;

import java.util.ArrayList;
import java.util.List;
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
                .forEach(s -> System.out.println(s.getId()));

        System.out.println("close 되지 않은 수업");
        //TODO


        System.out.println("수업 이름만 모아서 스트림 만들기");
        //TODO

        System.out.println("두 수업 목록에 들어있는 모든 수업아이디 출력");
        //TODO

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        //TODO

        System.out.println("자바 수업 중에 Test가 들어있는 수없이 있는지 확인");
        //TODO

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List만들기");
        //TODO
    }
}

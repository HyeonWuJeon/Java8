package com.example.reference;

import com.example.reference.Greeting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReference {

    public static void main(String[] args) {
        System.out.println("스태틱 메소드 참조하기");
        UnaryOperator<String> unaryOperator =(name) -> "hi "+name; //Greeting함수와 하는일이 똑같다
        UnaryOperator<String> unaryOperator1= Greeting::hi; // 메소드 레퍼런스. static함수를 가져온다 ::
        System.out.println(unaryOperator1.apply("Hyunwoo"));

        System.out.println("인스턴스 메소드 참조하기");
        Greeting greeting = new Greeting();
//        Supplier<Greeting> greetingSupplier = Greeting::new; // 생성자
        UnaryOperator<String> unaryOperator2 =greeting::hello;
        System.out.println(unaryOperator2.apply("Hyunwoo"));

        System.out.println();
        System.out.println("============생성자 참조하기==============");
        System.out.println("입력값이 없는 생성자 만들기 : Supplier ");
        Supplier<Greeting> greetingSupplier = Greeting::new; // 생성자 객체 리턴
        System.out.println(greetingSupplier.get());

        System.out.println("입력값이 있는 생성자 만들기 : Function");
        Function<String,Greeting> hyunwooGreeting = Greeting::new;
        Greeting hyun = hyunwooGreeting.apply("HyunwooWhiteShip");
        System.out.println(hyun.getName());

        System.out.println("불특정 다수의 인스턴스 참조하기");
        String[] names = {"hyunwoo", "whiteship","toby","jekky","Gomazie","kaka"};

        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        //@Functionalinterface로 적용하기
//        Arrays.sort(names, String::compareToIgnoreCase); //대문자를 무시하고 비교한다.
//        Arrays.sort(names,String::compareTo);
        Arrays.sort(names,0,3,String::compareTo); // 0~2번 인덱스 까지만 오름차순 정렬
        System.out.println(Arrays.toString(names));
    }
}


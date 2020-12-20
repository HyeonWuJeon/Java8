package com.example.lambda;

import java.util.function.*;

public class OfferInterface  { // 다이아몬드 문제 , 어떤default를 먼저 쓰게 할거냐? 컴파일 에러



    public static void main(String[] args) {

        int basenum = 10;
//        // 함수형 인터페이스 사용 방법. lambda
//        // 순수함수의 조건 :: 어떠한 값이 들어가도 같은 값이 들어가면 결과가 같아야 한다.
//        // 함수 밖의 값을 사용 할 경우 순수함수의 조건을 충족 못시킬 수 도있다.
        RunSomething runSomething = number -> number+basenum;

        System.out.println("함수형 인터페이스는 입력값과 출력값이 같아야 한다");
        System.out.println(runSomething.doIt(10));
        System.out.println(runSomething.doIt(10));
        System.out.println(runSomething.doIt(10));
        System.out.println("-------------------------------------------");


        System.out.println("Function 함수 : 하나의 입력값을 받는 연산자 함수이다.");
        Function<Integer, Integer> plus10 = (i) -> i + 10;
        System.out.println(plus10.apply(1)); //10
        Function<Integer, Integer> multiply2 = (i) -> i * 2;
        System.out.println(multiply2.apply(2)); // 4

        System.out.println("compose 함수 : () 안의 변수를 먼저계산하고 출력된 값을 '.' 앞의 변수에 입력값으로 적용시킨다.");
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2);// 컴포우즈 : 입력값을 가지고 먼저 뒤에오는 함수를 적용시킨다. 그리고 결과값을 plus10의 입력값으로 사용한다.
        System.out.println("곱셈 함수의 리턴값을 플러스 함수의 입력값으로 받는다 : " + multiply2AndPlus10.apply(2));  // 14

        System.out.println("andThe 함수 : '.' 앞의 변수를 먼저 계산하고 출력된 값을 () 변수의 입력값에 적용시킨다");
        System.out.println("플러스 함수의 리턴값을 곱셈 함수의 입력값으로 받는다 :  " +plus10.andThen(multiply2).apply(2)); // 24 : plus10의 결과값을 multi에서 입력값으로 사용한다.


        System.out.println("Consumer 함수 : 리턴값은 없으며 출력값만 있다.");
        Consumer<Integer> printT = (i) -> System.out.println(i);
        printT.accept(10);

        System.out.println("BiConsumer 함수 : 입력값이 두개일 경우 사용한다." );
        BiConsumer<Integer, String> printBi= (i, s) -> System.out.println("첫번째 값 : " + i +" 두번째 값 : " + s);
        printBi.accept(10,"abc");

        System.out.println("Supplier 함수 : 정해진 값 없이 무조건 입력한 값을 내뱉는다.");
        Supplier<Integer> get10 = () ->20;
        System.out.println(get10.get());

        //Predicate True False를 리턴해준다.
        System.out.println("Predicate 함수 : boolean 값을 내뱉는다." );
        Predicate<String> start = (s) -> s.startsWith("Hyunwoo");
        Predicate<String> num = (s) -> s.length()<10;
        Predicate<Integer> isEvnen = (i) -> i % 2 ==0;
        Predicate<Integer> isOdd = (i) -> i % 2 ==1;

        // true false 에 대해서 and or not 조합이 가능하다.
        System.out.println("test : " + start.test("Hyunwoo"));
        System.out.println("test : " + isEvnen.test(2));

        System.out.println(start.and(num).test("Hyunwooabcdefgggg"));
        System.out.println(isEvnen.or(isOdd).test(2));


        System.out.println("UnaryOperator : 입력값과 출력값의 타입이 같을때 하나로 줄여서 사용가능하다.");
        UnaryOperator<Integer> unary = (i) -> i + 10; //람다식을 활용한 함수 호출
        System.out.println(unary.apply(10));

        BinaryOperator<Integer> getBi = (a,b) -> a+b;
        System.out.println(getBi.apply(10,20));

    }

}

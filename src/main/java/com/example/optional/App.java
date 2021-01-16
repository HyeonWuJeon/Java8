package com.example.optional;

import com.example.stream.OnlineClass;
import com.example.stream.Progress;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(1, "spring security", true));
        springClasses.add(new OnlineClass(5, "rest api development", true));

        System.out.println("제목이 'spring' 로 시작하는 첫번째 온라인클래스를 찾아라.");
        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();

        System.out.println("1. isPresent :: 값의 유무를 검사한다.");
        boolean present = optional.isPresent();
        System.out.println(present);

        System.out.println("2. isEmpty :: 자바 11 부터 제공한다.");
        boolean empty  = optional.isEmpty();
        System.out.println(empty);

        System.out.println("3. get :: 값을 꺼내온다. 만약 값이 없을 경우 런타임 에러 NoSuchElementException.class 을 리턴한다.");
        if(optional.isPresent()) { // isPresent 값 유무를 먼저 체크 해준다. ( 런타임 에러 방지 )
            OnlineClass onlineClass = optional.get();
            System.out.println(onlineClass.getTitle());
        }

        System.out.println("4. optional + lambda");
        optional.ifPresent(oc-> System.out.println(oc.getTitle()));


        System.out.println("5. orElse :: 값이 있든 없든 인스턴스를 만든다.");
        OnlineClass onlineClass1 = optional.orElse(createNewJpaClass());
        System.out.println(onlineClass1.getTitle());

        System.out.println("6. orElseGet :: Supplier 를 줄 수있다. 값이 없을 경우에만 인스턴스를 만든다.");
        // OnlineClass onlineClass2 = spring.orElseGet(()->createNewJpaClass()); // 람다
        OnlineClass onlineClass2 = optional.orElseGet(App::createNewJpaClass); // 메소드레퍼런스
        System.out.println(onlineClass2.getTitle());

        System.out.println("7. orElseThrow :: 값이 없을 경우 원하는 예외를 리턴할 수 있다.");
        //OnlineClass onlineClass3 = spring.orElseThrow(() -> new IllegalArgumentException("Exception")); // 람다
        OnlineClass onlineClass3 = optional.orElseThrow(IllegalStateException::new); // 메소드 레퍼런스
        System.out.println(onlineClass3.getTitle());

        System.out.println("8. filter");
        Optional<OnlineClass> onlineClass4 = optional.filter(oc -> !oc.isColsed());
        System.out.println(onlineClass4.isPresent());

        System.out.println("9. map");
        Optional<String> s = optional.map(OnlineClass::getTitle);
        System.out.println(s.isPresent());

        System.out.println("10. Optional에서 제공하는 flatmap :: 맵핑타입이 optional 일 경우 한번 더 풀어준다.");
        Optional<Optional<Progress>> progress1 = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress2 = progress1.orElse(Optional.empty());
        System.out.println(progress2);

        Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);
        System.out.println(progress);
    }



    private static OnlineClass createNewJpaClass() {
        System.out.println("creating new online class");
        return new OnlineClass(1,"new Class",false);
    }
}

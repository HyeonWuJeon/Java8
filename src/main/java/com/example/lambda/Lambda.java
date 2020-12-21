package com.example.lambda;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class Lambda {

    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        lambda.run();
    }

    private void run() {
        int baseNumber = 10; // final 삭제가능.

        //1. 로컬 클래스
        class LocalClass{
            void printBaseNumber() {
                int baseNumber = 11; //변수 scope 쉐도잉
                System.out.println(baseNumber); // 11
            }
        }
        //2. 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer baseNumber) { // 더 이상 익명 클래스를 감사고있던 baseNumber변수를 받지않는다. 해당 scope안에있는 파라메터 baseNumber을 담는다.
                System.out.println(baseNumber);
            }
        };
        //3. 람다
        IntConsumer printInt = (i) -> {
//            int baseNumber = 20; // 같은 변수명으로 사용할 수 없다. 변수 scope 이 같기 때문이다
            System.out.println(i+baseNumber);
        };
        printInt.accept(10);
//        baseNumber = 20; final 이기 때문에 사용불가

    }

    /**
     * 쉐도잉!
     */
}

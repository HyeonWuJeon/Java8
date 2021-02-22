package com.example.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Executor {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 작업이 실행되고 나면 다음 작업이 들어오기위해 계속 대기중이다.
//      ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        ExecutorService executorService =Executors.newFixedThreadPool(2); // 스레드 2개 생성
//        executorService.submit(getRunable("Hello"));
//        executorService.submit(getRunable("Hello2"));
//        executorService.submit(getRunable("Hello3"));
//        executorService.submit(getRunable("Hello4"));
//        executorService.submit(getRunable("Hello5"));
//        executorService.submit(getRunable("Hello5"));

//        //TODO :  3초를 지연 시키고 실행 한다.
        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        executorService.schedule(getRunable("Hello5Second"), 3, TimeUnit.SECONDS);
//
//        //TODO : 처음에 1초 기다리고 출력하고 다음부턴 2초 간격으로 계속출력한다.
//        executorService.scheduleAtFixedRate(getRunable("Hello5Second"), 1,2, TimeUnit.SECONDS);

        //TODO : Callable
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "abc";
        };

        /**
         * Callable 리턴하는 타입의 Future 를 받는다.
         */
        Future<String> HelloFuture = executorService.submit(hello);
        System.out.println(HelloFuture.isDone()); //작업 상태 확인하기
        System.out.println("Started!");

//        HelloFuture.cancel(true); // 현재 작업을 인터럽트하고 종료
//        HelloFuture.cancel(false); // 현재 작업을 기다리고 종료. 기다리더라도 값을 가져올 수 없다. error
        /**
         * 결과값을 가져올때 까지 기다린다 == 블록킹콜
         */
        System.out.println(HelloFuture.get());  // 2초 딜레이 , cancle 후 값을 못가져온다.
        System.out.println(HelloFuture.isDone()); //작업 상태 확인하기
        System.out.println("Finished!");

        Callable<String> hellos = () -> {
            Thread.sleep(2000);
            return "Hello";
        };
        Callable<String> hyeon = () -> {
            Thread.sleep(2000);
            return "Hyeon";
        };
        Callable<String> woo = () -> {
            Thread.sleep(1000);
            return "Woo";
        };
        /**
         * invokeAll : 모든 스레드가 끝날때 까지 기다린다.
         */
        List<Future<String>> futures = executorService.invokeAll(Arrays.asList(hellos, hyeon, woo));

        /**
         * invokeAny : 제일 빨리 작업이 끝난 스레드 하나를 리턴한다.
         */
        String s = executorService.invokeAny(Arrays.asList(hellos, hyeon, woo));

        System.out.println("invokde All : ");
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }
        System.out.println("invokeAny : " + s);


        //TODO : shutdown
//      executorService.shutdown();


    }
//
//    private static Runnable getRunable(String message) {
//        return () -> System.out.println(message + Thread.currentThread().getName());
//    }


}

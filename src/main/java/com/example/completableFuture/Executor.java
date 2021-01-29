package com.example.completableFuture;

import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Executor {

    public static void main(String[] args) {
        // 작업이 실행되고 나면 다음 작업이 들어오기위해 계속 대기중이다.
//      ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//        ExecutorService executorService =Executors.newFixedThreadPool(2); // 스레드 2개 생성

        // 스케줄사용
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(getRunable("Hello5Second"), 3, TimeUnit.SECONDS); // 3초 지연 시키고 실행
        // 처음에 1초 기다리고 출력하고 다음부턴 2초 간격으로 계속출력한다.
        executorService.scheduleAtFixedRate(getRunable("Hello5Second"), 1,2, TimeUnit.SECONDS);


//        executorService.submit(getRunable("Hello"));
//        executorService.submit(getRunable("Hello2"));
//        executorService.submit(getRunable("Hello3"));
//        executorService.submit(getRunable("Hello4"));
//        executorService.submit(getRunable("Hello5"));
//        executorService.submit(getRunable("Hello5"));

//
//        executorService.submit(()->{ // vs execute
//            System.out.println("Thread" + Thread.currentThread().getName());
//        });
        // shutdown 을 해야한다.
//        executorService.shutdown();

    }

    private static Runnable getRunable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }


}

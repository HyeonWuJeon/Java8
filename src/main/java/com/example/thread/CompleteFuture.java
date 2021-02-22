package com.example.thread;

import org.springframework.http.converter.json.GsonBuilderUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class CompleteFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("hyunwoo");
        System.out.println(future.get());

        // void
        // join -> exception : uncatched
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        voidCompletableFuture.get();

        // TODO : thenApply
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return "hello";
        }).thenApply((s)->{ //thenAccept : void, thenrun
            System.out.println("Thread 이름 : " + Thread.currentThread().getName());
            return s.toUpperCase();
        }); // callback : 호출하기 전에 정의하는 것이 가능해졌다.
        System.out.println(" 리턴값이 있는 thenApply(String) : " + stringCompletableFuture.get());

        // TODO : thenAccept
        CompletableFuture<Void> stringCompletableFuture1 =  CompletableFuture.supplyAsync(() -> {
            return "hello1";
        }).thenAccept((s)->{
            System.out.println("Thread 이름 : " + Thread.currentThread().getName());
        }); // callback : 호출하기 전에 정의하는 것이 가능해졌다.
        System.out.println(" 리턴값이 없는 thenAccept(void) : " + stringCompletableFuture1.get());

        // TODO : thenRun
        CompletableFuture<Void> stringCompletableFuture2 = CompletableFuture.supplyAsync(() -> {
            return "hello2";
        }).thenRun(()->{
            System.out.println("Thread 이름 : " + Thread.currentThread().getName());
        }); // callback : 호출하기 전에 정의하는 것이 가능해졌다.
        System.out.println(" 인자를 받지않고 단독적으로 실행하는 thenRun(void) : " + stringCompletableFuture2.get());

        //ForkJoin full : dequeue  맨마지막에 들어오넥 먼저나간다. 자기스레드가 할일이없으면 스레드가 deque에서 처리하는방식프레임워크

        /**
         * BlockingCall
         */
        Callable<String> helloBefore = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };
        Callable<String> helloAfter = () -> {
            Thread.sleep(2000L);
            return "Wolrd";
        };
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<String> hello1 = executorService.submit(helloBefore);
        Future<String> hello2 = executorService.submit(helloAfter);
        hello1.get();
        hello2.get();

        /**
         * Future 조합
         */
        //error
        boolean throwError = true;
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(()->{
            if(throwError){
                throw new IllegalArgumentException();
            }
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Apple stock";
        }).handle((result,ex)->{
           if(ex!=null){
               System.out.println(ex);
               return "Error!";
           }
           return result;
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(()->{
            System.out.println("World " + Thread.currentThread().getName());
            return "Ms stock";
        });

        CompletableFuture<Integer> hyeonwoo = CompletableFuture.supplyAsync(()->{
            System.out.println("hyeonwoo " + Thread.currentThread().getName());
            return 19951129;
        });


        // TODO :: thenCombine
        hello.thenCombine(world, (h,w) ->h+ " " +w);
        System.out.println(future.get());

        // TODO :: thenCompose
        CompletableFuture<String> stringCompletableFuture3 = hello.thenCompose(CompleteFuture::getWorld);
        System.out.println(" 합치기 " + stringCompletableFuture3.get());

        // TODO :: allOf
        List<CompletableFuture> futureList = Arrays.asList(hello,world,hyeonwoo);
        CompletableFuture[] futuresArray = futureList.toArray(new CompletableFuture[futureList.size()]);

        CompletableFuture<List<Object>> results = CompletableFuture.allOf(futuresArray) // 모든 작업이 다끝났을 경우
                .thenApply(v -> {
                    return futureList.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList());
                });
        results.get().forEach(System.out::println);

        // TODO :: anyOf
        CompletableFuture.anyOf(hello,world,hyeonwoo).thenAccept(System.out::println);
        future.get();
    }
    private static CompletableFuture<String> getWorld(String message)  {
        return CompletableFuture.supplyAsync(()->{
            System.out.println("World " + Thread.currentThread().getName());
            return message + " World";
        });
    }
}

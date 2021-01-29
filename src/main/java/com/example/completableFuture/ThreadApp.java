package com.example.completableFuture;

public class ThreadApp {
    public static void main(String[] args) {
        // 1번 방법
//        MyThread myThread = new MyThread();
//        myThread.start();

        // 2번 방법 Runnable Functional 인터페이Java 8
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000L); // 현재 스레드를 재우고 다른 스레드에게 우선권이 간다.
            } catch (InterruptedException e) {
                e.printStackTrace();  // 자는 동안에 누군가가 스레드를 깨우면 이때 catch 문 안에 들어온다.
            }
            System.out.println("second Thread : " + Thread.currentThread().getName());
        });
        thread.start();

        System.out.println("main Thread: " + Thread.currentThread().getName()); // 먼저 실행된다.
    }

    // 1번방법에 사용된다.
    static class MyThread extends Thread{
        @Override
        public void run(){
            System.out.println("Thread: " + Thread.currentThread().getName());
        }
    }
}

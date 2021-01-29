package com.example.completableFuture;

public class ThreadApp2 {
    public static void main(String[] args) throws InterruptedException {
        // 자고있는 스레드를 인터럽트로 깨우는 방법.
        Thread thread = new Thread(()->{
            while(true){
                System.out.println("Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("exit");
                    return; // run 함수 void 이므로 return 종료
                }
            }
        });
        thread.start();

        System.out.println("Hello: "+ Thread.currentThread().getName()); // 메인 스레드
        Thread.sleep(3000L); // 메인 스레드를 3초 재운다.
        thread.interrupt(); // 스레드를 깨운다. 스레드를 종료 하는건 아니다.
        try {
            thread.join(); // 두번째 스레드가 끝날때 까지 기다린다.
        }catch (InterruptedException e){ // join 대기중이기 때문에 interrupt와 마찬가지도 exception을 가지고 있는다.
            e.printStackTrace();
        }
        System.out.println(thread + " is finished"); //  그 다음에 해당구문 출력이 된다.
    }
}

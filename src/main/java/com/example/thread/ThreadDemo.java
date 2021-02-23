package com.example.thread;


class ThreadDemo implements Runnable {

    static boolean autoSave = false;

    public static void main(String[] args) {

        Thread t = new Thread(new ThreadDemo());

        // TODO : 데몬 스레드 설정
        t.setDaemon(true);

        //setDaemon(true): 데몬쓰레드로 (메인쓰레드 종료시 종속쓰레드는 작업 다 못끝내도 메인 쓰레드와 함께 종료된다.)
        t.start();
        for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println(i);
            if (i == 5) {
                autoSave = true;
            }
        }
        System.out.println("프로그램을 종료합니다.");
    }


    @Override
    public void run() {
        while (true) { // 무한 루프
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {

            }
            if (autoSave)
                autoSave();
        }
    }
    private void autoSave() {
        System.out.println("작업파일이 자동저장되었습니다.");
    }
}





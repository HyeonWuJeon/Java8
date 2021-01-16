package com.example.dateTime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class before {

    public static void main(String[] args) throws InterruptedException {
        Calendar calendar = new GregorianCalendar(1982, 7, 15); //  int 값을 받기 때문에 type-safety 하지 않다.
        System.out.println(calendar.getTime()); //캘린더 에서 시간이 나온다.


        calendar.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println(calendar.getTime());

        Date date = new Date();
        long time = date.getTime(); // 날짜에서 시간을 받는다.
        System.out.println(date);
        System.out.println(time); // 사람용이 아닌 기계용 시간으로 출력한다.

        Thread.sleep(1000*3);

        Date after3Seconds = new Date();
        System.out.println(after3Seconds);
        after3Seconds.setTime(time); //mutable 하기 때문에 멀티스레드에서 사용하기에 안정적이지 않다.
        System.out.println(after3Seconds);

    }

}

package com.example.dateTime;

import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.web.servlet.tags.form.AbstractCheckedElementTag;

import javax.imageio.plugins.bmp.BMPImageWriteParam;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateTime {
    public static void main(String[] args)  {


        System.out.println("1. 머신용 시간 출력");
        Instant instant = Instant.now(); // 지금 이 순간을 기계시간으로 표현한다.
        System.out.println(instant); // 기준시 UTC, GMT
        System.out.println(instant.atZone(ZoneId.of("UTC"))); // 기준시 UTC, GMT

        System.out.println("1-1. 지역확인");
        ZoneId zoneId = ZoneId.systemDefault(); // 컴퓨터에 맞춰진 지역시간
        System.out.println(zoneId); // Asia/Seoul
        ZonedDateTime zonedDateTime = instant.atZone(zoneId); // 컴퓨터시간으로 맞춰준다.
        System.out.println(zonedDateTime);

        System.out.println("1-2. 머신용 시간 지역 변경");
        Instant nowInstant = Instant.now();
        ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("America/Sao_Paulo"));
        System.out.println(zonedDateTime1);


        System.out.println("2. 사람용 시간 출력");
        LocalDateTime now = LocalDateTime.now(); // 컴퓨터에 설정된 지역시간을 기준으로 한다.
        System.out.println(now);

        System.out.println("2-1. 시간 만들기");
        LocalDateTime birthday = LocalDateTime.of(1995, Month.NOVEMBER, 15, 0, 0, 0);
        System.out.println(birthday);
        System.out.println("2-2. 사람시간 지역 변경");
        ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        System.out.println(nowInKorea);

        System.out.println("2-3. 오늘부터 내 생일까지 남은 일수");
        LocalDate today = LocalDate.now();
        LocalDate thisYearBirthday = LocalDate.of(2021,Month .NOVEMBER,29);

        // Period 사람용 기간 계산
        Period period = Period.between(today, thisYearBirthday);
        System.out.println(period.getMonths()+"달 " + period.getDays()+"일" );

        Period until = today.until(thisYearBirthday);
        System.out.println(until.get(ChronoUnit.MONTHS)+"달 " + until.get(ChronoUnit.DAYS)+"일");

        //Duration 머신용 기간 계산
        Instant nowin = Instant.now();
        Instant plus = nowin.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(nowin, plus);
        System.out.println(between.getSeconds());

        System.out.println("3. 포매팅 -- ");
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(now.format(MMddyyyy));

        System.out.println("4. 파싱 --");
        LocalDate parse = LocalDate.parse("11/29/1995", MMddyyyy);
        System.out.println(parse);


        System.out.println("5. 레거시API 지원");

        // Date => Instant
        Date date1 = new Date();
        System.out.println(date1);
        Instant instance = date1.toInstant();
        Date newdate = Date.from(instance);

        // GregorianCalendar => Zoned
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        ZonedDateTime dateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
        GregorianCalendar.from(dateTime);

        // timeZone -> Zone
        ZoneId zoneId1 = TimeZone.getTimeZone("PST").toZoneId();

        // Zone -> timeZone
        TimeZone timeZone = TimeZone.getTimeZone(zoneId);

    }
}

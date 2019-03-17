package cn.xc.java82;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @author ShouAn.Zhang
 * @date 2018/9/19 - 15:50
 */
public class TestTime {

    //DateTimeFormatter
    @Test
    public void test6(){

        DateTimeFormatter isoOffsetDateTime = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        LocalDateTime now = LocalDateTime.now();

        

    }


    //TemporalAdjuster
    @Test
    public void test5(){


        LocalDateTime now = LocalDateTime.now();

        System.out.println("now = " + now);

        LocalDateTime localDateTime = now.withDayOfMonth(10);

        System.out.println("localDateTime = " + localDateTime);


        LocalDateTime with = now.with(TemporalAdjusters.firstDayOfNextMonth());

        System.out.println("with = " + with);


        LocalDateTime with1 = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));

        System.out.println("with1 = " + with1);

    }




    //Duration 计算俩个时间之间的间隔
    //period 计算俩个日期之间的间隔

    @Test
    public void test4(){


        LocalDate now = LocalDate.of(2018, 9, 10);


        LocalDate now1 = LocalDate.now();

        Period between = Period.between(now, now1);

        System.out.println("between = " + between.getDays());


    }


    @Test
    public void test3() {

        Instant now = Instant.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant now1 = Instant.now();


        Duration between = Duration.between(now, now1);


        System.out.println("between = " + between.toMillis());


        System.out.println("=======================");

        LocalTime now2 = LocalTime.now();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LocalTime now3 = LocalTime.now();


        Duration between1 = Duration.between(now2, now3);


        System.out.println("between1 = " + between1.toMillis());
        




    }



    //Instant:时间戳
    @Test
    public void test1(){


        Instant now = Instant.now();
        System.out.println("now = " + now);

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));

        System.out.println(offsetDateTime);

        long l = now.toEpochMilli();

        System.out.println("l = " + l);

        Instant instant = Instant.ofEpochSecond(60);

        System.out.println("instant = " + instant);


    }




    //LocalDate   LocalTime  LocalDateTime
    @Test
    public void test(){

        LocalDateTime now = LocalDateTime.now();

        System.out.println("now = " + now);

        LocalDateTime ldt2 = LocalDateTime.of(2015, 5, 5, 5, 5);
        System.out.println("ldt2 = " + ldt2);


        LocalDateTime localDateTime = now.plusYears(12);
        System.out.println("localDateTime = " + localDateTime);


        LocalDateTime localDateTime1 = now.minusHours(2);
        System.out.println("localDateTime1 = " + localDateTime1);

        int year = now.getYear();

        System.out.println(year);

    }

}

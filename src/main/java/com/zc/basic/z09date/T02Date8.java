package com.zc.basic.z09date;

import org.junit.Test;

import java.text.Format;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.Locale;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

public class T02Date8 {
    @Test
    public void test01() {
        // LocalDate类，该类的实例是一个不可变对象，它只提供了简单的日期，并不含当天的时间信息。另外，它也不附带任何与时区相关的信息。
        // 可以通过静态工厂方法of创建一个LocalDate实例。LocalDate实例提供了多种方法来读取常用的值，比如年份、月份、星期几等。

        LocalDate date = LocalDate.of(2014, 3, 18);//2014-03-18
        int year = date.getYear();//2014
        Month month = date.getMonth();//MARCH
        int day = date.getDayOfMonth();//18
        DayOfWeek dayOfWeek = date.getDayOfWeek();//TUESDAY
        int len = date.lengthOfMonth();//31(days in March)
        boolean leap = date.isLeapYear();//false

        // 使用工厂方法从系统时钟获取当前的日期
        LocalDate today = LocalDate.now();

        // 还可以使用传递一个TemporalField参数给get方法拿到同样的信息。TemporalField是一个接口，它定义了如何访问temporal对象某个字段的值。ChronoField枚举实现了这一接口。
        int year1 = date.get(ChronoField.YEAR);
        int month1 = date.get(ChronoField.MONTH_OF_YEAR);
        int day1 = date.get(ChronoField.DAY_OF_MONTH);

        // 创建并读取其值
        LocalTime time = LocalTime.of(13, 45, 20);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();

    }


    @Test
    public void test2() {
        // str -> 日期
        LocalDate date = LocalDate.parse("2014-03-31");
        LocalDate date2 = date.plusDays(1);// 加1天
        int day = date2.get(ChronoField.DAY_OF_MONTH);
        System.out.println(day);

        // 日期 -> str
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date2.format(formatter);
        System.out.println(formattedDate);

        LocalTime time = LocalTime.parse("13:45:20");
    }

    @Test
    public void test3() {
        Instant.ofEpochSecond(3);
        Instant.ofEpochSecond(3, 0);
        Instant.ofEpochSecond(2, 1_000_000_000);//2秒之后再加上100万纳秒（1秒）
        Instant.ofEpochSecond(4, -1_000_000_000);//4秒之后再减去100万纳秒（1秒）
        // 打印当前时间
        Instant.now();
    }

    @Test
    public void test4() {
        // 时间段：Duration和Period
        // 创建两个时间之间的duration
        // Duration类主要用于以秒和纳秒衡量时间的长度
        Temporal time1 = null;
        Temporal time2 = null;
        Duration d1 = Duration.between(time1, time2);
        Temporal dateTime1 = null;
        Temporal dateTime2 = null;
        Duration d2 = Duration.between(dateTime1, dateTime2);
        Temporal instant2 = null;
        Temporal instant1 = null;
        Duration d3 = Duration.between(instant1, instant2);

        // 如果需要以年、月或者日的方式对多个时间单位建模，可以使用Period类
        Period tenDays = Period.between(LocalDate.of(2014, 3, 8),
                LocalDate.of(2014, 3, 18));

        Duration threeMinutes = Duration.ofMinutes(3);
        Duration threeMinutes2 = Duration.of(3, ChronoUnit.MINUTES);

        Period tenDays1 = Period.ofDays(10);
        Period tenDays2 = Period.ofWeeks(3);
        Period twoYearsSixMonthsOneDay = Period.of(2, 6, 1);
    }

    @Test
    public void test5() {
        // 解析 格式化 日期
        LocalDate date1 = LocalDate.of(2014, 3, 18);//2014-03-18
        LocalDate date2 = date1.withYear(2011);//2011-03-18
        LocalDate date3 = date2.withDayOfMonth(25);//2011-03-25
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);//2011-09-25

    }

    @Test
    public void test6() {
        LocalDate date1 = LocalDate.of(2014, 3, 18);//2014-03-18
        LocalDate date2 = date1.plusWeeks(1);
        LocalDate date3 = date2.minusYears(3);
        LocalDate date4 = date3.plus(6, ChronoUnit.MONTHS);

    }

    @Test
    public void tests7() {
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));
        LocalDate date3 = date2.with(lastDayOfMonth());
    }

    @Test
    public void test8() {
        // 打印输出及解析日期-时间对象
        LocalDate date = LocalDate.of(2014, 3, 18);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);//20140318
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);//2014-03-18
    }

    @Test
    public void test9() {
        // 和老的java.util.DateFormat相比较，所有的DateTimeFormatter实例都是线程安全的。所以，你能够以单例模式创建格式器实例，
        // 就像DateTimeFormatter所定义的那些常量，并能在多个线程间共享这些实例。
        // DateTimeFormatter类还支持一个静态工厂方法，它可以按照某个特定的模式创建格式器。
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        String formattedDate = date1.format(formatter);
        LocalDate date2 = LocalDate.parse(formattedDate, formatter);
    }

    @Test
    public void test10() {
        // ofPattern方法也提供了一个重载的版本，使用它你可以创建某个Locale的格式器
        DateTimeFormatter italianFormatter =
                DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        LocalDate date1 = LocalDate.of(2014, 3, 18);
        Format date = null;
        String fromattedDate = date.format(italianFormatter);//18. marzo 2014
        LocalDate date2 = LocalDate.parse(fromattedDate, italianFormatter);

        // 自定义
        DateTimeFormatter italianFormatter2 = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);
    }

}

package com.suchaos.time;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Set;
import java.util.TreeSet;

/**
 * Java8Time
 *
 * @author suchao
 * @date 2019/6/19
 */
public class Java8TimeTest2 {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        LocalDate localDate = now.plus(2, ChronoUnit.WEEKS);
        System.out.println(localDate);

        System.out.println("------------------");

        LocalDate localDate2 = now.minus(2, ChronoUnit.MONTHS);
        System.out.println(localDate2);

        System.out.println("------------------");

        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.millis());

        System.out.println("------------------");

        LocalDate localDate3 = LocalDate.now();
        LocalDate localDate4 = LocalDate.of(2019, 3, 9);

        System.out.println(localDate3.isBefore(localDate4));

        System.out.println("------------------");

        // 时区 Asia/Shanghai
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);

        Set<String> treeSet = new TreeSet<String>() {
            {
                addAll(availableZoneIds);
            }
        };
        treeSet.forEach(System.out::println);

        System.out.println("------------------");

        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(LocalDateTime.now(), zoneId);
        System.out.println(zonedDateTime);

        System.out.println("------------------");

        YearMonth yearMonth = YearMonth.now();
        System.out.println(yearMonth);
        System.out.println(yearMonth.lengthOfMonth());
        System.out.println(yearMonth.isLeapYear());

        System.out.println("------------------");

        YearMonth yearMonth2 = YearMonth.of(2016, 2);
        System.out.println(yearMonth2);
        System.out.println(yearMonth2.lengthOfMonth());
        System.out.println(yearMonth2.isLeapYear());

        System.out.println("------------------");

        LocalDate localDate5 = LocalDate.now();
        LocalDate localDate6 = LocalDate.of(2018, 1, 3);
        Period period = Period.between(localDate5, localDate6);
        Period period2 = Period.between(localDate6, localDate5);
        System.out.println(period);
        System.out.println(period2);
    }
}

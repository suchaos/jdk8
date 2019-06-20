package com.suchaos.time;

import java.time.*;
import java.util.Set;
import java.util.TimeZone;

/**
 * 时区相关
 *
 * @author suchao
 * @date 2019/6/20
 */
public class Java8TimeTest6 {

    public static void main(String[] args) {
        System.out.println("1. 打印所有时区信息");
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);

        ZoneId romeZone = ZoneId.of("Europe/Rome");
        ZoneId zoneId = TimeZone.getDefault().toZoneId();

        System.out.println("2. 为时间点添加时区信息");
        LocalDate date = LocalDate.now();
        ZonedDateTime zdt1 = date.atStartOfDay(romeZone);

        LocalDateTime dateTime = LocalDateTime.now();
        ZonedDateTime zdt2 = dateTime.atZone(romeZone);

        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(romeZone);

        System.out.println("3. LocalDateTime 与 Instant 之间通过 ZoneId 转换");
        LocalDateTime dateTime1 = LocalDateTime.now();
        Instant instantFromDateTime = dateTime1.atZone(romeZone).toInstant();

        Instant instant1 = Instant.now();
        LocalDateTime timeFromInstant = LocalDateTime.ofInstant(instant, romeZone);

        System.out.println("4. 利用和 UTC 的固定偏差计算时区");
        ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
        LocalDateTime dateTime2 = LocalDateTime.now();
        OffsetDateTime dateTimeInNewYork = OffsetDateTime.of(dateTime2, newYorkOffset);
        System.out.println(dateTimeInNewYork);

    }
}

package com.suchaos.time;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * 操纵日期
 *
 * @author suchao
 * @date 2019/6/20
 */
public class Java8TimeTest4 {

    public static void main(String[] args) {
        System.out.println("1. 以比较直观的方式操纵 LocalDate 的属性");
        LocalDate localDate1 = LocalDate.of(2019, 6, 20);
        LocalDate localDate2 = localDate1.withYear(2018);
        LocalDate localDate3 = localDate2.withDayOfMonth(25);
        LocalDate localDate4 = localDate3.with(ChronoField.MONTH_OF_YEAR, 9);

        System.out.println("-------------------");
        System.out.println("2. 以相对方式操纵 LocalDate 的属性");
        LocalDate localDate6 = localDate1.plusWeeks(2);
        LocalDate localDate7 = localDate6.minusYears(2);
        LocalDate localDate8 = localDate7.plus(6, ChronoUnit.MONTHS);

        System.out.println("-------------------");
        System.out.println("3. 使用 TemporalAdjuster 来操纵 LocalDate 的属性");
        LocalDate localDate9 = localDate1.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        LocalDate localDate10 = localDate1.with(TemporalAdjusters.lastDayOfMonth());
    }
}

package com.suchaos.time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;

/**
 * Java8Time
 *
 * @author suchao
 * @date 2019/6/19
 */
public class Java8TimeTest {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        System.out.println(localDate.getYear() + ", " +
                localDate.getMonthValue() + ", " + localDate.getDayOfMonth());

        System.out.println("-----------");

        LocalDate localDate2 = LocalDate.of(2017, 3, 3);
        System.out.println(localDate2);

        System.out.println("-----------");

        LocalDate localDate3 = LocalDate.of(2019, 5, 6);
        MonthDay monthDay = MonthDay.of(localDate3.getMonth(), localDate3.getDayOfMonth());
        MonthDay monthDay2 = MonthDay.from(LocalDate.of(2011, 5, 6));

        if (monthDay.equals(monthDay2)) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }

        System.out.println("-----------");

        LocalTime time = LocalTime.now();
        System.out.println(time);

        LocalTime time2 = time.plusHours(3).plusMinutes(20);
        System.out.println(time2);
    }
}

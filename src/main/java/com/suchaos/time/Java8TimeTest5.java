package com.suchaos.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

/**
 * 打印输出以及解析日期时间对象
 *
 * @author suchao
 * @date 2019/6/20
 */
public class Java8TimeTest5 {

    public static void main(String[] args) {
        System.out.println("1. 简单使用 DateTimeFormatter");
        LocalDate date = LocalDate.of(2014, 3, 18);
        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE); // 20140318
        String s2 = date.format(DateTimeFormatter.ISO_LOCAL_DATE); // 2014-03-18

        LocalDate date1 = LocalDate.parse("20140318", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date2 = LocalDate.parse("2014-03-18", DateTimeFormatter.ISO_LOCAL_DATE);

        System.out.println("2. 创建自定义的 DateTimeFormatter");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter italianFormatter = DateTimeFormatter.ofPattern("d. MMMM yyyy", Locale.ITALIAN);
        DateTimeFormatter italianFormatter2 = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.ITALIAN);

        LocalDate localDate = LocalDate.now();
        String format = localDate.format(italianFormatter);
        System.out.println(localDate.format(italianFormatter2)); // 20. giugno 2019
        LocalDate localDate2 = LocalDate.parse(format, italianFormatter); // 2019-06-20
    }
}

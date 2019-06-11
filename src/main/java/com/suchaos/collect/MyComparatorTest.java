package com.suchaos.collect;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 比较器的使用
 *
 * @author suchao
 * @date 2019/6/10
 */
public class MyComparatorTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("aaaaa", "bbbbb", "ccccc", "welcome");
        // list.sort(String::compareTo);

        // Collections.sort(list);
        System.out.println(list);

        System.out.println("-------------");

//        list.sort((item1, item2) -> item1.length() - item2.length());
        list.sort(Comparator.comparingInt(String::length).reversed());
//        list.sort(Comparator.comparingInt((String s) -> s.length()).reversed());
//        System.out.println(list);

        System.out.println("-----------------");
        //list.sort(Comparator.comparingInt(String::length).thenComparing(String::toUpperCase, Comparator.reverseOrder()));

//        list.sort(Comparator.comparingInt(String::length).reversed().
//                thenComparing(String::toUpperCase, Comparator.reverseOrder()));

        list.sort(Comparator.comparingInt(String::length).
                thenComparing(String::toUpperCase, Comparator.reverseOrder()).reversed());
        System.out.println(list);
    }
}

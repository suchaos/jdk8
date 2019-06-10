package com.suchaos.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 流的短路
 *
 * @author suchao
 * @date 2019/5/19
 */
public class StreamTest10 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world1", "hello world");
        list.stream().filter(s -> s.length() >= 5).findFirst().ifPresent(System.out::println);

        // 对流中的第一个数据进行第一个，第二个，第三个操作，而不是对所有的数据进行第一个操作，
        // 然后所有的数据去进行第二个操作，等等
        list.stream().filter(s -> {
            System.out.println(s);
            return s.length() >= 5;
        }).findFirst().ifPresent(System.out::println);
        System.out.println("-----------");
        list.stream().filter(s -> {
            System.out.println("op1: " + s);
            return s.length() >= 3;
        }).filter(s -> {
            System.out.println("op2: " + s);
            return s.length() >= 4;
        }).filter(s -> {
            System.out.println("op3: " + s);
            return s.length() >= 5;
        }).mapToInt(s -> {
            System.out.println("mapToInt: " + s);
            return s.length();
        }).findFirst().ifPresent(System.out::println);
    }
}

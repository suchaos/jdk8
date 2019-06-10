package com.suchaos.stream;

import java.util.stream.IntStream;

/**
 * 开始使用 stream
 *
 * @author suchao
 * @date 2019/5/19
 */
public class StreamTest2 {

    public static void main(String[] args) {
        IntStream.of(5, 6, 7).forEach(System.out::println);
        System.out.println("--------");

        IntStream.range(3, 8).forEach(System.out::println);
        System.out.println("--------");

        IntStream.rangeClosed(3, 8).forEach(System.out::println);
    }
}

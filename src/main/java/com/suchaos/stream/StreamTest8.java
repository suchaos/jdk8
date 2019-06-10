package com.suchaos.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 中间操作， 终止操作
 *
 * @author suchao
 * @date 2019/5/19
 */
public class StreamTest8 {

    public static void main(String[] args) {
        IntStream.iterate(0, i -> (i + 1) % 2).distinct().limit(3).forEach(System.out::println);
        System.out.println("end");
    }
}

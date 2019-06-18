package com.suchaos.stream.base;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 去重, flatMap 的使用
 *
 * @author suchao
 * @date 2019/5/19
 */
public class StreamTest11 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello world", "world welcome", "hello world welcome", "welcome hello");

        list.stream().map(s -> s.split(" ")).flatMap(Arrays::stream).distinct().forEach(System.out::println);

        list.stream().map(s -> s.split(" ")).distinct().map(Arrays::toString).forEach(System.out::println);
    }
}

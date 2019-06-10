package com.suchaos.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 进一步应用 stream
 *
 * @author suchao
 * @date 2019/5/19
 */
public class StreamTest5 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        System.out.println("---------------------");

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5);
        list2.stream().map(item -> item * item).collect(Collectors.toList()).forEach(System.out::println);
        list2.stream().map(item -> item * item).forEach(System.out::println);

        System.out.println("---------------------");

        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5));
        stream.flatMap(theList -> theList.stream()).map(item -> item * item).forEach(System.out::println);
    }
}

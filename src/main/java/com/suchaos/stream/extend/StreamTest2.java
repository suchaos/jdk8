package com.suchaos.stream.extend;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * stream
 *
 * @author suchao
 * @date 2019/6/17
 */
public class StreamTest2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome");

       // list.stream().forEach(System.out::println);

       list.stream().filter(item -> item.length() > 5).map(item -> item + "_xxx").forEach(System.out::println);
    }
}

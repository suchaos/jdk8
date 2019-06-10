package com.suchaos.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 创建流的三种方式
 *
 * @author suchao
 * @date 2019/5/19
 */
public class StreamCreateMethod {

    public static void main(String[] args) {
        Stream<String> stream1 = Stream.of("hello", "world", "hello world");

        String[] array = new String[]{"hello", "world", "hello world"};
        Stream<String> stream2 = Stream.of(array);
        Stream<String> stream3 = Arrays.stream(array);

        List<String> list = Arrays.asList(array);
        Stream<String> stream4 = list.stream();
    }
}

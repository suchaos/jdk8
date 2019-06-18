package com.suchaos.stream.extend;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

/**
 * onClose()
 *
 * @author suchao
 * @date 2019/6/13
 */
public class StreamTest1 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "welcome");

        try (Stream<String> stream = list.stream()) {
            stream.onClose(() -> {
                System.out.println("aaa");
                throw new RuntimeException("aaa exception");
            }).onClose(() -> {
                System.out.println("bbb");
                throw new NullPointerException();
            }).forEach(System.out::println);
        }
    }
}

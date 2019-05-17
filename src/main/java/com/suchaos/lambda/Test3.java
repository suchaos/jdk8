package com.suchaos.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@FunctionalInterface
interface InterfaceTwo {

    void method2();
}

@FunctionalInterface
interface InterfaceThree {

    void method3();
}

/**
 *  Lambda 一定要有上下文才能判断类型
 */
public class Test3 {

    public static void main(String[] args) {
        InterfaceTwo i2 = () -> {};
        System.out.println(i2.getClass().getInterfaces()[0]);

        InterfaceThree i3 = () -> {};
        System.out.println(i3.getClass().getInterfaces()[0]);

        new Thread(() -> System.out.println("hello lambda")).start();

        List<String> list = Arrays.asList("hello", "world", "hello world");
        list.forEach(s -> System.out.println(s.toUpperCase()));

        List<String> list2 = new ArrayList<>();
        list.forEach(s -> list2.add(s.toUpperCase()));
        list2.forEach(System.out::println);

        List<String> list3 = new ArrayList<>();
        // list.stream().map(item -> item.toUpperCase()).forEach(item -> System.out.println(item));
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        Function<String, String> function = String::toUpperCase;
        Function<String, String> function2 = item -> item.toUpperCase();
        System.out.println(Arrays.toString(function.getClass().getInterfaces()));
    }
}

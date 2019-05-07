package com.suchaos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        // list.stream().forEach();
    }
}

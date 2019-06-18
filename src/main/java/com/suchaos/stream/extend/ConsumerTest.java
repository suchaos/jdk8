package com.suchaos.stream.extend;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * ConsumerTest
 *
 * @author suchao
 * @date 2019/6/15
 */
public class ConsumerTest {

    public static  <T> void test(Consumer<T> consumer, T t) {
        consumer.accept(t);
    }
    public static void intTest(IntConsumer intConsumer, int t) {
        intConsumer.accept(t);
    }

    public static void test2(Consumer<? super Integer> consumer) {
        if (consumer instanceof IntConsumer) {
            System.out.println("instanceof success");
            intTest((IntConsumer) consumer, 100);
        } else {
            System.out.println("instanceof fail");
            intTest(consumer::accept, 100);
        }
    }

    public static void main(String[] args) {
        Consumer<Integer> integerConsumer = System.out::println;
        IntConsumer intConsumer = System.out::println;

        System.out.println(integerConsumer instanceof Consumer);
        System.out.println(intConsumer instanceof IntConsumer);

        test(integerConsumer, 100); // 面向对象的方式
        // test((Consumer<? super Integer>) intConsumer, 100);
        test(integerConsumer::accept, 100); // 函数式编程的方式，传递一种行为
        test(intConsumer::accept, 100); // 函数式编程的方式，传递一种行为

        System.out.println("-------------");
        test2(integerConsumer);
        test2(System.out::println);
    }
}

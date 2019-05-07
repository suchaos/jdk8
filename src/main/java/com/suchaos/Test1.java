package com.suchaos;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Lambda
 *
 * @author suchao
 * @date 2019/5/5
 */
public class Test1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        for (Integer i : list) {
            System.out.println(i);
        }

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        list.forEach((Integer value) -> System.out.println(value));

        list.forEach(value -> System.out.println(value));

        list.forEach(System.out::println);
    }
}

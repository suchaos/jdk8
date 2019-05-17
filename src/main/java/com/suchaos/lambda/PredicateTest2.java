package com.suchaos.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Predicate 学习
 *
 * @author suchao
 * @date 2019/5/13
 */
public class PredicateTest2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        conditionFilter(list, value -> value % 2 == 0);
        conditionFilter(list, value -> value > 5);
        conditionFilter(list, value -> true);
        conditionFilter(list, value -> false);

        conditionFilter2(list, value -> value > 5, value -> value % 2 == 0);

        System.out.println(isEquals("test").test("test"));
    }

    public static void conditionFilter(List<Integer> list, Predicate<Integer> predicate) {
        list.stream().filter(predicate).forEach(System.out::println);
        System.out.println("---------------");
    }

    public static void conditionFilter2(List<Integer> list, Predicate<Integer> predicate, Predicate<Integer> predicate2) {
        list.stream().filter(predicate.and(predicate2)).forEach(System.out::println);
        System.out.println("---------------");
    }

    public static Predicate<String> isEquals(Object o) {
        return Predicate.isEqual(o);
    }
}



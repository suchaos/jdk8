package com.suchaos.lambda;

import java.util.function.Predicate;

/**
 * PredicateTest
 *
 * @author suchao
 * @date 2019/5/13
 */
public class PredicateTest {

    public static void main(String[] args) {

        Predicate<String> predicate = p -> p.length() > 5;

        System.out.println(predicate.test("hello"));
    }
}

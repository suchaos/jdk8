package com.suchaos.optional;

import java.util.*;
import java.util.stream.Stream;

/**
 * 《 Java 攻略 》 6.2 从 Optional 中检索值
 *
 * @author suchao
 * @date 2019/5/17
 */
public class OptionalTest3 {

    public static void main(String[] args) {
        //检索第一个偶数长度的字符串
        Optional<String> firstEven = Stream.of("five", "even", "length", "string", "values")
                .filter(s -> s.length() % 2 == 0)
                .findFirst();

        //检索第一个奇数长度的字符串
        Optional<String> firstOdd = Stream.of("five", "even", "length", "string", "values")
                .filter(s -> s.length() % 2 != 0)
                .findFirst();

        System.out.println(firstEven.orElse("No even length string"));
        System.out.println(firstOdd.orElse("No odd length string"));
        System.out.println(firstOdd.orElseThrow(NoSuchElementException::new));
    }
}

package com.suchaos.optional;

import java.util.Optional;

/**
 * OptionalTest
 *
 * @author suchao
 * @date 2019/5/17
 */
public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");

        if (optional.isPresent()) {
            System.out.println(optional.get());
        }

        // 推荐的 Optional 使用方式
        optional.ifPresent(System.out::println);

        System.out.println("---");

        optional = Optional.empty();
        System.out.println(optional.orElse("World"));

        System.out.println("---");

        optional.orElseGet(() -> "nihao");
    }
}

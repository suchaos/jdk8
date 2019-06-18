package com.suchaos.stream.base;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * flatMap 打平操作
 *
 * @author suchao
 * @date 2019/5/19
 */
public class StreamTest12 {

    public static void main(String[] args) {
        List<String> list1 = Arrays.asList("Hi", "HelloJ", "你好");
        List<String> list2 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        list1.forEach(s -> {
            list2.forEach(name -> System.out.println(s + " " + name ));
        });

        List<String> collect = list1.stream().flatMap(item -> list2.stream().map(item2 -> item + " " + item2)).
                collect(Collectors.toList());
    }
}

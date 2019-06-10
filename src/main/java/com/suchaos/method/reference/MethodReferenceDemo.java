package com.suchaos.method.reference;

import java.util.Arrays;
import java.util.List;

/**
 * 使用方法引用
 *
 * @author suchao
 * @date 2019/5/17
 */
public class MethodReferenceDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello wrold");

        list.forEach(System.out::println);
    }
}

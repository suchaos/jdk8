package com.suchaos.stream;

import java.util.Arrays;
import java.util.List;

/**
 * 中间操作， 终止操作
 *
 * @author suchao
 * @date 2019/5/19
 */
public class StreamTest7 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");

        list.stream().map(item -> {
            String result = item.substring(0, 1).toUpperCase() + item.substring(1);
            System.out.println("test");
            return result;
        });
    }
}

package com.suchaos;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * java8 字符串排序
 *
 * @author suchao
 * @date 2019/5/7
 */
public class StringComparator {

    public static void main(String[] args) {
        List<String> namea = Arrays.asList("zhangsan", "lise", "wangwu", "zhaoliu");

        Collections.sort(namea, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });

        Collections.sort(namea, (o1, o2) -> o2.compareTo(o1));

        Collections.sort(namea, Comparator.reverseOrder());
    }
}

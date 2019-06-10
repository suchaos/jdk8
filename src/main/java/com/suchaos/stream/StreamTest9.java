package com.suchaos.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 串休流 与 并行流
 *
 * 比较时间应该使用一样的例子，这里只是简单说明
 *
 * @author suchao
 * @date 2019/5/19
 */
public class StreamTest9 {

    public static void main(String[] args) {
        testTime();
        testTime2();
    }

    public static void testTime() {
        System.out.println("串行流准备数据： ");
        long startPareData = System.nanoTime();
        List<String> list = new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; i++) {
            list.add(UUID.randomUUID().toString());
        }
        long endPareData = System.nanoTime();
        long startSort = System.nanoTime();
        System.out.println("串行流准备数据花费时间： " + TimeUnit.NANOSECONDS.toMillis(endPareData - startPareData));
        System.out.println("串行流开始排序： ");
        list.stream().sorted().count();
        long endSort = System.nanoTime();
        System.out.println("串行流排序花费时间： " + TimeUnit.NANOSECONDS.toMillis(endSort - startSort));
    }

    public static void testTime2() {
        System.out.println("并行流准备数据： ");
        long startPareData = System.nanoTime();
        List<String> list = new ArrayList<>(5000000);
        for (int i = 0; i < 5000000; i++) {
            list.add(UUID.randomUUID().toString());
        }
        long endPareData = System.nanoTime();
        long startSort = System.nanoTime();
        System.out.println("并行流准备数据花费时间： " + TimeUnit.NANOSECONDS.toMillis(endPareData - startPareData));
        System.out.println("并行流开始排序： ");
        list.parallelStream().sorted().count();
        long endSort = System.nanoTime();
        System.out.println("并行流排序花费时间： " + TimeUnit.NANOSECONDS.toMillis(endSort - startSort));
    }
}

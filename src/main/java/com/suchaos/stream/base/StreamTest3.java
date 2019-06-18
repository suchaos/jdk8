package com.suchaos.stream.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 进一步应用 stream
 *
 * @author suchao
 * @date 2019/5/19
 */
public class StreamTest3 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        long count = list.stream().map(value -> value * 2).reduce(0, Integer::sum);

        long count2 = list.stream().mapToInt(value -> value * 2).sum();
    }
}

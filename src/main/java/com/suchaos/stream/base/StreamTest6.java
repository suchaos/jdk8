package com.suchaos.stream.base;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/**
 * generate, iterate, empty
 *
 * @author suchao
 * @date 2019/5/19
 */
public class StreamTest6 {

    public static void main(String[] args) {
        Stream<String> stream = Stream.generate(UUID.randomUUID()::toString);
        // stream = Stream.empty();
        System.out.println(stream.findFirst().orElse("No UUID"));

        Stream.iterate(1, item -> item + 2).limit(6).forEach(System.out::println);

        System.out.println("----------");

        Integer result = Stream.iterate(1, item -> item + 2).limit(6)
                .filter(item -> item > 2).map(item -> item * 2)
                .skip(2).limit(2).reduce(0, Integer::sum);
        System.out.println(result);

        Optional<Integer> min = Stream.iterate(1, item -> item + 2).limit(6)
                .filter(item -> item > 2).map(item -> item * 2)
                .skip(2).limit(2).min(Integer::compareTo);

        System.out.println("----------------");
        Stream<Integer> integerStream = Stream.iterate(1, item -> item - 2).limit(6);
        List<Integer> integerList = integerStream.sorted().collect(Collectors.toList());
        integerList.forEach(System.out::println);
        System.out.println(integerList.stream().max(Integer::compareTo));
        // integerStream.max(Integer::compareTo);
        // integerStream.min(Integer::compareTo);

        IntSummaryStatistics intSummaryStatistics = Stream.iterate(1, item -> item + 2).limit(6)
                .filter(item -> item > 2).mapToInt(item -> item * 2)
                .skip(2).limit(2).summaryStatistics();

        System.out.println(intSummaryStatistics);
    }
}

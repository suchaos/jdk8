package com.suchaos.collect;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.UNORDERED;

/**
 * 学习 Characteristics 的不同
 *
 * @author suchao
 * @date 2019/6/11
 */
public class MyCollectorImpl2<T> implements Collector<T, Set<T>, Map<T, T>> {


    @Override
    public Supplier<Set<T>> supplier() {
        // return HashSet::new;
        return () -> {
            System.out.println("---------------");
            return new HashSet<>();
        };
        // return ConcurrentSkipListSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        return (set, item) -> {
            System.out.println("accumulator consumer,  set: " + set + " ,thread: " + Thread.currentThread().getName());
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        return (set1, set2) -> {
            System.out.println("combiner operator,  set1: " + set1 + " , set2: " + set2 + " ,thread: " +
                    Thread.currentThread().getName());
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        return set -> {
            System.out.println("finisher function");
            Map<T, T> map = new HashMap<>();
            set.forEach(item -> map.put(item, item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        // return Collections.unmodifiableSet(EnumSet.of(UNORDERED, IDENTITY_FINISH));
        //return Collections.unmodifiableSet(EnumSet.of(UNORDERED));
        // return Collections.unmodifiableSet(null);
        return Collections.emptySet();
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world", "d", "e", "d", "a", "b");
        // Map<String, String> collect = list.stream().collect(new MyCollectorImpl2<>());
        for (int i = 0; i < 1; i++) {
            Map<String, String> collect = list.parallelStream().collect(new MyCollectorImpl2<>());
            System.out.println(collect);
        }
    }
}

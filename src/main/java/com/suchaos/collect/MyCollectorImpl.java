package com.suchaos.collect;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.*;

/**
 * MyCollectorImpl
 *
 * @author suchao
 * @date 2019/6/11
 */
public class MyCollectorImpl<T> implements Collector<T, Set<T>, Set<T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        return Set::add;
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Set<T>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(UNORDERED, IDENTITY_FINISH));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world", "hello world");
        Set<String> set = list.stream().collect(new MyCollectorImpl<>());
        System.out.println(set);
    }
}

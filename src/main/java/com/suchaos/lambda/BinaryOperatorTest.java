package com.suchaos.lambda;

import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * BinaryOperator
 *
 * @author suchao
 * @date 2019/5/15
 */
public class BinaryOperatorTest {

    public static void main(String[] args) {
        System.out.println(compute(1, 2, (a, b) -> a + b));
        BinaryOperatorTest.<Integer, Integer, Integer>compute2 (1, 2, (a, b) -> a + b);

        getMin("a", "ab", (a, b) -> a.length() - b.length());
        getMin("a", "ab", Comparator.comparingInt(String::length));


    }

    public static <T> T compute(T input1, T input2, BinaryOperator<T> binaryOperator) {
        return binaryOperator.apply(input1, input2);
    }

    public static <T, U, R> R compute2(T input1, U input2, BiFunction<T, U, R> biFunction) {
        return biFunction.apply(input1, input2);
    }

    public static <T> T getMin(T a, T b, Comparator<? super T> comparator) {
        return BinaryOperator.<T>minBy(comparator).apply(a, b);
    }
}

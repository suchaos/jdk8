package com.suchaos.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 学习使用 Function 的方法
 *
 * @author suchao
 * @date 2019/5/12
 */
public class FunctionTest2 {

    public static void main(String[] args) {
        FunctionTest2 test = new FunctionTest2();
        test.compute(2, value -> value * 3, value -> value * value);  // 12
        test.compute2(2, value -> value * 3, value -> value * value);  // 36

        test.compute3(1, 2, (value1, value2) -> value1 + value2);
        test.compute3(1, 2, (value1, value2) -> value1 - value2);
        test.compute3(1, 2, (value1, value2) -> value1 * value2);
        test.compute3(1, 2, (value1, value2) -> value1 / value2);

        test.compute4(1, 2, (value1, value2) -> value1 + value2, value -> value * value);
    }

    public int compute(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }

    public int compute2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }

    public int compute3(int a, int b, BiFunction<Integer, Integer, Integer> biFunction) {
        return biFunction.apply(a, b);
    }

    public int compute4(int a, int b, BiFunction<Integer, Integer, Integer> biFunction, Function<Integer, Integer> function)  {
        return biFunction.andThen(function).apply(a, b);
    }
}

package com.suchaos.lambda;

import java.util.function.Function;

/**
 * Function 练习
 *
 * @author suchao
 * @date 2019/5/7
 */
public class FunctionTest {

    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();

        System.out.println(test.compute(1, value -> 2 * value));
        System.out.println(test.compute(2, value -> 5 + value));
        System.out.println(test.addTwo(1));

        System.out.println(test.convert(5, value -> String.valueOf(value + " hello")));
    }

    public int compute(int a, Function<Integer, Integer> function) {
        return function.apply(a);
    }

    public String convert(int a, Function<Integer, String> function) {
        return function.apply(a);
    }

    public int addTwo(int a) {
        return 2 + a;
    }

    public int x5(int a) {
        return a * 5;
    }

//    public <T, R> R convert(T a, Function<T, R> function) {
//        return function.apply(a);
//    }
}

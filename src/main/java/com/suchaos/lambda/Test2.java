package com.suchaos.lambda;

import java.util.Arrays;

@FunctionalInterface
interface InterfaceOne {

    void test();

    @Override
    String toString();
}

public class Test2 {

    public void myTest(InterfaceOne interfaceOne) {
        interfaceOne.test();
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();

        test2.myTest(() -> System.out.println("mytest"));

        InterfaceOne interfaceOne = () -> {
            System.out.println("hello");
        };

        System.out.println(interfaceOne.getClass());
        System.out.println(interfaceOne.getClass().getSuperclass());
        System.out.println(Arrays.toString(interfaceOne.getClass().getInterfaces()));
    }
}

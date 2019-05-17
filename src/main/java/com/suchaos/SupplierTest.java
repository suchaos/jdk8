package com.suchaos;

import java.util.function.Supplier;

/**
 * Supplier 初体验
 *
 * @author suchao
 * @date 2019/5/15
 */
public class SupplierTest {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "Hello Suppiler";
        System.out.println(supplier.get());
    }
}

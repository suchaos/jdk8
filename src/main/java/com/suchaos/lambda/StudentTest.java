package com.suchaos.lambda;

import java.util.function.Supplier;

/**
 * Supplier 使用
 *
 * @author suchao
 * @date 2019/5/15
 */
public class StudentTest {

    public static void main(String[] args) {
        Supplier<Student> studentSupplier = Student::new;
        System.out.println(studentSupplier.get());
    }
}

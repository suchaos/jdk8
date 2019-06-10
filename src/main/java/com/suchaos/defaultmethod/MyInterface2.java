package com.suchaos.defaultmethod;

/**
 * 写接口的默认方法
 *
 * @author suchao
 * @date 2019/5/18
 */
public interface MyInterface2 {

    default void myMethod() {
        System.out.println("MyInterface2 default method");
    }
}

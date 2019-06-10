package com.suchaos.defaultmethod;

/**
 * 使用接口的默认方法
 *
 * 当两个
 *
 * @author suchao
 * @date 2019/5/18
 */
public class MyClass implements MyInterface1, MyInterface2 {

    @Override
    public void myMethod() {
        MyInterface2.super.myMethod();
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        myClass.myMethod();

        MyInterface1 myInterface1 = new MyClass();
        myInterface1.myMethod();
    }
}

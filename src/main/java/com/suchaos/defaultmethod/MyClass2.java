package com.suchaos.defaultmethod;

/**
 * 使用接口的默认方法
 *
 * 实现类的优先级比接口更高
 *
 * @author suchao
 * @date 2019/5/18
 */
public class MyClass2 extends MyInterface1Impl implements MyInterface2 {

    public static void main(String[] args) {
        MyClass2 myClass = new MyClass2();
        myClass.myMethod();

        MyInterface1 myInterface1 = new MyClass2();
        myInterface1.myMethod();
    }
}

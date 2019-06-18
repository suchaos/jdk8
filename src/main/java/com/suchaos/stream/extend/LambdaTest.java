package com.suchaos.stream.extend;

/**
 * Lambda
 *
 * @author suchao
 * @date 2019/6/18
 */
public class LambdaTest {

    Runnable r1 = () -> System.out.println(this);

    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            System.out.println(this);
        }
    };

    public static void main(String[] args) throws InterruptedException {
        LambdaTest lambdaTest = new LambdaTest();
        System.out.println(lambdaTest);

        System.out.println("-----------");

        Thread t1 = new Thread(lambdaTest.r1);
        t1.start();
        t1.join();

        System.out.println("-----------");

        Thread t2 = new Thread(lambdaTest.r2);
        t2.start();
    }
}

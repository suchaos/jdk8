package com.suchaos.lambda;

/**
 * ObjectMethodFunctionalInterface
 *
 * @author suchao
 * @date 2019/5/5
 */
@FunctionalInterface
public interface ObjectMethodFunctionalInterface {
    void count(int i);

    String toString(); //same to Object.toString
    int hashCode(); //same to Object.hashCode
    boolean equals(Object obj); //same to Object.equals
}

package com.suchaos;

/**
 * WrongObjectMethodFunctionalInterface
 *
 * @author suchao
 * @date 2019/5/5
 */
@FunctionalInterface
public interface WrongObjectMethodFunctionalInterface {
    void count(int i);

    //Object clone(); //Object.clone is protected
}

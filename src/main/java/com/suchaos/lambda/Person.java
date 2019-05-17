package com.suchaos.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Person 用来演示 BiFunction
 *
 * @author suchao
 * @date 2019/5/13
 */
@Data
@AllArgsConstructor
public class Person {

    private String username;

    private int age;
}

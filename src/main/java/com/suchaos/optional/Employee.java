package com.suchaos.optional;

import lombok.Builder;
import lombok.Data;

/**
 * 员工，演示 Optional 的使用
 *
 * @author suchao
 * @date 2019/5/17
 */
@Data
@Builder
public class Employee {

    private String name;
}

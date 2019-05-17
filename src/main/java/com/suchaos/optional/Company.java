package com.suchaos.optional;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 公司，演示 Optional 的使用
 *
 * @author suchao
 * @date 2019/5/17
 */
@Data
@Builder
public class Company {

    private String name;

    private List<Employee> employees;
}

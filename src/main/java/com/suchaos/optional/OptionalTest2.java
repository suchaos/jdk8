package com.suchaos.optional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Optional 对集合的使用
 *
 * @author suchao
 * @date 2019/5/17
 */
public class OptionalTest2 {

    public static void main(String[] args) {
        Employee employee = Employee.builder().name("zhangsan").build();
        Employee employee2 = Employee.builder().name("lisi").build();

        Company company = Company.builder().name("company1").
                employees(Arrays.asList(employee, employee2)).build();

        // company = Company.builder().name("company1").build();

        Optional<Company> optionalCompany = Optional.ofNullable(company);
        List<Employee> employees = optionalCompany.map(Company::getEmployees).orElseGet(Collections::emptyList);
        employees.forEach(System.out::println);
    }
}

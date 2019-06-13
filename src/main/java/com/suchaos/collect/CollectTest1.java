package com.suchaos.collect;

import com.suchaos.lambda.Person;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * 使用 collect
 *
 * @author suchao
 * @date 2019/5/27
 */
public class CollectTest1 {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 80);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 100);
        Student student4 = new Student("zhaoliu", 80);
        Student student5 = new Student("zhaoliu", 80);

        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5);

        List<Student> students1 = students.stream().filter(student -> student.getScore() > 60).
                collect(toList());

        long count = students.stream().filter(student -> student.getScore() > 60).
                collect(counting());
        long count2 = students.stream().filter(student -> student.getScore() > 60).count();

        System.out.println("-------------------");

        Optional<Student> min = students.stream().min((s1, s2) -> s1.getScore() > s2.getScore() ? 1 : 0);
        Optional<Student> min2 = students.stream().min(Comparator.comparingInt(Student::getScore));

        System.out.println("-------------------");

        System.out.println(students.stream().map(Student::getName).collect(Collectors.joining(";")));
        System.out.println(students.stream().map(Student::getName).
                collect(Collectors.joining(";", "start: ", " end!")));

        System.out.println("-------------------");

        Map<Integer, Map<String, List<Student>>> collect = students.stream().collect(Collectors.groupingBy(Student::getScore, Collectors.groupingBy(Student::getName)));
        System.out.println(collect);

        System.out.println("-------------------");

        Map<Boolean, Long> collect1 = students.stream().collect(Collectors.groupingBy(student -> student.getScore() > 80, counting()));
        System.out.println(collect1);

        System.out.println("-------------------");

        Map<String, Student> collect2 = students.stream().collect(Collectors.groupingBy(Student::getName,
                Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(Student::getScore)), Optional::get)));

        Map<String, Optional<Student>> collect3 = students.stream().collect(Collectors.groupingBy(Student::getName,
                Collectors.minBy(Comparator.comparingInt(Student::getScore))));
        System.out.println(collect2);


        Map<String, Student> studentMap = students.stream().
                collect(groupingBy(Student::getName, collectingAndThen(
                        maxBy(Comparator.comparingInt(Student::getScore)), Optional::get)));

        Set<String> collect4 = students.stream().filter(student -> student.getName() != null).
                map(student -> student.getName() + student.getScore()).collect(toSet());
        System.out.println(collect4);
    }
}

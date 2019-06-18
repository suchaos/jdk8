package com.suchaos.stream.base;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 分组
 *
 * @author suchao
 * @date 2019/5/19
 */
public class StreamTest13 {

    public static void main(String[] args) {

        Student student1 = new Student("zhangsan", 100, 20);
        Student student2 = new Student("lisi", 90, 20);
        Student student3 = new Student("wangwu", 90, 30);
        Student student4 = new Student("zhangsan", 80, 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        // select * from student group by name;
        Map<String, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getName));
        collect.forEach((key, value) -> {
            System.out.println("key: " + key);
            value.forEach(System.out::println);
            System.out.println("------------");
        });

        System.out.println("**************");

        Map<String, List<Student>> collect3 = students.stream().collect(Collectors.groupingBy(student -> {
            int score = student.getScore();
            if (score > 90) {
                return "A";
            } else if (score > 80) {
                return "B";
            } else if (score > 60) {
                return "C";
            } else {
                return "D";
            }
        }));

        collect3.forEach((key, value) -> {
            System.out.println("key: " + key);
            value.forEach(System.out::println);
            System.out.println("------------");
        });

        // select name, count(*) from student group by name;
        Map<String, Long> stringLongMap = students.stream().
                collect(Collectors.groupingBy(Student::getName, Collectors.counting()));
        System.out.println(stringLongMap);

        System.out.println("**************");

        // select name, average(*) from student group by name;
        Map<String, Double> collect1 = students.stream().
                collect(Collectors.groupingBy(Student::getName, Collectors.averagingDouble(Student::getScore)));
        System.out.println(collect1);

        System.out.println("*******************");

        Map<Boolean, List<Student>> collect2 = students.stream().
                collect(Collectors.partitioningBy(student -> student.getScore() >= 90));

        students.stream().
                collect(Collectors.partitioningBy(student -> student.getScore() >= 90));
    }
}

@Data
@AllArgsConstructor
class Student {
    private String name;
    private int score;
    private int age;
}

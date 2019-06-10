package com.suchaos.method.reference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * 方法引用
 *
 * @author suchao
 * @date 2019/5/18
 */
public class MethodReferenceTest {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan", 10);
        Student student2 = new Student("lisi", 90);
        Student student3 = new Student("wangwu", 50);
        Student student4 = new Student("zhaoliu", 40);

        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        students.sort((s1, s2) -> Student.compareStudentByScore(s1, s2));
        students.sort(Student::compareStudentByScore);

        students.sort(Comparator.comparingInt(Student::getScore));
        students.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));

        students.forEach(System.out::println);

        StudentComparator studentComparator = new StudentComparator();
        students.sort((s1, s2) -> studentComparator.compareStudentByScore(s1, s2));
        students.sort(studentComparator::compareStudentByScore);

        students.sort((s1, s2) -> s1.compareByScore(s2));
        students.sort(Student::compareByScore);

        System.out.println("---------------------------------");

        List<String> cities = Arrays.asList("dalian", "beijing", "shanghai", "hangzhou");

        cities.sort(String::compareToIgnoreCase);

        Supplier<Student> studentSupplier = Student::new;
        BiFunction<String, Integer, Student> biFunction = Student::new;
        Student biStudent = biFunction.apply("suchao", 18);
        System.out.println(biStudent);

    }
}

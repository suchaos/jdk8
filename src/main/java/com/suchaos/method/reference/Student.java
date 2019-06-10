package com.suchaos.method.reference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Student, 用来演示方法引用
 *
 * @author suchao
 * @date 2019/5/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String name;

    private int score;

    public static int compareStudentByScore(Student a, Student b) {
        return a.getScore() - b.getScore();
    }

    public static int compareStudentByName(Student a, Student b) {
        return a.getName().compareToIgnoreCase(b.getName());
    }

    public int compareByScore(Student student) {
        return this.getScore() - student.getScore();
    }

    public int compareByName(Student student) {
        return this.getName().compareToIgnoreCase(student.getName());
    }
}

package com.suchaos.method.reference;

import java.util.Comparator;

/**
 * 引用::实例方法 的例子
 *
 * @author suchao
 * @date 2019/5/18
 */
public class StudentComparator {

    public int compareStudentByScore(Student o1, Student o2) {
        return o1.getScore() - o2.getScore();
    }

    public static int compareStudentByName(Student a, Student b) {
        return a.getName().compareToIgnoreCase(b.getName());
    }
}

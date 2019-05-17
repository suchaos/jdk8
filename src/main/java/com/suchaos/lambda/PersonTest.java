package com.suchaos.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * 对集合进行筛选
 *
 * @author suchao
 * @date 2019/5/13
 */
public class PersonTest {

    public static void main(String[] args) {
        Person person1 = new Person("zhangsan", 20);
        Person person2 = new Person("lisi", 30);
        Person person3 = new Person("wangwu", 40);

        List<Person> people = Arrays.asList(person1, person2, person3);

        List<Person> result = getPersonByUsername("zhangsan", people);
        result.forEach(System.out::println);

        BiFunction<Integer, List<Person>, List<Person>> biFunction =
                (ageOfPerson, peopleList) -> peopleList.stream().
                        filter(person -> person.getAge() > ageOfPerson).
                        collect(Collectors.toList());
        List<Person> list = getPersonByAge2(20, people, biFunction);
        list.forEach(System.out::println);
    }

    public static List<Person> getPersonByUsername(String username, List<Person> people) {
        return people.stream().
                filter(person -> person.getUsername().equals(username)).
                collect(Collectors.toList());
    }

    public static List<Person> getPersonByAge(int age, List<Person> people) {
        BiFunction<Integer, List<Person>, List<Person>> biFunction =
                (ageOfPerson, peopleList) -> peopleList.stream().
                        filter(person -> person.getAge() > ageOfPerson).
                        collect(Collectors.toList());
        return biFunction.apply(age, people);
    }

    public static List<Person> getPersonByAge2(int age, List<Person> people, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, people);
    }


}

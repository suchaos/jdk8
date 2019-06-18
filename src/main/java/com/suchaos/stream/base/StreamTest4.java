package com.suchaos.stream.base;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 进一步应用 stream
 *
 * @author suchao
 * @date 2019/5/19
 */
public class StreamTest4 {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "hello world");

        // String[] strings1 = stream.toArray(length -> new String[length]);
        String[] strings = stream.toArray(String[]::new);
        System.out.println(Arrays.toString(strings));

        Stream<String> stream2 = Stream.of("hello", "world", "hello world");
        List<String> list2 = stream2.collect(Collectors.toList());

        Stream<String> stream3 = Stream.of("hello", "world", "hello world");
        // Stream<String> stream3 = Stream.of("hello", "world", "hello world").parallel();
        List<String> list3 = stream3.collect(() -> {
                    System.out.println("create a new ArrayList");
                    return new ArrayList<>();
                },
                (theList, item) -> {
                    System.out.println("add one time");
                    theList.add(item);
                },
                (theList1, theList2) -> {
                    System.out.println("combine one time");
                    theList1.addAll(theList2);
                });
        //List<String> list3 = stream3.collect(ArrayList::new, List::add, List::addAll);

        list3.forEach(System.out::println);

        String[] strings1 = {"a", "c", "e", "f"};
        String collect = String.join("::", strings1);
        System.out.println(collect);

        List<String> stringList = new ArrayList<>(Arrays.asList(strings1));
        String join = String.join("::", stringList);
        System.out.println(join);

        StringBuilder stringBuilder = stringList.stream().collect(StringBuilder::new, StringBuilder::append,
                StringBuilder::append);
        System.out.println(stringBuilder);

        Stream<String> stream1 = Arrays.stream(new String[]{"a", "c", "e", "f"});
        LinkedList<String> linkedList = stream1.collect(Collectors.toCollection(LinkedList::new));
        linkedList.forEach(System.out::println);

        Set<String> stringSet = stream1.collect(Collectors.toCollection(TreeSet::new));

    }
}

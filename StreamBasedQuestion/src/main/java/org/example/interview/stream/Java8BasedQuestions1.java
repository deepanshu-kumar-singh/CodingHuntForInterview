package org.example.interview.stream;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Java8BasedQuestions1 {
    public static void main(String[] args) {
        // 1. Write a Java 8 program using a lambda expression to add two integers.
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(5, 3));

//        2. Write a Java 8 program to filter and print even numbers from a list.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list = numbers.stream()
                .filter(x -> x % 2 == 0)
                .toList();
        System.out.println("even numbers: " + list);
//        3. Write a Java 8 program to map integers to their squares and print results.
        List<Integer> list1 = numbers.stream()
                .map(x -> x * x)
                .toList();
        System.out.println(list1);
//        4. Write a Java 8 program to find and print the maximum value from a list.
        Integer i = numbers.stream()
                .max(Comparator.comparingDouble(x -> x))
                .get();
        System.out.println(i);
//        5. Write a Java 8 program to count and print the number of elements in a list.
        long count = numbers.stream()
                .count();
        System.out.println(count);
//        7. Write a Java 8 program to print the lengths of strings in a list.
        List<String> words = Arrays.asList("Java", "Python", "JavaScript");
        Map<String, Long> collect = words.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(collect);
//        Write a Java 8 program to print names sorted in alphabetical order from a list.
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob");
        List<String> list2 = names.stream()
                .sorted().toList();
        System.out.println(list2);
    }
}

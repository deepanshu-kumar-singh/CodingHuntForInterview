package org.example.regularPractise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day6 {
    public static void main(String[] args) {
      //  1.Write a program to find the first non-repeating character in a string using streams.
        String str = "abacdbef";
        Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x->x.getValue()==1)
                .map(Map.Entry::getKey)
                .findFirst()
                .ifPresent(System.out::println);

       // 2.Given a string, Find Maximum Occurring Character in a String:
        String input = "aabbbccccddddddee";
        Optional<Map.Entry<String, Long>> max = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());
        System.out.println(max.get());

       // 4.Given an array of integers, find the kth largest element.
        List<Integer> list = Arrays.asList(1, 12, 44, 32, 52, 81, 59, 84, 72, 37);
        int k = 4;
        List<Integer> first1 = list.stream()
                .sorted(Comparator.reverseOrder()).toList();
        System.out.println(first1);
        Optional<Integer> first = list.stream()
                .sorted(Comparator.reverseOrder())
                .limit(k)
                .skip(k-1)
                .findFirst();
        System.out.println(first.get());

    }
}

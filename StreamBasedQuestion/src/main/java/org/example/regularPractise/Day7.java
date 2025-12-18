package org.example.regularPractise;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day7 {
    public static void main(String[] args) {
 /*       1.) Determine the highest value present in a numeric list
        2.) Determine the lowest value present in a numeric list
        3.) Compute how many times each element appears in a list
        4.) Calculate the frequency of every character in a given string
        5.) Separate and display even and odd numbers from a list
        6.) Join two different lists into a single stream result
        7.) Divide a list into even-numbered and odd-numbered elements
        8.) Extract the word with maximum length from a sentence
        9.) Eliminate duplicate entries from a collection
        10.) Find elements that exist in both lists
        11.) Detect and display repeated values from a list
        12.) Identify characters that occur more than once in a string
        13.) Find the first character that appears multiple times in a string
        14.) Compute the aggregate sum of all numbers in a list
        15.) Identify the second smallest and second largest values
        16.) Filter numbers whose first digit is 1
        17.) Calculate the sum of even numbers using reduction logic
        18.) Validate whether a number is prime using Stream operations
        19.) Identify missing values within a sorted numeric sequence
        20.) Sort a list of strings while safely ignoring null entries*/


        String string = "Deepanshu";
        List<Integer> list = Arrays.asList(2,5,7,22,67,4,13,5,2,78);
        List<Integer> li = Arrays.asList(2,5,7,3);
        String sentence = "Java streams are very powerful and expressive";
        List<String> str= Arrays.asList("apple", "orange", "onion", "banana");
        Integer i = list.stream().sorted(Comparator.reverseOrder()).findFirst().get();
        System.out.println("highest value: " + i);

        Integer i1 = list.stream().sorted().findFirst().get();
        System.out.println("lowest value: "+i1);

        Map<Integer, Long> collect =
                list.stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("times each element appears: "+collect);

        Map<String, Long> collect1 = Arrays.stream(string.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("frequency of every character: "+collect1);

        Map<Boolean, List<Integer>> collect2 = list.stream().collect(Collectors.partitioningBy(x -> x % 2 == 0));
        System.out.println(collect2);

        List<Integer> list1 = Stream.of(li, list).flatMap(Collection::stream).toList();
        System.out.println(list1);

        Optional<String> max = Arrays.stream(sentence.split(" "))
                .max(Comparator.comparingInt(String::length));
        System.out.println(max);


    }
}

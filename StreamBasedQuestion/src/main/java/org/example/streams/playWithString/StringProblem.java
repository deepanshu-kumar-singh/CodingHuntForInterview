package org.example.streams.playWithString;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringProblem {
    public static void main(String[] args) {

        //unique
        List<String> words = List.of("apple", "banana", "apple", "cat", "banana", "apple");
        List<String> list = words.stream().distinct().toList();
        System.out.println("unique strings :" + list);

        //count of each word
        Map<String, Long> collect = words.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("count of each word :" + collect);

        //longest string
        Optional<String> max = words.stream().max(Comparator.comparingInt(String::length));
        System.out.println("longest string :"+ max.get());

        //filter duplicate
        List<String> list3 = words.stream()
                .collect(
                        Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(list3);

        //find string start with digit
        List<String> word = List.of("1apple", "ba1nana", "app1le", "cat", "banana", "apple");
        List<String> list1 = word.stream().filter(x -> Character.isDigit(x.charAt(0))).toList();
        System.out.println(list1);

        //find all string contains digit
        List<String> list2 = word.stream().filter(x -> x.matches(".*\\d.*")).toList();
        System.out.println(list2);
    }
}
